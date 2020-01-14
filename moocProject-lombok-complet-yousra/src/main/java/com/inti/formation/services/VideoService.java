package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Video;
import com.inti.formation.iservices.IVideoService;
import com.inti.formation.repositories.VideoRepository;

@Service
public class VideoService implements IVideoService {

	@Autowired
	private VideoRepository repo;

	@Override
	public Video saveOrUpdateVideo(Video v) {
		return repo.save(v);
	}

	@Override
	public void deleteVideo(Long id) {
		repo.delete(repo.getOne(id));
	}

	@Override
	public Video getByIdVideo(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Video> getAllVideo() {
		return repo.findAll();
	}

}
