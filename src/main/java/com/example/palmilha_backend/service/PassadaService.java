package com.example.palmilha_backend.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.palmilha_backend.dto.AmostraDto;
import com.example.palmilha_backend.dto.PassadaDto;
import com.example.palmilha_backend.dto.PassadaSensorDto;
import com.example.palmilha_backend.mapper.PassadaMapper;
import com.example.palmilha_backend.model.Passada;
import com.example.palmilha_backend.model.Sessao;
import com.example.palmilha_backend.repository.PassadaRepository;

@Service
public class PassadaService {
	
	@Autowired
	private PassadaMapper passadaMapper;
	
	@Autowired
	private PassadaRepository passadaRepository;
	
	@Autowired
	private PassadaSensorService passadaSensorService;
	
	
	public List<PassadaDto> buscarPorSessao(Long idSessao){
		List<PassadaDto> passadas = passadaMapper.toDto(passadaRepository.findAllBySessaoId(idSessao));
	
		for(PassadaDto passada : passadas) {
			passada.setItens(passadaSensorService.buscarPorPassada(passada.getId()));
		}
		
		return passadas;
	}
	
	@Transactional
	public List<PassadaDto> salvar(List<AmostraDto> amostras, Sessao sessao) {
		List<PassadaDto> passadasDto = detectarPassadas(amostras);
		List<PassadaDto> passadasSalvas = new ArrayList<PassadaDto>();
		for(PassadaDto dto : passadasDto) {
			Passada entity = passadaMapper.toEntity(dto);
            entity.setSessao(sessao);
			entity = passadaRepository.save(entity);
			
			PassadaDto dtoSalvo = passadaMapper.toDto(entity);
			dtoSalvo.setItens(passadaSensorService.salvar(dto.getItens(), entity));
			passadasSalvas.add(dtoSalvo);
		}
		
		return passadasSalvas;
	}

    public List<PassadaDto> detectarPassadas(List<AmostraDto> amostras) {
        List<PassadaDto> passadas = new ArrayList<>();

        if (amostras == null || amostras.isEmpty()) return passadas;

        boolean emPasso = false;
        int limiar = 35; // ajuste conforme sensibilidade do sensor
        AmostraDto inicio = null;


        List<AmostraDto> amostrasDaPassada = new ArrayList<AmostraDto>();
        for (int i = 0; i < amostras.size(); i++) {
            AmostraDto a = amostras.get(i);
            amostrasDaPassada.add(a);
            int somaSensores = a.getS1() + a.getS2() + a.getS3() + a.getS4() + a.getS5() + a.getS6();

            if (!emPasso && somaSensores > limiar) {
                // início do passo
                emPasso = true;
                inicio = a;
            } else if (emPasso && somaSensores < limiar) {
                // fim do passo
                emPasso = false;
                AmostraDto fim = a;

                PassadaDto passada = calcularDadosPassada(inicio, fim, amostrasDaPassada);
                passada.setIdx(passadas.size() + 1);
                passadas.add(passada);
                amostrasDaPassada.clear();
            }
        }

        return passadas;
    }

    private PassadaDto calcularDadosPassada(AmostraDto inicio, AmostraDto fim, List<AmostraDto> amostrasDaPassada) {
        PassadaDto passada = new PassadaDto();
        passada.setInicio(inicio.getTs());
        passada.setFim(fim.getTs());

        long duracaoMs = java.time.Duration.between(inicio.getTs(), fim.getTs()).toMillis();
        passada.setContatoMs((int) duracaoMs);

        passada.setItens(calcularPorSensor(amostrasDaPassada));

        int picoTotal = amostrasDaPassada.stream()
            .mapToInt(a -> Collections.max(List.of(a.getS1(), a.getS2(), a.getS3(), a.getS4(), a.getS5(), a.getS6())))
            .max()
            .orElse(0);
        passada.setPicoTotal(picoTotal);

        return passada;
    }

    private List<PassadaSensorDto> calcularPorSensor(List<AmostraDto> amostras) {
        List<PassadaSensorDto> lista = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            int sensorIdx = i;
            List<Integer> valores = amostras.stream()
                .map(a -> switch (sensorIdx) {
                    case 1 -> a.getS1();
                    case 2 -> a.getS2();
                    case 3 -> a.getS3();
                    case 4 -> a.getS4();
                    case 5 -> a.getS5();
                    case 6 -> a.getS6();
                    default -> 0;
                })
                .toList();

            if (valores.isEmpty()) continue;

            double media = valores.stream().mapToInt(Integer::intValue).average().orElse(0);
            int pico = valores.stream().mapToInt(Integer::intValue).max().orElse(0);
            int integral = valores.stream().mapToInt(Integer::intValue).sum();

            PassadaSensorDto ps = new PassadaSensorDto();
            ps.setSensorIdx(Short.valueOf(String.valueOf(sensorIdx)));
            ps.setMedia(media);
            ps.setPico(pico);
            ps.setIntegral(integral);

            lista.add(ps);
        }

        return lista;
    }

	
}

