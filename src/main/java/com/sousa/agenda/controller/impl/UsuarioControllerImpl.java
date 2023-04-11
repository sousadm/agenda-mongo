package com.sousa.agenda.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sousa.agenda.controller.UsuarioController;
import com.sousa.agenda.mapper.UsuarioMapper;
import com.sousa.agenda.model.request.UsuarioRequest;
import com.sousa.agenda.model.response.UsuarioResponse;
import com.sousa.agenda.service.UsuarioService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/usuarios")
public class UsuarioControllerImpl implements UsuarioController {

	private final UsuarioService service;
	private final UsuarioMapper mapper;

	@Override
	public ResponseEntity<Mono<UsuarioResponse>> save(final UsuarioRequest request) {
		var response = service.save(request).map(u -> mapper.toResponse(u));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@Override
	public ResponseEntity<Mono<UsuarioResponse>> findById(String id) {
		return ResponseEntity.ok().body(service.findById(id).map(u -> mapper.toResponse(u)));
	}

	@Override
	public ResponseEntity<Flux<UsuarioResponse>> findAll() {
		return ResponseEntity.ok().body(service.findAll().map(u -> mapper.toResponse(u)));
	}

	@Override
	public ResponseEntity<Mono<UsuarioResponse>> update(String id, UsuarioRequest request) {
		return ResponseEntity.ok().body(service.update(id, request).map(mapper::toResponse));
	}

	@Override
	public ResponseEntity<Mono<Void>> delete(String id) {
		return ResponseEntity.ok().body(service.delete(id).then());
	}
}
