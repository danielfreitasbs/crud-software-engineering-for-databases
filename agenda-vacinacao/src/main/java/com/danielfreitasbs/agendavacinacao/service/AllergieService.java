package com.danielfreitasbs.agendavacinacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielfreitasbs.agendavacinacao.entity.Allergie;
import com.danielfreitasbs.agendavacinacao.exception.ObjectNotFoundException;
import com.danielfreitasbs.agendavacinacao.repository.AllergieRepository;

@Service
public class AllergieService {
	
	@Autowired
	private AllergieRepository allergieRepo;

	public Allergie insert(Allergie allergie) {
		allergie.setId(null);
		return allergieRepo.save(allergie);
	}

	public List<Allergie> findAll() {
		return allergieRepo.findAll();
	}

	public Allergie findById(Long id) {
		Optional<Allergie> allergie = allergieRepo.findById(id);
		return allergie.orElseThrow(() -> new ObjectNotFoundException("Alergia não encontrado"));
	}

	public void delete(Long id) {
		allergieRepo.deleteById(id);
	}

	public Allergie update(Allergie allergie) {
		return allergieRepo.save(allergie);
	}
}
