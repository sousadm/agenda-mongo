package com.sousa.agenda.service;

import static java.lang.String.format;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sousa.agenda.entity.Usuario;
import com.sousa.agenda.mapper.UsuarioMapper;
import com.sousa.agenda.model.request.UsuarioRequest;
import com.sousa.agenda.model.response.UsuarioResponse;
import com.sousa.agenda.repository.UsuarioRepository;
import com.sousa.agenda.service.exception.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository repository;
	private final UsuarioMapper mapper;

	@Transactional
	public Mono<UsuarioResponse> save(final UsuarioRequest request) {
		var usuario = mapper.toEntity(request);
		usuario.setPessoa(mapper.toPessoa(request));
		return repository.save(usuario).map(u -> mapper.toResponse(u));
	}

	public Mono<Usuario> findById(final String id) {
		return handleNotFound(repository.findById(id), id);
	}

	public Flux<Usuario> findAll() {
		return repository.findAll();
	}

	public Mono<Usuario> update(final String id, final UsuarioRequest request) {
		return findById(id).map(entity -> mapper.toEntity(request, entity)).flatMap(repository::save);
	}

	public Mono<Usuario> delete(final String id) {
		return handleNotFound(repository.findAndRemove(id), id);
	}

	private <T> Mono<T> handleNotFound(Mono<T> mono, String id) {
		return mono.switchIfEmpty(Mono.error(new ObjectNotFoundException(
				format("Object not found. Id: %s, Type: %s", id, Usuario.class.getSimpleName()))));
	}
}