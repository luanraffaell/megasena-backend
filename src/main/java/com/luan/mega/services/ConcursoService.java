package com.luan.mega.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.luan.mega.dto.ConcursoRequestDTO;
import com.luan.mega.dto.ConcursoResponseDTO;
import com.luan.mega.entities.Concurso;
import com.luan.mega.repository.ConcursoRepository;
@Service
public class ConcursoService {
	
	private ConcursoRepository concursoRespository;
	
	public ConcursoService(ConcursoRepository concursoRespository) {
		this.concursoRespository = concursoRespository;
	}

	public ConcursoResponseDTO generateRandomNumber() {
		Random random = new Random();
        Set<Integer> numeros = new HashSet<>();

        while (numeros.size() < 6) {
            int numero = random.nextInt(60) + 1; // Gera números entre 1 e 60
            numeros.add(numero);
        }

        // Converter para lista e ordenar
        List<Integer> listaNumeros = new ArrayList<>(numeros);
        Collections.sort(listaNumeros);
        
        return checkIfSequenceExists(listaNumeros);
		
	}
	
	public ConcursoResponseDTO createConcurso(ConcursoRequestDTO concurso) {
		String numeros = concurso.numeros().stream().sorted().map(String::valueOf).collect(Collectors.joining("-"));
		Concurso newConcurso = new Concurso(concurso.concursoNumero(),concurso.data(),numeros);
		return new ConcursoResponseDTO(this.concursoRespository.save(newConcurso));
	}
	 
	public ConcursoResponseDTO checkIfSequenceExists(List<Integer> listaNumeros){
		listaNumeros = listaNumeros.stream().sorted().toList();
		String numeros = listaNumeros.stream().map(String::valueOf)
				.collect(Collectors.joining("-"));
		Optional<Concurso> distinctByNumeros = this.concursoRespository.findDistinctByNumeros(numeros);
		if(distinctByNumeros.isPresent()) {
			return new ConcursoResponseDTO(listaNumeros, distinctByNumeros.get());
		}
		 return new ConcursoResponseDTO(listaNumeros);
	}
	public ConcursoResponseDTO getLastRegister() {
		Concurso concurso = this.concursoRespository.findFirstByOrderByConcursoNumeroDesc();
		
		return new ConcursoResponseDTO(concurso);
	}
}
