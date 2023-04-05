package com.sousa.agenda.repository;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sousa.agenda.entity.Vendedor;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class VendedorRepository {

	private final ReactiveMongoTemplate mongoTemplate;

	public Mono<Vendedor> save(final Vendedor model) {
		return mongoTemplate.save(model);
	}

	public Mono<Vendedor> findById(String id) {
		return mongoTemplate.findById(id, Vendedor.class);
	}

	public Flux<Vendedor> findAll() {
		return mongoTemplate.findAll(Vendedor.class);
	}

	public Mono<Vendedor> findAndRemove(String id) {
		Query query = new Query();
		Criteria where = Criteria.where("id").is(id);
		return mongoTemplate.findAndRemove(query.addCriteria(where), Vendedor.class);
	}

}
