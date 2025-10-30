package com.example.palmilha_backend.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassadaDto {
	private Long id;
	private SessaoDto sessao;
	private Integer idx;
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private Integer contatoMs;
	private String contatoInicial;
	private Integer picoTotal;
	private Double razaoMedial;
	private List<PassadaSensorDto> itens;
}
