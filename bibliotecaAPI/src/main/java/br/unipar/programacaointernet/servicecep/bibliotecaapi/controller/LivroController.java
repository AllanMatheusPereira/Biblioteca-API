package br.unipar.programacaointernet.servicecep.bibliotecaapi.controller;

import br.unipar.programacaointernet.servicecep.bibliotecaapi.model.Livro;
import br.unipar.programacaointernet.servicecep.bibliotecaapi.service.LivroService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core. MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Livro")
public class LivroController {

    @Inject
    private LivroService livroService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarLivros(){
        return Response.ok(livroService.listar()).build();
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarLivrosLivre(){
        return Response.ok(livroService.listarLivre()).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarLivro(Livro livro) {
        try {
            livroService.cadastrar(livro);
            return Response.status(201).entity("Livro cadastrado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response atualizarLivro(Livro livro) {
        try {
            livroService.atualizar(livro);
            return Response.status(201).entity("Livro atualizado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletarLivro(Livro livro){
        try {
            livroService.deletar(livro);
            return Response.status(201).entity("Livro deletado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
