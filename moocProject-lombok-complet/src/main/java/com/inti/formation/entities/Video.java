package com.inti.formation.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@MappedSuperclass
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public abstract class Video implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVideo;
	private String title;
	private String format;
	@JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "KK:mm:ss")
	private Date length;


}
