package me.dio.mockito.exemplos;

import java.time.LocalDate;

public class CadastroPessoa {
	
	private ApiCorreios apiCorreios;
	
	public CadastroPessoa(final ApiCorreios apiCorreios) {
		this.apiCorreios = apiCorreios;
	}
	
	public Pessoa cadastroPessoa(String nome, String documento, LocalDate nascimento, String cep) {
		Pessoa pessoa = new Pessoa(nome, documento, nascimento);
		DadosLocalizacao dadosLocalizacao = apiCorreios.buscaDadosComBaseNoCep(cep);
		pessoa.adicionaDadosEndereco(dadosLocalizacao);
		return pessoa;
	}

}
