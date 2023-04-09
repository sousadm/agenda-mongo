package com.sousa.agenda.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sousa.agenda.model.request.PessoaRequest;
import com.sousa.agenda.model.response.PessoaResponse;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PessoaController {

	@PostMapping
	ResponseEntity<Mono<Void>> save(@Valid @RequestBody PessoaRequest request);

	@GetMapping(value = "/{id}")
	ResponseEntity<Mono<PessoaResponse>> findById(@PathVariable String id);

	@GetMapping
	ResponseEntity<Flux<PessoaResponse>> findAll();

	@PatchMapping(value = "/{id}")
	ResponseEntity<Mono<PessoaResponse>> update(@PathVariable String id, @RequestBody PessoaRequest request);

	@DeleteMapping(value = "/{id}")
	ResponseEntity<Mono<Void>> delete(@PathVariable String id);

}