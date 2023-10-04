package br.com.gabrielmusskopf.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import br.com.gabrielmusskopf.domain.Pessoa;

public interface PessoaServico {

	Pessoa criar(String nome, String apelido, List<String> stack, LocalDate dataNasicmento);
	List<Pessoa> buscarTodas();
	Optional<Pessoa> buscar(Long id);
	List<Pessoa> buscarTermo(String termo);

}
