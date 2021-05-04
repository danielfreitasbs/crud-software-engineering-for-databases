package com.danielfreitasbs.softbd.agenda.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	public Schedule() {
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public char getPeriod() {
		return period;
	}

	public void setPeriod(char period) {
		this.period = period;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDose() {
		return dose;
	}

	public void setDose(Integer dose) {
		this.dose = dose;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getSituation() {
		return situation;
	}

	public void setSituation(Integer situation) {
		this.situation = situation;
	}

	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

}
