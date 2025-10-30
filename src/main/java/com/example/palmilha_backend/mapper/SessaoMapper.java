package com.example.palmilha_backend.mapper;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.example.palmilha_backend.dto.SessaoDto;
import com.example.palmilha_backend.dto.SessaoDto.SessaoDtoBuilder;
import com.example.palmilha_backend.model.Sessao;
import com.example.palmilha_backend.model.Sessao.SessaoBuilder;


@ComponentScan
@Component
public class SessaoMapper extends AbstractMapper<SessaoDto, Sessao> {
	
    @Override
    public SessaoDto toDto(Sessao entity) {
    	if(entity==null) return null;
    	SessaoDtoBuilder builder = SessaoDto.builder()
                .id(entity.getId())
                .iniciadoEm(entity.getIniciadoEm())
                .finalizadoEm(entity.getFinalizadoEm())
                .notas(entity.getNotas());

        return builder.build();
    }

    @Override
    public Sessao toEntity(SessaoDto dto) {
    	if(dto==null) return null;
    	SessaoBuilder builder = Sessao.builder()
                .id(dto.getId())
                .iniciadoEm(dto.getIniciadoEm())
                .finalizadoEm(dto.getFinalizadoEm())
                .notas(dto.getNotas());
                
         return builder.build();
    }

}
