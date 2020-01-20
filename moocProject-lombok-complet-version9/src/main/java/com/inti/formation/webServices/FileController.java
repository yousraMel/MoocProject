package com.inti.formation.webServices;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inti.formation.exeptions.ResponseHandler;
import com.inti.formation.iservices.IFileService;

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
