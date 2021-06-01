package com.danielfreitasbs.agendavacinacao.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Vaccine implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 4477147895777561598L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;
	private String description;
	private int doses;
	private int frequency;
	private int interval;

	@OneToMany(mappedBy = "vaccine")
	private Set<Schedule> schedules;

}
