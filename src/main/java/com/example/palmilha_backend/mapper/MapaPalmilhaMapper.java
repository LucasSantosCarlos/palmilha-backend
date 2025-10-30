package com.example.palmilha_backend.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.example.palmilha_backend.dto.MapaPalmilhaDto;
import com.example.palmilha_backend.dto.MapaPalmilhaDto.MapaPalmilhaDtoBuilder;
import com.example.palmilha_backend.model.MapaPalmilha;
import com.example.palmilha_backend.model.MapaPalmilha.MapaPalmilhaBuilder;


@ComponentScan
@Component
public class MapaPalmilhaMapper extends AbstractMapper<MapaPalmilhaDto, MapaPalmilha> {
	
	@Autowired
	private SessaoMapper sessaoMapper;
	
    @Override
    public MapaPalmilhaDto toDto(MapaPalmilha entity) {
    	if(entity==null) return null;
    	MapaPalmilhaDtoBuilder builder = MapaPalmilhaDto.builder()
                .id(entity.getId())
                .sessao(sessaoMapper.toDto(entity.getSessao()))
                .sensorIdx(entity.getSensorIdx())
                .posicaoX(entity.getPosicaoX())
                .posicaoY(entity.getPosicaoY());

        return builder.build();
    }

    @Override
    public MapaPalmilha toEntity(MapaPalmilhaDto dto) {
    	if(dto==null) return null;
    	MapaPalmilhaBuilder builder = MapaPalmilha.builder()
    			.id(dto.getId())
                .sessao(sessaoMapper.toEntity(dto.getSessao()))
                .sensorIdx(dto.getSensorIdx())
                .posicaoX(dto.getPosicaoX())
                .posicaoY(dto.getPosicaoY());
                
         return builder.build();
    }

}
