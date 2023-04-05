package com.sousa.agenda.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.sousa.agenda.entity.Pessoa;
import com.sousa.agenda.entity.Usuario;
import com.sousa.agenda.model.request.PessoaRequest;
import com.sousa.agenda.model.request.UsuarioRequest;
import com.sousa.agenda.model.response.UsuarioResponse;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	@Mapping(target = "id", ignore = true)
	Pessoa toPessoa(final UsuarioRequest request);
	
    @Mapping(target = "id", ignore = true)
    Usuario toEntity(final PessoaRequest request);

    @Mapping(target = "id", ignore = true)
    Usuario toEntity(final PessoaRequest request, @MappingTarget final Usuario entity);

    UsuarioResponse toResponse(final Usuario entity);
	
}