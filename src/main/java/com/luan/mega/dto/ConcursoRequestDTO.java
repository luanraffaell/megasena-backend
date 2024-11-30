package com.luan.mega.dto;

import java.time.LocalDate;
import java.util.List;

public record ConcursoRequestDTO(Long concursoNumero,LocalDate data, List<Integer> numeros) {

}
