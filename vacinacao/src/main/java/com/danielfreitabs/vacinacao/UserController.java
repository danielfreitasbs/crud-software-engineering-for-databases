package com.danielfreitabs.vacinacao;

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

import com.danielfreitabs.vacinacao.model.User;
import com.danielfreitabs.vacinacao.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping
	public List<?> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public User create(@RequestBody User user) {
		return repository.save(user);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody User user) {
		return repository.findById(id).map(record -> {

			record.setCity(user.getCity());
			record.setDtNasc(user.getDtNasc());
			record.setGender(user.getGender());
			record.setName(user.getName());
			record.setNumber(user.getNumber());
			record.setPublicPlace(user.getPublicPlace());
			record.setSector(user.getSector());
			record.setUf(user.getUf());

			User updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable long id) {
	   return repository.findById(id)
	           .map(record -> {
	               repository.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
}
