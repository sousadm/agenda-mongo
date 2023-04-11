package com.sousa.agenda.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sousa.agenda.entity.Pessoa;
import com.sousa.agenda.mapper.PessoaMapper;
import com.sousa.agenda.model.request.PessoaRequest;
import com.sousa.agenda.repository.PessoaRepository;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

	@Mock
	private PessoaRepository repository;

	@Mock
	private PessoaMapper mapper;

	@InjectMocks
	private PessoaService service;

	@Test
	void testSave() {

		PessoaRequest request = new PessoaRequest("francisco sousa", "85999998844", "sousa@hotmail.com");
		Pessoa entity = Pessoa.builder().build();

		when(mapper.toEntity(any(PessoaRequest.class))).thenReturn(entity);
		when(repository.save(any(Pessoa.class))).thenReturn(Mono.just(Pessoa.builder().build()));

		Mono<Pessoa> result = service.save(request);
		
		StepVerifier.create(result)
			.expectNextMatches(pessoa -> pessoa.getClass() == Pessoa.class)
			.expectComplete()
			.verify();
		
		Mockito.verify(repository).save(any(Pessoa.class));

	}

}
