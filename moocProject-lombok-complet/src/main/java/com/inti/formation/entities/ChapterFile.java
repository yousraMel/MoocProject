package com.inti.formation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
public class ChapterFile {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String path;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_chapter")
    private Chapter chapter;

	public ChapterFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChapterFile(Long id, @NotEmpty String path, @NotNull Chapter chapter) {
		super();
		this.id = id;
		this.path = path;
		this.chapter = chapter;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
