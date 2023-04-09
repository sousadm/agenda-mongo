package com.sousa.agenda.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sousa.agenda.controller.PessoaController;
import com.sousa.agenda.mapper.PessoaMapper;
import com.sousa.agenda.model.request.PessoaRequest;
import com.sousa.agenda.model.response.PessoaResponse;
import com.sousa.agenda.service.PessoaService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pessoas")
public class PessoaControllerImpl implements PessoaController {

	private final PessoaService service;
	private final PessoaMapper mapper;

	@Override
	public ResponseEntity<Mono<Void>> save(final PessoaRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request).then());
	}

	@Override
	public ResponseEntity<Mono<PessoaResponse>> findById(String id) {
		return ResponseEntity.ok().body(service.findById(id).map(mapper::toResponse));
	}

	@Override
	public ResponseEntity<Flux<PessoaResponse>> findAll() {
		return ResponseEntity.ok().body(service.findAll().map(mapper::toResponse));
	}

	@Override
	public ResponseEntity<Mono<PessoaResponse>> update(String id, PessoaRequest request) {
		return ResponseEntity.ok().body(service.update(id, request).map(mapper::toResponse));
	}

	@Override
	public ResponseEntity<Mono<Void>> delete(String id) {
		return ResponseEntity.ok().body(service.delete(id).then());
	}

}
