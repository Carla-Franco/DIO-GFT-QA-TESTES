package one.digitalinnovation.junit;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionsTest {
	
	@Test
	void validarLancamentos() {
		
		int[] primeiroLancamento = {10, 20, 30, 40, 50};
		int[] segundoLancamento = {10, 20, 30, 40, 50};
		
		assertArrayEquals(primeiroLancamento, segundoLancamento);
	}
	
	@Test
	void validadrObjetoNulo() {
		Pessoa pessoa = null;
		assertNull(pessoa);
		
		pessoa = new Pessoa("Carla", LocalDateTime.now());
		assertNotNull(pessoa);	
	}
	
	@Test
	void validarNumerosDeTiposDiferentes() {
		
		double valor = 5d;
		double outroValor = 5d;
		
		assertEquals(valor, outroValor);	
	}

}
