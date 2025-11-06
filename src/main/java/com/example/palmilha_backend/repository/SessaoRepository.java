package com.example.palmilha_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.palmilha_backend.model.Sessao;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {

	List<Sessao> findAllByOrderByIniciadoEmDesc();

}
