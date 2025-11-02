package com.example.palmilha_backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PASSADA")
public class Passada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "sessao_id", referencedColumnName = "id")
	private Sessao sessao;
	
	@Column(name = "idx")
	private Integer idx;

	@Column(name = "ts_inicio")
	private LocalDateTime inicio;
	
	@Column(name = "ts_fim")
	private LocalDateTime fim;
	
	@Column(name = "contato_ms")
	private Integer contatoMs;
	
	@Column(name = "contato_inicial")
	private String contatoInicial;
	
	@Column(name = "pico_total")
	private Integer picoTotal;
	
	@Column(name = "razao_medial", columnDefinition = "NUMERIC(5,2)")
	private Double razaoMedial;
}
