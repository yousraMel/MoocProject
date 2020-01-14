package com.inti.formation.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity

public class VideoChapter extends Video{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name="chapter_id")
	private Chapter chapter; 

}
