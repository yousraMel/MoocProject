package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Video;

public interface IVideoService {
	
	public Video saveOrUpdateVideo(Video v);
	public void deleteVideo(Long id);
	public Video getByIdVideo(Long id);
	public List<Video> getAllVideo();

}
