package com.sousa.agenda.repository;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sousa.agenda.entity.Pessoa;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class PessoaRepository {

	private final ReactiveMongoTemplate mongoTemplate;

	public Mono<Pessoa> save(final Pessoa model) {
		return mongoTemplate.save(model);
	}

	public Mono<Pessoa> findById(String id) {
		return mongoTemplate.findById(id, Pessoa.class);
	}

	public Flux<Pessoa> findAll() {
		return mongoTemplate.findAll(Pessoa.class);
	}

	public Mono<Pessoa> findAndRemove(String id) {
		Query query = new Query();
		Criteria where = Criteria.where("id").is(id);
		return mongoTemplate.findAndRemove(query.addCriteria(where), Pessoa.class);
	}

}
