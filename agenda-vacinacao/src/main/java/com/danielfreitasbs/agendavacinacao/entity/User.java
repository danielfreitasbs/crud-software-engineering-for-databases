package com.danielfreitasbs.agendavacinacao.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4076349223487658954L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Date dtNasc;
	private char gender;
	private String publicPlace;
	private Long number;
	private String sector;
	private String city;
	private char[] uf;

	@ManyToMany
	private Set<Allergie> allergies;

	@OneToMany(mappedBy = "user")
	private Set<User> users;

}
