package com.inti.formation.iservice;

import java.util.List;

import com.inti.formation.entites.Chapter;

public interface IChapterService {

	public Chapter saveOrUpdateChapter (Chapter c);
	public  void deleteChapter (Long id );
	public Chapter getByIdChapter (Long id );
	public List<Chapter> getAllChapter ();
	
}
