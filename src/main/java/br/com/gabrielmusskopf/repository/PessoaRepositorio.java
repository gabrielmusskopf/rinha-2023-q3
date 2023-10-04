package br.com.gabrielmusskopf.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;

import br.com.gabrielmusskopf.domain.Pessoa;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaRepositorio implements PanacheRepository<Pessoa> {

	public List<Pessoa> buscarTermo(String termo) {
		var q = "%" + termo + "%";
		return find("termos like ?1", q)
				.page(Page.of(0, 50))
				.list();
	}

}
