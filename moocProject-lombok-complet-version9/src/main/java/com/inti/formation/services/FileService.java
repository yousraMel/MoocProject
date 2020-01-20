package com.inti.formation.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inti.formation.entities.Image;
import com.inti.formation.exeptions.BadRequestHandler;
import com.inti.formation.exeptions.InternalServerErrorHandler;
import com.inti.formation.iservices.IFileService;
import com.inti.formation.iservices.IOrganismService;
import com.inti.formation.iservices.IStorageService;
import com.inti.formation.repositories.IFileRepository;


@Service
public class FileService implements IFileService {
@Autowired
    private  IFileRepository FILE_REPOSITORY;
@Autowired
    private  IStorageService STORE_SERVICE;
@Autowired
    private  IOrganismService AUCTION_SERVICE;


//    public FileService(IFileRepository file_repository, IStorageService store_service, IOrganismService auction_service) {
//        FILE_REPOSITORY = file_repository;
//        STORE_SERVICE = store_service;
//        AUCTION_SERVICE = auction_service;
//    }

    @Override
    public Image create(Image object) {
        if (FILE_REPOSITORY.findById(object.getId()).isPresent())
            throw new BadRequestHandler("This Id already exist!");

        Image newImage = FILE_REPOSITORY.save(object);

        if (newImage == null)
            throw new InternalServerErrorHandler("Oops something went wrong! could not create object!");

        return newImage;
    }

    @Override
    public Image read(Long id) {
        if (id == 0)
            throw new BadRequestHandler("No valid auction id provided!");

        return FILE_REPOSITORY.findById(id).orElseThrow(() -> new BadRequestHandler("No file/image found with id:" + id));
    }

    @Override
    public void update(Image object) {
        //No need to update a Image/File
    }

    @Override
    public void delete(Image object) {
        Image removeObject = FILE_REPOSITORY.findById(object.getId()).orElseThrow(() ->
                new BadRequestHandler("No car was found with that id!"));

        FILE_REPOSITORY.delete(removeObject);
    }

    @Override
    public Image storeImage(MultipartFile file, Long id) {
        // Get the file and save it somewhere
        String filePath = STORE_SERVICE.store(file, id);
  Long i=(long) 0;
        Image newImage = new Image();
        
        newImage.setId(id+i);
        newImage.setOrganism(AUCTION_SERVICE.getByIdOrganism(id));
        newImage.setPath(filePath);

       return create(newImage);
    }

    @Override
    public List<Image> storeImages(MultipartFile[] files, Long id) {
        List<Image> imageList = new ArrayList<>();
        if(files == null)
            throw new BadRequestHandler("No files provided! please try again");

        for (MultipartFile file: files) {
            // Get the file and save it somewhere
            String filePath = STORE_SERVICE.store(file, id);

            Image _image = new Image();
            _image.setId(id);
            _image.setOrganism(AUCTION_SERVICE.getByIdOrganism(id));
            _image.setPath(filePath);

            imageList.add(create(_image));
        }

        AUCTION_SERVICE.mergeNewImages(id, imageList);

        return imageList;
    }
}
