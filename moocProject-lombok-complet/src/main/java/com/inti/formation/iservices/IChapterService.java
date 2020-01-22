package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Chapter;

public interface IChapterService {

	public Chapter saveOrUpdateChapter(Chapter c);
	public  void deleteChapter(Long idChapter);
	public Chapter getByIdChapter(Long idChapter);
	public List<Chapter> gatAllChapter();
	
}
