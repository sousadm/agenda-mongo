package com.sousa.agenda.service;

import org.springframework.stereotype.Service;

import com.sousa.agenda.entity.User;
import com.sousa.agenda.mapper.UserMapper;
import com.sousa.agenda.model.request.UserRequest;
import com.sousa.agenda.repository.UserRepository;
import com.sousa.agenda.service.exception.ObjectNotFoundException;

import static java.lang.String.format;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;
	private final UserMapper mapper;

	public Mono<User> save(final UserRequest request) {
		return repository.save(mapper.toEntity(request));
	}

	public Mono<User> findById(final String id) {
		return handleNotFound(repository.findById(id), id);
	}

	public Flux<User> findAll() {
		return repository.findAll();
	}

	public Mono<User> update(final String id, final UserRequest request) {
		return findById(id).map(entity -> mapper.toEntity(request, entity)).flatMap(repository::save);
	}

	public Mono<User> delete(final String id) {
		return handleNotFound(repository.findAndRemove(id), id);
	}

	private <T> Mono<T> handleNotFound(Mono<T> mono, String id) {
		return mono.switchIfEmpty(Mono.error(new ObjectNotFoundException(
				format("Object not found. Id: %s, Type: %s", id, User.class.getSimpleName()))));
	}
}