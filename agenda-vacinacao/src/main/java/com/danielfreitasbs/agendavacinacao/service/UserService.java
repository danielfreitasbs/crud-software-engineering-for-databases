package com.danielfreitasbs.agendavacinacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielfreitasbs.agendavacinacao.entity.User;
import com.danielfreitasbs.agendavacinacao.exception.ObjectNotFoundException;
import com.danielfreitasbs.agendavacinacao.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User insert(User user) {
		user.setId(null);
		return userRepo.save(user);
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = userRepo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}

	public void delete(Long id) {
		userRepo.deleteById(id);
	}

	public User update(User user) {
		return userRepo.save(user);
	}
}
