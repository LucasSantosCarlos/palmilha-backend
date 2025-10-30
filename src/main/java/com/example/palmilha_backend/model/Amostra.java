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
@Table(name = "AMOSTRA")
public class Amostra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "sessao_id", referencedColumnName = "id")
	private Sessao sessao;
	
	@Column(name = "ts")
	private LocalDateTime ts;

	@Column(name = "s1")
	private Integer s1;
	
	@Column(name = "s2")
	private Integer s2;
	
	@Column(name = "s3")
	private Integer s3;
	
	@Column(name = "s4")
	private Integer s4;
	
	@Column(name = "s5")
	private Integer s5;
	
	@Column(name = "s6")
	private Integer s6;
}
