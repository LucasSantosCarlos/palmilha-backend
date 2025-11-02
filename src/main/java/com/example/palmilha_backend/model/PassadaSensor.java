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
@Table(name = "PASSADA_SENSOR")
public class PassadaSensor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "passada_id", referencedColumnName = "id")
	private Passada passada;
	
	@Column(name = "sensor_idx")
	private Short sensorIdx;

	@Column(name = "media", columnDefinition = "NUMERIC(6,2)")
	private Double media;
	
	@Column(name = "pico")
	private Integer pico;
	
	@Column(name = "integral")
	private Integer integral;
	
}
