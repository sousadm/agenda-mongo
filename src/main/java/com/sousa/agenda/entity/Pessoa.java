package com.sousa.agenda.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder
@Document(collection = "pessoas")
public class Pessoa extends DadosPessoa {

	@MongoId(FieldType.OBJECT_ID)
	private String id;
	private String nome;
	private String celular;
	@Indexed(unique = true)
	private String email;

}
