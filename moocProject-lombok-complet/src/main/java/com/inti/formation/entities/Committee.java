package com.inti.formation.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Committee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCommittee;
	private String committeeName;
	private static int nbrOfMemebers;

	public Committee(String committeeName) {
		this.committeeName = committeeName;
		setNbrOfMemebers(getNbrOfMemebers() + 1);
	}

	public static int getNbrOfMemebers() {
		return nbrOfMemebers;
	}

	public static void setNbrOfMemebers(int nbrOfMemebers) {
		Committee.nbrOfMemebers = nbrOfMemebers;
	}

}
