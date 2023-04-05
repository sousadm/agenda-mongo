package com.sousa.agenda.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
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
@Document(collection = "usuarios")
public class Usuario extends DadosPessoa {

	@MongoId(FieldType.OBJECT_ID)
	private String id;
	
    @DocumentReference(lazy = true)
	@Indexed(unique = true)
	private Pessoa pessoa;
	
	private String name;
	private String password;

}
