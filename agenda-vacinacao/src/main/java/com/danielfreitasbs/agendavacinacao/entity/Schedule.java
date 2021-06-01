package com.danielfreitasbs.agendavacinacao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Schedule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2626699385804201532L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer code;
	private char period;
	private String patient;
	private String cpf;
	private Date date;
	private Integer dose;
	private String local;
	private Integer situation;
	private Date dischargeDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_vaccine")
	private Vaccine vaccine;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_user")
	private User user;

}
