package one.digitalinnovation.junit;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsultaDadosPessoaTest {
	
	@BeforeAll
	static void configuraConexao() {
		BancoDeDados.iniciarConexao();
	}
	
	@BeforeEach
	void insereDadosParaTeste() {
		BancoDeDados.insereDados(new Pessoa("Carla", LocalDateTime.of(1986, 1, 10, 13, 00, 0)));
	}
	
	@AfterEach
	void removeDadosDoTeste() {
		BancoDeDados.removeDados(new Pessoa("Carla", LocalDateTime.of(1986, 1, 10, 13, 00, 0)));
	}
	
	@Test
	void validarDadosRetorno() {
		Assertions.assertTrue(true);
	}
	
	@Test
	void validarDadosRetorno2() {
		Assertions.assertNull(null);
	}
	
	@AfterAll
	static void finalizarConexao() {
		BancoDeDados.finalizarConexao();
	}

}
