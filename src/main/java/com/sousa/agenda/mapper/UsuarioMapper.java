package com.sousa.agenda.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.sousa.agenda.entity.Pessoa;
import com.sousa.agenda.entity.Usuario;
import com.sousa.agenda.model.request.UsuarioRequest;
import com.sousa.agenda.model.response.UsuarioResponse;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	@Mapping(target = "id", ignore = true)
	Pessoa toPessoa(final UsuarioRequest request);
	
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pessoa", ignore = true)
    Usuario toEntity(final UsuarioRequest request);

    @Mapping(target = "id", ignore = true) 
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "pessoa", ignore = true)
    @Mapping(target = "updated_dt", ignore = true)
    @Mapping(target = "cadastro_dt", ignore = true)
    Usuario toEntity(final UsuarioRequest request, @MappingTarget final Usuario entity);

    @Mapping(target = "nome", source = "entity.pessoa.nome")
    @Mapping(target = "email", source = "entity.pessoa.email")
    @Mapping(target = "celular", source = "entity.pessoa.celular")
    @Mapping(target = "idPessoa", source = "entity.pessoa.id")
    UsuarioResponse toResponse(final Usuario entity);
	
}
