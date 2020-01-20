package com.inti.formation.iservices;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.inti.formation.entities.CourseFile;
import com.inti.formation.utils.CrudOperation;

public interface IFileCourseService extends CrudOperation<CourseFile> {

	CourseFile storeCourse(MultipartFile file, Long id);

    List<CourseFile> storeCourses(MultipartFile[] files, Long id);
}
