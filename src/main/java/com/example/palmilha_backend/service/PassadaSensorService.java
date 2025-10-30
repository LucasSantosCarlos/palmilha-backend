package com.example.palmilha_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.palmilha_backend.dto.PassadaSensorDto;
import com.example.palmilha_backend.mapper.PassadaSensorMapper;
import com.example.palmilha_backend.model.Passada;
import com.example.palmilha_backend.model.PassadaSensor;
import com.example.palmilha_backend.repository.PassadaSensorRepository;

@Service
public class PassadaSensorService {

	@Autowired
	private PassadaSensorMapper passadaSensorMapper;

	@Autowired
	private PassadaSensorRepository passadaSensorRepository;

	public List<PassadaSensorDto> buscarPorPassada(Long idPassada) {
		return passadaSensorMapper.toDto(passadaSensorRepository.findAllbyPassadaId(idPassada));
	}
	
	@Transactional
	public List<PassadaSensorDto> salvar(List<PassadaSensorDto> passadasSensor, Passada passada) {

		List<PassadaSensorDto> passadasSensorSalvas = new ArrayList<PassadaSensorDto>();
		for (PassadaSensorDto passadaSensorDto : passadasSensor) {
			PassadaSensor passadaSensor = passadaSensorMapper.toEntity(passadaSensorDto);
			passadaSensor.setPassada(passada);
			passadaSensor = passadaSensorRepository.save(passadaSensor);
			passadasSensorSalvas.add(passadaSensorMapper.toDto(passadaSensor));
		}

		return passadasSensorSalvas;
	}

	


}
