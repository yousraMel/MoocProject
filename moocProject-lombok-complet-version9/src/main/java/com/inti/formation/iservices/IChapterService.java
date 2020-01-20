package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Chapter;
import com.inti.formation.entities.ChapterFile;
import com.inti.formation.entities.CourseFile;
import com.inti.formation.entities.Image;

public interface IChapterService {

	public Chapter saveOrUpdateChapter(Chapter c);
	public  void deleteChapter(Long idChapter);
	public Chapter getByIdChapter(Long idChapter);
	public List<Chapter> gatAllChapter();
	public void mergeNewChapterFiles(Long idChapter, List<ChapterFile> chapters);
	
}
