package br.com.gabrielmusskopf.resource;

import java.time.LocalDate;
import java.util.List;

import org.jboss.resteasy.reactive.ResponseStatus;

import br.com.gabrielmusskopf.domain.Pessoa;
import br.com.gabrielmusskopf.service.PessoaServico;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pessoas")
public class PessoaResource {

	@Inject
	PessoaServico pessoaServico;

	public PessoaResource(PessoaServico pessoaServico) {
		this.pessoaServico = pessoaServico;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> buscarTermo(@QueryParam("t") String termo){
		return pessoaServico.buscarTermo(termo);
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPessoa(@PathParam("id") Long id){
		var pessoa = pessoaServico.buscar(id);
		return pessoa.isPresent()
				? Response.ok(pessoa.get()).build()
				: Response.status(404).build();
	}

    @POST
	@Transactional
	@ResponseStatus(200)
    @Produces(MediaType.APPLICATION_JSON)
    public void criarPessoa(@Valid PessoaRequisicao requisicao) {
		pessoaServico.criar(requisicao.nome, requisicao.apelido, requisicao.stack, requisicao.dataNasicmento);
    }

	public record PessoaRequisicao(@NotNull String nome, @NotNull String apelido, List<String> stack, LocalDate dataNasicmento){}

}
