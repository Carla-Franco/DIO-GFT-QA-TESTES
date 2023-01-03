package me.dio.mockito.exemplos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServicoEnvioEmailTeste {
	
	@Mock
	private PlataformaEnvio plataforma;
	
	@InjectMocks
	private ServicoEnvioEmail servico;
	
	@Captor
	ArgumentCaptor<Email> captor;

	@Test
	void validarDadosEnviadoPlataforma() {
		
		String enderecoEmail = "roncarcla18@gmail.com";
		String mensagem = "Olá mundo teste mensagem";
		boolean ehFormatoHtml = false;
		
		servico.enviaEmail(enderecoEmail, mensagem, ehFormatoHtml);
		
		Mockito.verify(plataforma).enviaEmail(captor.capture());
		
		Email emailCapturado = captor.getValue();
		
		assertEquals(enderecoEmail, emailCapturado.getEnderecoEmail());
		assertEquals(mensagem, emailCapturado.getMensagem());
		assertEquals(Formato.TEXTO, emailCapturado.getFormato());
	}

}
