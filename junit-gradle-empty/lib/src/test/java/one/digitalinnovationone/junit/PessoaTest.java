package one.digitalinnovationone.junit;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import one.digitalinovationone.junit.Pessoa;

public class PessoaTest {
	
	@Test
	void validarCalculoIdade() {
		
		Pessoa pessoa = new Pessoa("Carla", LocalDate.of(1986, 1, 10));
		Assertions.assertEquals(36, pessoa.getIdade());
		
	}

}
