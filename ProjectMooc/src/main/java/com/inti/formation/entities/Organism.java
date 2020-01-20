package com.inti.formation.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Organism {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrganism;
	private String organismName;
	private String organismSpeciality;
	private String organismDocumentation;
	private String turnover;
	private String email;
	private String phoneNumber;
	private String webSite;
	private String password;
	@OneToMany(mappedBy="organism")

	private List<Image> images;
	

	public Long getIdOrganism() {
		return idOrganism;
	}

	public void setIdOrganism(Long idOrganism) {
		this.idOrganism = idOrganism;
	}

	public String getOrganismName() {
		return organismName;
	}

	public void setOrganismName(String organismName) {
		this.organismName = organismName;
	}

	public String getOrganismSpeciality() {
		return organismSpeciality;
	}

	public void setOrganismSpeciality(String organismSpeciality) {
		this.organismSpeciality = organismSpeciality;
	}

	public String getOrganismDocumentation() {
		return organismDocumentation;
	}

	public void setOrganismDocumentation(String organismDocumentation) {
		this.organismDocumentation = organismDocumentation;
	}

	public String getTurnover() {
		return turnover;
	}

	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Organism() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Organism(Long idOrganism, String organismName, String organismSpeciality, String organismDocumentation,
			String turnover, String email, String phoneNumber, String webSite, String password, List<Image> images) {
		super();
		this.idOrganism = idOrganism;
		this.organismName = organismName;
		this.organismSpeciality = organismSpeciality;
		this.organismDocumentation = organismDocumentation;
		this.turnover = turnover;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.webSite = webSite;
		this.password = password;
		this.images = images;
	}
	public Organism(Long idOrganism, String organismName, String organismSpeciality, String organismDocumentation,
			String turnover, String email, String phoneNumber, String webSite, String password) {
		super();
		this.idOrganism = idOrganism;
		this.organismName = organismName;
		this.organismSpeciality = organismSpeciality;
		this.organismDocumentation = organismDocumentation;
		this.turnover = turnover;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.webSite = webSite;
		this.password = password;
		
	}
	@Override
	public String toString() {
		return "Organism [idOrganism=" + idOrganism + ", organismName=" + organismName + ", organismSpeciality="
				+ organismSpeciality + ", organismDocumentation=" + organismDocumentation + ", turnover=" + turnover
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", webSite=" + webSite + ", password="
				+ password + ", images=" + images + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
