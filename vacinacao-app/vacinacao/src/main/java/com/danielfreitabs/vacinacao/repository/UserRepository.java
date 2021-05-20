package com.danielfreitabs.vacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielfreitabs.vacinacao.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
