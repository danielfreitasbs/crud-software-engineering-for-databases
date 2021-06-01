package com.danielfreitasbs.agendavacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danielfreitasbs.agendavacinacao.entity.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {

}
