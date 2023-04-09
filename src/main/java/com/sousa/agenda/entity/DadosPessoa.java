package com.sousa.agenda.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DadosPessoa {

	private LocalDateTime cadastro_dt;
	private LocalDateTime updated_dt;
	private Boolean ativo;

	public DadosPessoa() {
		this.cadastro_dt = LocalDateTime.now();
		this.ativo = true;
	}

}
