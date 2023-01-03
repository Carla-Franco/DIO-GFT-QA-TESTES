package one.digitalinnovation.junit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Pessoa {
	
	private String nome;
	private LocalDate nascimento;
		
	public Pessoa(String nome, LocalDate nascimento) {
		this.nome = nome;
		this.nascimento = nascimento;
	}
	
	public Pessoa(String string, LocalDateTime now) {
		// TODO Auto-generated constructor stub
	}

	public int getIdade() {
		return (int) ChronoUnit.YEARS.between(this.nascimento, LocalDate.now());
	}
	
	public boolean ehMaiorIdade() {
		return getIdade() >= 18;
	}


}
