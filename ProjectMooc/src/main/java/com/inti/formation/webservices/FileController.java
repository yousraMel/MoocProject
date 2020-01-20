package com.inti.formation.webservices;
import com.inti.formation.handlers.ResponseHandler;
import com.inti.formation.iservices.IFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/apiFile")
public class FileController {
	@Autowired
    private  IFileService FILE_SERVICE;


//    public FileController(IFileService file_service) {
//        FILE_SERVICE = file_service;
//    }

    @PostMapping("/uploadFile/{id}/")
    public ResponseHandler uploadFile(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) {
        return new ResponseHandler(HttpStatus.OK, FILE_SERVICE.storeImage(file, id));
    }

    @PostMapping("/uploadFiles/{id}")
    public ResponseHandler uploadMultiplyFiles(@PathVariable("id") Long id, @RequestParam("file") MultipartFile[] files) {
        return new ResponseHandler(HttpStatus.OK, FILE_SERVICE.storeImages(files, id));
    }

    @DeleteMapping("/{id}/deleteFile")
    public ResponseHandler RemoveFile() {
        return null;
    }

    @DeleteMapping("/{id}/deleteAllFiles")
    public ResponseHandler RemoveAllFiles() {
        return null;
    }
}
