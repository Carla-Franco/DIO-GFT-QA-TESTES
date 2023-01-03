package one.digitalinnovation.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {
	
	@Test
	void validarExcecaoTransferencia() {
		Conta contaOrigem = new Conta("123456", 4500);
		Conta contaDestino = new Conta("654987", 500);
		
		TransferenciaEntreContas transferenciaEntreContas = new TransferenciaEntreContas();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> transferenciaEntreContas.transfere(contaOrigem, contaDestino, -1));
	
	    Assertions.assertDoesNotThrow(() -> transferenciaEntreContas.transfere(contaOrigem, contaDestino, 100));
	}

}
