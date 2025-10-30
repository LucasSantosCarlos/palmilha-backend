package com.example.palmilha_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.palmilha_backend.dto.SessaoDto;
import com.example.palmilha_backend.mapper.SessaoMapper;
import com.example.palmilha_backend.model.Sessao;
import com.example.palmilha_backend.repository.SessaoRepository;

@Service
public class SessaoService {

	@Autowired
	private SessaoMapper sessaoMapper;
	
	@Autowired
	private SessaoRepository sessaoRepository;
	
	@Autowired
	private AmostraService amostraService;
	
	@Autowired
	private PassadaService passadaService;
	
	public List<SessaoDto> buscarTodas() {
		List<SessaoDto> sessoes = sessaoMapper.toDto(sessaoRepository.findAll());
		for(SessaoDto sessao : sessoes) {
			sessao.setAmostras(amostraService.buscarPorSessao(sessao.getId()));
			sessao.setPassadas(passadaService.buscarPorSessao(sessao.getId()));
		}
		return sessoes;
	}
	
	public SessaoDto buscarSessao(Long id) {
		SessaoDto sessao = sessaoMapper.toDto(sessaoRepository.findById(id).orElseThrow(()-> new RuntimeException("Não encontrado")));
		
		return sessao;
	}
	
	public SessaoDto salvar(SessaoDto dados) {
		Sessao sessao = sessaoMapper.toEntity(dados);
		sessao = sessaoRepository.save(sessao);
		
		SessaoDto sessaoDto = sessaoMapper.toDto(sessao);
		sessaoDto.setAmostras(amostraService.salvar(dados.getAmostras(), sessao));
		sessaoDto.setPassadas(passadaService.salvar(dados.getAmostras(), sessao));
		return dados;
	}

	
	
}
