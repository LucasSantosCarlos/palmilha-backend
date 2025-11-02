package com.example.palmilha_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassadaSensorDto {
	private Long id;
	private PassadaDto passada;
	private Short sensorIdx;
	private Double media;
	private Integer pico;
	private Integer integral;
	
}
