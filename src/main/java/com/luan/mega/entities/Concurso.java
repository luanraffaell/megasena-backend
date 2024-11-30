package com.luan.mega.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Concurso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long concursoNumero;
	private LocalDate data;
	private String numeros;
	
	public Concurso() {
	}

	public Concurso(Long concursoNumero, LocalDate data, String numeros) {
		this.concursoNumero = concursoNumero;
		this.data = data;
		this.numeros = numeros;
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

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Concurso [id=" + id + ", concursoNumero=" + concursoNumero + ", data=" + data + ", numeros=" + numeros
				+ "]";
	}
	
}
