package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Chapter;
import com.inti.formation.iservices.IChapterService;
import com.inti.formation.repositories.IChapterRepository;

@Service
public class ChapterService implements IChapterService {
    @Autowired
    private IChapterRepository repo;
    
	@Override
	public Chapter saveOrUpdateChapter(Chapter c) {
 
		return repo.save(c);
	}

	@Override
	public void deleteChapter(Long idChapter) {
	 
		repo.deleteById(idChapter);
	}

	@Override
	public Chapter getByIdChapter(Long idChapter) {
		 
		return repo.findById(idChapter).get();
	}

	@Override
	public List<Chapter> gatAllChapter() {
	 
		return repo.findAll();
	}

}
