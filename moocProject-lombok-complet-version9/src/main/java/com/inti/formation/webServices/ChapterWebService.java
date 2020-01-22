package com.inti.formation.webServices;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Chapter;
import com.inti.formation.entities.Course;
import com.inti.formation.iservices.IChapterService;
import com.inti.formation.iservices.ICourseService;

@RestController
@RequestMapping("/apiChapters")
@CrossOrigin(origins="*")
public class ChapterWebService {
	@Autowired
	private IChapterService chapterService;

	@Autowired
	private ICourseService courseService;

	@RequestMapping(value = "/save/{idCourse}", method = RequestMethod.POST)
	public Chapter save(@RequestBody Chapter chapter, BindingResult result, @PathVariable Long idCourse) {
		Course course = courseService.getByIdCourse(idCourse);
		chapter.setCourse(course);
		return chapterService.saveOrUpdateChapter(chapter);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Chapter update(@RequestBody Chapter c) {

		return chapterService.saveOrUpdateChapter(c);
	}

	@RequestMapping(value = "/get/{idChapter}", method = RequestMethod.GET)
	public Chapter getById(@PathVariable("idChapter") Long idChapter) {
		return chapterService.getByIdChapter(idChapter);
	}

	@RequestMapping(value = "/delete/{idChapter}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("idChapter") Long idChapter) {
		chapterService.deleteChapter(idChapter);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Chapter> findAll() {

		return chapterService.gatAllChapter();
	}
	@RequestMapping(value = "/getChapterByCourse/{idCourse}", method = RequestMethod.GET)
	public List<Chapter> getChapterByCourse(@PathVariable Long idCourse) {

		return chapterService.getChaptersByCourseIdCourse(idCourse);
	}
}