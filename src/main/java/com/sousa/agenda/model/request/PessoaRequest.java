package com.sousa.agenda.model.request;

import com.sousa.agenda.validator.TrimString;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRequest {

	@TrimString
	@NotBlank(message = "must not be null or empty")
	@Size(min = 3, max = 50, message = "must be between 3 and 50 characters")
	public String nome;

	@TrimString
	@Size(min = 8, message = "mínimo de 8 characters")
	@NotBlank(message = "informe o número do celular")
	public String celular;

	@TrimString
	@Email(message = "invalid email")
	@NotBlank(message = "must not be null or empty")
	public String email;

}
