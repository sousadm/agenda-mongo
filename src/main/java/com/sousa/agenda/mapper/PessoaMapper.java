package com.sousa.agenda.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.sousa.agenda.entity.Pessoa;
import com.sousa.agenda.model.request.PessoaRequest;
import com.sousa.agenda.model.response.PessoaResponse;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

	@Mapping(target = "id", ignore = true)
	Pessoa toEntity(final PessoaRequest request);

	PessoaResponse toResponse(final Pessoa entity);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "ativo", ignore = true)
	@Mapping(target = "cadastro_dt", ignore = true)
	@Mapping(target = "updated_dt", ignore = true)
	Pessoa toEntity(final PessoaRequest request, @MappingTarget final Pessoa entity);

}
