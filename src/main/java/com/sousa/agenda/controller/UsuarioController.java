package com.sousa.agenda.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sousa.agenda.model.request.UsuarioRequest;
import com.sousa.agenda.model.response.UsuarioResponse;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioController {

    @PostMapping
    ResponseEntity<Mono<Void>> save(@Valid @RequestBody UsuarioRequest request);

    @GetMapping(value = "/{id}")
    ResponseEntity<Mono<UsuarioResponse>> findById(@PathVariable String id);

    @GetMapping
    ResponseEntity<Flux<UsuarioResponse>> findAll();

    @PatchMapping(value = "/{id}")
    ResponseEntity<Mono<UsuarioResponse>> update(@PathVariable String id, @RequestBody UsuarioRequest request);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Mono<Void>> delete(@PathVariable String id);
    
}