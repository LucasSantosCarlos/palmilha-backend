package com.example.palmilha_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.palmilha_backend.model.Amostra;

public interface AmostraRepository extends JpaRepository<Amostra, Long> {

	List<Amostra> findAllbySessaoId(Long idSessao);

}
