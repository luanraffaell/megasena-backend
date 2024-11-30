package com.luan.mega.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luan.mega.entities.Concurso;

@Repository
public interface ConcursoRepository extends JpaRepository<Concurso, Long> {
	
	Optional<Concurso> findDistinctByNumeros(String numeros);
	Concurso findFirstByOrderByConcursoNumeroDesc();

}
