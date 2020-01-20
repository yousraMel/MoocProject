package com.inti.formation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity

public class Image {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String path;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_organism")
    private Organism organism;

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Image(Long id, @NotEmpty String path, @NotNull Organism organism) {
		super();
		this.id = id;
		this.path = path;
		this.organism = organism;
	}
	public Image( @NotEmpty String path, @NotNull Organism organism) {
		super();
		
		this.path = path;
		this.organism = organism;
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

	public Organism getOrganism() {
		return organism;
	}

	public void setOrganism(Organism organism) {
		this.organism = organism;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", path=" + path + ", organism=" + organism + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    





	
    
}
