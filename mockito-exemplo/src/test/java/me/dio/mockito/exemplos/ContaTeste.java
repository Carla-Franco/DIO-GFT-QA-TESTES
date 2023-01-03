package me.dio.mockito.exemplos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ContaTeste {
	
	@Spy
	private Conta conta = new Conta(1500);

	@Test
	void validarOrdemChamadas() {
		
		conta.pagaBoleto(300);
		
		InOrder inOrder = Mockito.inOrder(conta);
		//inOrder.verify(conta).pagaBoleto(ArgumentMatchers.anyInt());
		inOrder.verify(conta).pagaBoleto(300);
		inOrder.verify(conta).validaSaldo(300);
		inOrder.verify(conta).debita(300);
		inOrder.verify(conta).enviaCreditoParaEmissor(300);
	}
	
	@Test
	void validarQuantidadeChamadas() {
		
		conta.validaSaldo(300);
		conta.validaSaldo(500);
		conta.validaSaldo(600);
		
		Mockito.verify(conta, Mockito.times(3)).validaSaldo(ArgumentMatchers.anyInt());
	}
	
	@Test
	void retornaTrueQualquerValorValidacaoSaldo() {
		Mockito.doNothing().when(conta).validaSaldo(ArgumentMatchers.anyInt());
		conta.validaSaldo(3000);
	}

}
