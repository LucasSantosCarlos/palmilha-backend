package com.example.palmilha_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.palmilha_backend.dto.AmostraDto;
import com.example.palmilha_backend.mapper.AmostraMapper;
import com.example.palmilha_backend.model.Amostra;
import com.example.palmilha_backend.model.Sessao;
import com.example.palmilha_backend.repository.AmostraRepository;

@Service
public class AmostraService {

	@Autowired
	private AmostraMapper amostraMapper;
	
	@Autowired
	private AmostraRepository amostraRepository;
	
	public List<AmostraDto> buscarPorSessao(Long idSessao){
		return amostraMapper.toDto(amostraRepository.findAllBySessaoId(idSessao));
	}
	
	public List<AmostraDto> salvar(List<AmostraDto> amostrasDto, Sessao sessao) {
		List<AmostraDto> amostrasSalvas = new ArrayList<AmostraDto>();
		for(AmostraDto amostraDto : amostrasDto) {
			Amostra amostra = amostraMapper.toEntity(amostraDto);
			amostra.setSessao(sessao);
			amostra = amostraRepository.save(amostra);
			amostrasSalvas.add(amostraMapper.toDto(amostra));
		}
		return amostrasSalvas;
	}
	
}
