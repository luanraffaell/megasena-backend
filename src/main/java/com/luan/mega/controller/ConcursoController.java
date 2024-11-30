package com.luan.mega.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luan.mega.dto.ConcursoRequestDTO;
import com.luan.mega.dto.ConcursoResponseDTO;
import com.luan.mega.dto.SearchNumbersDTO;
import com.luan.mega.services.ConcursoService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/concursos")
public class ConcursoController {
	
	private ConcursoService consursoService;
	
	public ConcursoController(ConcursoService consursoService) {
		this.consursoService = consursoService;
	}
	
	@GetMapping("/generate")
	public ResponseEntity<ConcursoResponseDTO> getRandomNumbers(){
		return ResponseEntity.ok(this.consursoService.generateRandomNumber());
	}
	
	@PostMapping("/create")
	public ResponseEntity<ConcursoResponseDTO> createConcurso(@RequestBody ConcursoRequestDTO concurso){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(this.consursoService.createConcurso(concurso));
	}
	@PostMapping("/search")
	public ResponseEntity<ConcursoResponseDTO> searchConcurso(@RequestBody SearchNumbersDTO numeros){
		ConcursoResponseDTO checkIfSequenceExists = this.consursoService.checkIfSequenceExists(numeros.numeros());
		return ResponseEntity.ok(checkIfSequenceExists);
	}
	
	@GetMapping("/last")
	public ResponseEntity<ConcursoResponseDTO> getLast(){
		return ResponseEntity.ok(this.consursoService.getLastRegister());
	}
	
}
