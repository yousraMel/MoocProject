package com.inti.formation.webServices;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inti.formation.exeptions.ResponseHandler;
import com.inti.formation.iservices.IFileCourseService;
import com.inti.formation.iservices.IFileService;

@RestController
@RequestMapping("/apiFileCourse")
@CrossOrigin(origins="*")
public class FileCourseController {
	@Autowired
    private  IFileCourseService FILE_SERVICE;


//    public FileController(IFileService file_service) {
//        FILE_SERVICE = file_service;
//    }

    @PostMapping("/uploadFileCourse")
    public ResponseHandler uploadFileCourse( @RequestParam("file") MultipartFile file) {
    	
    	Long idCourse = (long) 777;
        return new ResponseHandler(HttpStatus.OK, FILE_SERVICE.storeCourse(file, idCourse));
    }

    @PostMapping("/uploadFilesCourse/{id}")
    public ResponseHandler uploadMultiplyFilesCourse(@PathVariable("id") Long id, @RequestParam("file") MultipartFile[] files) {
        return new ResponseHandler(HttpStatus.OK, FILE_SERVICE.storeCourses(files, id));
    }

    @DeleteMapping("/{id}/deleteFileCourse")
    public ResponseHandler RemoveFileCourse() {
        return null;
    }

    @DeleteMapping("/{id}/deleteAllFilesCourse")
    public ResponseHandler RemoveAllFilesCourse() {
        return null;
    }
}
