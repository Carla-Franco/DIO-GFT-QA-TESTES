package me.dio.mockito.exemplos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EnviarMensagemTeste {
	
	@Spy
	private EnviarMensagem enviarMensagem;

	@Test
	void verificarComportamentoClasse() {
		Mockito.verifyNoInteractions(enviarMensagem);
		
		Mensagem mensagem = new Mensagem("Hello World");
		enviarMensagem.adicionarMensagem(mensagem);
		Mockito.verify(enviarMensagem).adicionarMensagem(mensagem);
		
		assertFalse(enviarMensagem.getMensagens().isEmpty());
	}

}
