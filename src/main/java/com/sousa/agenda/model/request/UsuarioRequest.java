package com.sousa.agenda.model.request;

import com.sousa.agenda.validator.TrimString;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UsuarioRequest extends PessoaRequest {

	@TrimString
	@NotBlank(message = "must not be null or empty")
	@Size(min = 3, max = 20, message = "must be between 3 and 20 characters")
	public String username;
	
	@TrimString
	@NotBlank(message = "must not be null or empty")
	@Size(min = 3, max = 20, message = "must be between 3 and 20 characters")
	public String password;	
	
}
