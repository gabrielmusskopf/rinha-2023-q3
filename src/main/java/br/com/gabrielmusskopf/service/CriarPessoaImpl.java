package br.com.gabrielmusskopf.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import br.com.gabrielmusskopf.domain.Pessoa;
import br.com.gabrielmusskopf.repository.PessoaRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
class CriarPessoaImpl implements PessoaServico {

	@Inject
	PessoaRepositorio pessoaRepositorio;

	CriarPessoaImpl(PessoaRepositorio pessoaRepositorio) {
		this.pessoaRepositorio = pessoaRepositorio;
	}

	@Override
	public Pessoa criar(String nome, String apelido, List<String> stack, LocalDate dataNasicmento) {
		final var p = new Pessoa(nome, apelido, dataNasicmento, stack);
		pessoaRepositorio.persist(p);
		return p;
	}

	@Override
	public List<Pessoa> buscarTodas() {
		return pessoaRepositorio.findAll().list();
	}

	@Override
	public Optional<Pessoa> buscar(Long id) {
		return pessoaRepositorio.findByIdOptional(id);
	}

	@Override
	public List<Pessoa> buscarTermo(String termo) {
		return pessoaRepositorio.buscarTermo(termo);
	}
}
