package com.sousa.agenda.service;

import static java.lang.String.format;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sousa.agenda.entity.Pessoa;
import com.sousa.agenda.mapper.PessoaMapper;
import com.sousa.agenda.model.request.PessoaRequest;
import com.sousa.agenda.repository.PessoaRepository;
import com.sousa.agenda.service.exception.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PessoaService {

	private final PessoaRepository repository;
	private final PessoaMapper mapper;

	@Transactional
	public Mono<Pessoa> save(final PessoaRequest request) {
		return repository.save(mapper.toEntity(request));
	}

	public Mono<Pessoa> findById(final String id) {
		return handleNotFound(repository.findById(id), id);
	}

	public Flux<Pessoa> findAll() {
		return repository.findAll();
	}

	public Mono<Pessoa> update(final String id, final PessoaRequest request) {
		return findById(id).map(entity -> mapper.toEntity(request, entity)).flatMap(repository::save);
	}

	public Mono<Pessoa> delete(final String id) {
		return handleNotFound(repository.findAndRemove(id), id);
	}

	private <T> Mono<T> handleNotFound(Mono<T> mono, String id) {
		return mono.switchIfEmpty(Mono.error(new ObjectNotFoundException(
				format("Object not found. Id: %s, Type: %s", id, Pessoa.class.getSimpleName()))));
	}
}