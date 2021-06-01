package com.danielfreitasbs.agendavacinacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielfreitasbs.agendavacinacao.entity.Allergie;
import com.danielfreitasbs.agendavacinacao.entity.User;
import com.danielfreitasbs.agendavacinacao.service.AllergieService;

@RestController
@RequestMapping("/allergie")
public class AllergieController {

	@Autowired
	private AllergieService allergieService;

	@GetMapping
	public List<?> findAll() {
		return allergieService.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable long id) {
		Allergie allergie = allergieService.findById(id);
		return ResponseEntity.ok().body(allergie);
	}

	@PostMapping
	public Allergie create(@RequestBody Allergie allergie) {
		return allergieService.insert(allergie);
	}

	@PutMapping
	public ResponseEntity<Allergie> update(@RequestBody Allergie allergie) {
		Allergie allergieResponse = allergieService.update(allergie);

		return ResponseEntity.ok().body(allergieResponse);

	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable long id) {
		allergieService.delete(id);
		return ResponseEntity.ok().build();
	}
}
