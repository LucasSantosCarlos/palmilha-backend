package com.example.palmilha_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.palmilha_backend.model.PassadaSensor;

public interface PassadaSensorRepository extends JpaRepository<PassadaSensor, Long> {

	List<PassadaSensor> findAllByPassadaId(Long idPassada);

}
