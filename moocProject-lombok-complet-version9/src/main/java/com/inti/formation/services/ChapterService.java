package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Chapter;
import com.inti.formation.entities.ChapterFile;
import com.inti.formation.exeptions.BadRequestHandler;
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

	@Override
	public void mergeNewChapterFiles(Long id, List<ChapterFile> imageList) {
		
	        if (id == 0 || imageList == null)
	            throw new BadRequestHandler("No valid auction id or Image list provided!");

	        Chapter chapter= getByIdChapter(id);
	        chapter.setChapterFiles(imageList);
	        saveOrUpdateChapter(chapter);
	    }
		
	}

