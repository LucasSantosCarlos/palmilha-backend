package com.example.palmilha_backend.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.example.palmilha_backend.dto.AmostraDto;
import com.example.palmilha_backend.dto.AmostraDto.AmostraDtoBuilder;
import com.example.palmilha_backend.model.Amostra;
import com.example.palmilha_backend.model.Amostra.AmostraBuilder;


@ComponentScan
@Component
public class AmostraMapper extends AbstractMapper<AmostraDto, Amostra> {
	
	@Autowired
	private SessaoMapper sessaoMapper;
	
    @Override
    public AmostraDto toDto(Amostra entity) {
    	if(entity==null) return null;
    	AmostraDtoBuilder builder = AmostraDto.builder()
                .id(entity.getId())
                .ts(entity.getTs())
                .s1(entity.getS1())
                .s2(entity.getS2())
                .s3(entity.getS3())
                .s4(entity.getS4())
                .s5(entity.getS5())
                .s6(entity.getS6())
                .sessao(sessaoMapper.toDto(entity.getSessao()));

        return builder.build();
    }

    @Override
    public Amostra toEntity(AmostraDto dto) {
    	if(dto==null) return null;
    	AmostraBuilder builder = Amostra.builder()
                .id(dto.getId())
                .ts(dto.getTs())
                .s1(dto.getS1())
                .s2(dto.getS2())
                .s3(dto.getS3())
                .s4(dto.getS4())
                .s5(dto.getS5())
                .s6(dto.getS6())
                .sessao(sessaoMapper.toEntity(dto.getSessao()));
                
         return builder.build();
    }

}
