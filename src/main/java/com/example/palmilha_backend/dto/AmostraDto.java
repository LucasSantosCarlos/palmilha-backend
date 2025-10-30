package com.example.palmilha_backend.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AmostraDto {
	private Long id;
	private SessaoDto sessao;
	private LocalDateTime ts;
	private Integer s1;
	private Integer s2;
	private Integer s3;
	private Integer s4;
	private Integer s5;
	private Integer s6;
}
