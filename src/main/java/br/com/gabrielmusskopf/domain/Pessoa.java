package br.com.gabrielmusskopf.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String apelido;
	private LocalDate dataNascimento;
	@ElementCollection private List<String> stack;
	private String termos;

	public Pessoa(){}

	public Pessoa(String nome, String apelido, LocalDate dataNascimento, List<String> stack) {
		this.nome = nome;
		this.apelido = apelido;
		this.dataNascimento = dataNascimento;
		this.stack = stack;
		this.termos = concatenarTermos(nome, apelido, stack);
	}

	private String concatenarTermos(String nome, String apelido, List<String> stack) {
		return String.join("", nome, apelido, String.join("", stack));
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getApelido() {
		return apelido;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public List<String> getStack() {
		return stack;
	}

	public String getTermos() {
		return termos;
	}
}
