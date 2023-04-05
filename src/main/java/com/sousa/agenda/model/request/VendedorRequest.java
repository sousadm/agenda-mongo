package com.sousa.agenda.model.request;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class VendedorRequest extends PessoaRequest {

	private BigDecimal comissao;
	
}
