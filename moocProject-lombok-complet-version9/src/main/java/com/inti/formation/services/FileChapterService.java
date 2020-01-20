package com.inti.formation.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inti.formation.entities.ChapterFile;
import com.inti.formation.exeptions.BadRequestHandler;
import com.inti.formation.exeptions.InternalServerErrorHandler;
import com.inti.formation.iservices.IChapterService;
import com.inti.formation.iservices.IFileChapterService;
import com.inti.formation.iservices.IStorageService;
import com.inti.formation.repositories.IFileChapterRepository;



@Service
public class FileChapterService implements IFileChapterService {
@Autowired
    private  IFileChapterRepository FILE_REPOSITORY;
@Autowired
    private  IStorageService STORE_SERVICE;
@Autowired
    private  IChapterService AUCTION_SERVICE;



    @Override
    public ChapterFile create(ChapterFile object) {
        if (FILE_REPOSITORY.findById(object.getId()).isPresent())
            throw new BadRequestHandler("This Id already exist!");

        ChapterFile newChapterFile = FILE_REPOSITORY.save(object);

        if (newChapterFile == null)
            throw new InternalServerErrorHandler("Oops something went wrong! could not create object!");

        return newChapterFile;
    }

    @Override
    public ChapterFile read(Long id) {
        if (id == 0)
            throw new BadRequestHandler("No valid auction id provided!");

        return FILE_REPOSITORY.findById(id).orElseThrow(() -> new BadRequestHandler("No file/ChapterFile found with id:" + id));
    }

    @Override
    public void update(ChapterFile object) {
        //No need to update a ChapterFile/File
    }

    @Override
    public void delete(ChapterFile object) {
        ChapterFile removeObject = FILE_REPOSITORY.findById(object.getId()).orElseThrow(() ->
                new BadRequestHandler("No car was found with that id!"));

        FILE_REPOSITORY.delete(removeObject);
    }

    @Override
    public ChapterFile storeChapter(MultipartFile file, Long id) {
        // Get the file and save it somewhere
        String filePath = STORE_SERVICE.store(file, id);
  Long i=(long) 0;
        ChapterFile newChapterFile = new ChapterFile();
        
        newChapterFile.setId(id+i);
        newChapterFile.setPath(filePath);

       return create(newChapterFile);
    }

    @Override
    public List<ChapterFile> storeChapters(MultipartFile[] files, Long id) {
        List<ChapterFile> ChapterFileList = new ArrayList<>();
        if(files == null)
            throw new BadRequestHandler("No files provided! please try again");

        for (MultipartFile file: files) {
            // Get the file and save it somewhere
            String filePath = STORE_SERVICE.store(file, id);

            ChapterFile _ChapterFile = new ChapterFile();
            _ChapterFile.setId(id);
            _ChapterFile.setChapter(AUCTION_SERVICE.getByIdChapter(id));
            _ChapterFile.setPath(filePath);

            ChapterFileList.add(create(_ChapterFile));
        }

        AUCTION_SERVICE.mergeNewChapterFiles(id, ChapterFileList);

        return ChapterFileList;
    }


}
