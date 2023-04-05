package com.sousa.agenda.repository;

import java.time.Duration;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sousa.agenda.entity.Usuario;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UsuarioRepository {

	private final ReactiveMongoTemplate mongoTemplate;

	public Mono<Usuario> save(Usuario model) {

		mongoTemplate.save(model.getPessoa()).subscribe(pessoa -> model.setPessoa(pessoa));
		return mongoTemplate.save(model);

	}

	public Mono<Usuario> findById(String id) {
		return mongoTemplate.findById(id, Usuario.class);
	}

	public Flux<Usuario> findAll() {
		return mongoTemplate.findAll(Usuario.class);
	}

	public Mono<Usuario> findAndRemove(String id) {
		Query query = new Query();
		Criteria where = Criteria.where("id").is(id);
		return mongoTemplate.findAndRemove(query.addCriteria(where), Usuario.class);
	}

}
