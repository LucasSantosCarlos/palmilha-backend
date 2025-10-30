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
public class SessaoDto {
	private Long id;
	private LocalDateTime iniciadoEm;
	private LocalDateTime finalizadoEm;
	private String notas;
	private List<AmostraDto> amostras;
	private List<PassadaDto> passadas;
	private MapaPalmilhaDto mapaPalmilha;
}
