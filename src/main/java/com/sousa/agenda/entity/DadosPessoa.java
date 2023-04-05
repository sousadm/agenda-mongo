package com.sousa.agenda.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DadosPessoa {

	private LocalDate cadastro_dt;
	private LocalDate updated_dt;
	private Boolean ativo;

	public DadosPessoa() {
		this.cadastro_dt = LocalDate.now();
		this.ativo = true;
	}

}
