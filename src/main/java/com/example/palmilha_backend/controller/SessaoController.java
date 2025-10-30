package com.example.palmilha_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.palmilha_backend.dto.SessaoDto;
import com.example.palmilha_backend.service.SessaoService;

@RestController
@RequestMapping("/sessao")
public class SessaoController {

	@Autowired
	private SessaoService sessaoService;
	
	@GetMapping("/all")
	public ResponseEntity<List<SessaoDto>> buscarTodas(){
		return ResponseEntity.ok(sessaoService.buscarTodas());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SessaoDto> buscar(@PathVariable Long id){
		return ResponseEntity.ok(sessaoService.buscarSessao(id));
	}
	
	@PostMapping
	public ResponseEntity<SessaoDto> salvar(@RequestBody SessaoDto sessaoDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(sessaoService.salvar(sessaoDto));
	}
}
