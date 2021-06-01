package com.danielfreitasbs.agendavacinacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielfreitasbs.agendavacinacao.entity.Vaccine;
import com.danielfreitasbs.agendavacinacao.exception.ObjectNotFoundException;
import com.danielfreitasbs.agendavacinacao.repository.VaccineRepository;

@Service
public class VaccineService {

	@Autowired
	private VaccineRepository vaccineRepo;

	public Vaccine insert(Vaccine vaccine) {
		vaccine.setId(null);
		return vaccineRepo.save(vaccine);
	}

	public List<Vaccine> findAll() {
		return vaccineRepo.findAll();
	}

	public Vaccine findById(Integer id) {
		Optional<Vaccine> vaccine = vaccineRepo.findById(id);
		return vaccine.orElseThrow(() -> new ObjectNotFoundException("Alergia não encontrado"));
	}

	public void delete(Integer id) {
		vaccineRepo.deleteById(id);
	}

	public Vaccine update(Vaccine vaccine) {
		return vaccineRepo.save(vaccine);
	}
}
