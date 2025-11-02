package com.example.palmilha_backend.model;

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
@Table(name = "MAPA_PALMILHA")
public class MapaPalmilha {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "sessao_id", referencedColumnName = "id")
	private Sessao sessao;

	@Column(name = "sensor_idx")
	private Short sensorIdx;

	@Column(name = "x_norm", columnDefinition = "NUMERIC(4,2)")
	private Double posicaoX;

	@Column(name = "y_norm", columnDefinition = "NUMERIC(4,2)")
	private Double posicaoY;

}
