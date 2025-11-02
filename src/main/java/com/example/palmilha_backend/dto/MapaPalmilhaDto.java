package com.example.palmilha_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MapaPalmilhaDto {
	private Long id;
	private SessaoDto sessao;
	private Short sensorIdx;
	private Double posicaoX;
	private Double posicaoY;

}
