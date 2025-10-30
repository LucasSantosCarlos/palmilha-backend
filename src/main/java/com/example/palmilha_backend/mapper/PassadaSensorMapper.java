package com.example.palmilha_backend.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.example.palmilha_backend.dto.PassadaSensorDto;
import com.example.palmilha_backend.dto.PassadaSensorDto.PassadaSensorDtoBuilder;
import com.example.palmilha_backend.model.PassadaSensor;
import com.example.palmilha_backend.model.PassadaSensor.PassadaSensorBuilder;


@ComponentScan
@Component
public class PassadaSensorMapper extends AbstractMapper<PassadaSensorDto, PassadaSensor> {
	
	@Autowired
	private PassadaMapper passadaMapper;
	
    @Override
    public PassadaSensorDto toDto(PassadaSensor entity) {
    	if(entity==null) return null;
    	PassadaSensorDtoBuilder builder = PassadaSensorDto.builder()
                .id(entity.getId())
                .sensorIdx(entity.getSensorIdx())
                .media(entity.getMedia())
                .pico(entity.getPico())
                .integral(entity.getIntegral())
                .passada(passadaMapper.toDto(entity.getPassada()));

        return builder.build();
    }

    @Override
    public PassadaSensor toEntity(PassadaSensorDto dto) {
    	if(dto==null) return null;
    	PassadaSensorBuilder builder = PassadaSensor.builder()
                .id(dto.getId())
                .sensorIdx(dto.getSensorIdx())
                .media(dto.getMedia())
                .pico(dto.getPico())
                .integral(dto.getIntegral())
                .passada(passadaMapper.toEntity(dto.getPassada()));
                
         return builder.build();
    }

}
