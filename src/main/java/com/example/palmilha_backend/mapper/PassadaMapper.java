package com.example.palmilha_backend.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.example.palmilha_backend.dto.PassadaDto;
import com.example.palmilha_backend.dto.PassadaDto.PassadaDtoBuilder;
import com.example.palmilha_backend.model.Passada;
import com.example.palmilha_backend.model.Passada.PassadaBuilder;


@ComponentScan
@Component
public class PassadaMapper extends AbstractMapper<PassadaDto, Passada> {
	
	@Autowired
	private SessaoMapper sessaoMapper;
	
    @Override
    public PassadaDto toDto(Passada entity) {
    	if(entity==null) return null;
    	PassadaDtoBuilder builder = PassadaDto.builder()
                .id(entity.getId())
                .idx(entity.getIdx())
                .inicio(entity.getInicio())
                .fim(entity.getFim())
                .contatoMs(entity.getContatoMs())
                .contatoInicial(entity.getContatoInicial())
                .picoTotal(entity.getPicoTotal())
                .razaoMedial(entity.getRazaoMedial())
                .sessao(sessaoMapper.toDto(entity.getSessao()));

        return builder.build();
    }

    @Override
    public Passada toEntity(PassadaDto dto) {
    	if(dto==null) return null;
    	PassadaBuilder builder = Passada.builder()
                .id(dto.getId())
                .idx(dto.getIdx())
                .inicio(dto.getInicio())
                .fim(dto.getFim())
                .contatoMs(dto.getContatoMs())
                .contatoInicial(dto.getContatoInicial())
                .picoTotal(dto.getPicoTotal())
                .razaoMedial(dto.getRazaoMedial())
                .sessao(sessaoMapper.toEntity(dto.getSessao()));
                
         return builder.build();
    }

}
