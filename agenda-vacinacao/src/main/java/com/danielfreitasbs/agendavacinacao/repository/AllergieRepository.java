package com.danielfreitasbs.agendavacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danielfreitasbs.agendavacinacao.entity.Allergie;

@Repository
public interface AllergieRepository extends JpaRepository<Allergie, Long> {

}
