package com.luan.mega.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.luan.mega.entities.Concurso;

@JsonInclude(Include.NON_NULL)
public class ConcursoResponseDTO {
	private Long id;
	private List<Integer> numerosGerados;
	private Long concursoNumero;
	private LocalDate data;
	private String numeros;
	private Boolean numeroJaSorteado;
	
	public ConcursoResponseDTO() {
		// TODO Auto-generated constructor stub
	}
	

	public ConcursoResponseDTO(List<Integer> numerosGerados) {
		this.numerosGerados = numerosGerados;
		this.numeroJaSorteado = false;
	}
	public ConcursoResponseDTO(Concurso concurso) {
		this.id = concurso.getId();
		this.concursoNumero = concurso.getConcursoNumero();
		this.data = concurso.getData();
		this.numeros = concurso.getNumeros();
	}

	public ConcursoResponseDTO(List<Integer> numerosGerados, Concurso concurso) {
		super();
		this.numerosGerados = numerosGerados;
		this.concursoNumero = concurso.getConcursoNumero();
		this.data = concurso.getData();
		this.numeros = concurso.getNumeros();
		this.numeroJaSorteado = true;
	}
	
	
	public Long getId() {
		return id;
	}


	public List<Integer> getNumerosGerados() {
		return numerosGerados;
	}

	public void setNumerosGerados(List<Integer> numerosGerados) {
		this.numerosGerados = numerosGerados;
	}

	public Long getConcursoNumero() {
		return concursoNumero;
	}

	public void setConcursoNumero(Long concursoNumero) {
		this.concursoNumero = concursoNumero;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getNumeros() {
		return numeros;
	}

	public void setNumeros(String numeros) {
		this.numeros = numeros;
	}


	public Boolean getNumeroJaSorteado() {
		return numeroJaSorteado;
	}


	public void setNumeroJaSorteado(Boolean numeroJaSorteado) {
		this.numeroJaSorteado = numeroJaSorteado;
	}
	
	
}
