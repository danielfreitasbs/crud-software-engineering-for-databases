package com.danielfreitabs.vacinacao.controller.dto;

import java.util.Date;

import com.danielfreitabs.vacinacao.model.User;

public class UserDto {

	private String name;
	private Date dtNasc;
	private char gender;
	private String publicPlace;
	private Long number;
	private String sector;
	private String city;
	private char[] uf;

	public User converter() {
		User user = new User();
		user.setCity(city);
		user.setDtNasc(dtNasc);
		user.setGender(gender);
		user.setName(name);
		user.setNumber(number);
		user.setPublicPlace(publicPlace);
		user.setSector(sector);
		user.setUf(uf);

		return user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public char[] getUf() {
		return uf;
	}

	public void setUf(char[] uf) {
		this.uf = uf;
	}

}
