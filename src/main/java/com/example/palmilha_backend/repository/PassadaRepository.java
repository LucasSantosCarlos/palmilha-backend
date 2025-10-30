package com.example.palmilha_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.palmilha_backend.model.Passada;

public interface PassadaRepository extends JpaRepository<Passada, Long> {

	List<Passada> findAllbySessaoId(Long idSessao);

}
