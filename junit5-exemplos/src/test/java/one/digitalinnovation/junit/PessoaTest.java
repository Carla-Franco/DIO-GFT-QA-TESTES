package one.digitalinnovation.junit;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PessoaTest {

	@Test
	void deveCalcularIdade() {
		Pessoa pessoa = new Pessoa("Clara", LocalDate.of(2009, 8, 29));
		Assertions.assertEquals(13, pessoa.getIdade());
	}
	
	@Test
	void deveRetornarSeEhMaiorIdade() {
		Pessoa pessoa2 = new Pessoa("Rondonito", LocalDate.of(1989, 2, 5));
		Assertions.assertTrue(pessoa2.ehMaiorIdade());
		
		Pessoa pessoa3 = new Pessoa("Clara", LocalDate.of(2009, 8, 29));
		Assertions.assertFalse(pessoa3.ehMaiorIdade());
	}
}
