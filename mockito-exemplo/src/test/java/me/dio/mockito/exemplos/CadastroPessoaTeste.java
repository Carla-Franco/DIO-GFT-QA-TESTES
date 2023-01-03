package me.dio.mockito.exemplos;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class CadastroPessoaTeste {
	
	@Mock
	private ApiCorreios apiCorreios;
	
	@InjectMocks
	private CadastroPessoa cadastroPessoa;

	@Test
	void validarDadosCadastro() {
		
		DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("ES", "Domingos Martins", "Rua Elza Hofffman Lubbe", "Bloco B ap 404", "Santa Isabel");
		//Mockito.when(apiCorreios.buscaDadosComBaseNoCep("29260000")).thenReturn(dadosLocalizacao);
		Mockito.when(apiCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(dadosLocalizacao);
		Pessoa pessoa = cadastroPessoa.cadastroPessoa("Carla", "4012254", LocalDate.now(), "29260000");
	
		assertEquals("Carla", pessoa.getNome());
		assertEquals("4012254", pessoa.getDocumento());
		assertEquals("ES", pessoa.getEndereco().getUf());
		assertEquals("Bloco B ap 404", pessoa.getEndereco().getComplemento());
	}
	
	@Test
	void lancarExceptionQuandoChamarApiCorreios() {
		
	    Mockito.when(apiCorreios.buscaDadosComBaseNoCep(anyString())).thenThrow(IllegalArgumentException.class);
		
	    assertThrows(IllegalArgumentException.class, () -> cadastroPessoa.cadastroPessoa("Carla", "4012254", LocalDate.now(), "29260000"));
	}
	
	@Test
	void validarDadosCadastroNull() {
		
		Mockito.when(apiCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(null);
		Pessoa pessoa = cadastroPessoa.cadastroPessoa("Carla", "4012254", LocalDate.now(), "29260000");
	
		assertNull(pessoa.getEndereco());
	}
	
	@Test
	void lancarExceptionQuandoChamarApiCorreiosOutraForma() {
		
	    Mockito.doThrow(IllegalArgumentException.class).when(apiCorreios).buscaDadosComBaseNoCep(anyString());
		
	    assertThrows(IllegalArgumentException.class, () -> cadastroPessoa.cadastroPessoa("Carla", "4012254", LocalDate.now(), "29260000"));
	}

}
