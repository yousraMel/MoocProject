package com.inti.formation.services;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.inti.formation.entities.StorageProperties;
import com.inti.formation.handlers.InternalServerErrorHandler;
import com.inti.formation.iservices.IStorageService;

@Service
public class StorageService implements IStorageService {

    public final Path rootLocation;
    

    public Path getRootLocation() {
		return rootLocation;
	}

	@Autowired
    public StorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new InternalServerErrorHandler("Could not initialize storage location");
        }
    }

    @Override
    public String store(MultipartFile file, Long id) {

        final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Random r = new Random();
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++)
            sb.append(alphabet.charAt(r.nextInt(alphabet.length())));

        //add unique auction id and file type
        sb.append(id + "." + file.getContentType().split("/")[1]);

        String filename = sb.toString();

        try {
            if (file.isEmpty()) {
                throw new InternalServerErrorHandler("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new InternalServerErrorHandler(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new InternalServerErrorHandler("Failed to store file " + filename);
        }

        return load(filename).toString();
    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void delete(File file) {
        FileSystemUtils.deleteRecursively(file);
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
}
