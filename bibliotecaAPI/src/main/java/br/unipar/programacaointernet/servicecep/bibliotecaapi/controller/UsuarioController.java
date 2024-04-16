package br.unipar.programacaointernet.servicecep.bibliotecaapi.controller;

import br.unipar.programacaointernet.servicecep.bibliotecaapi.model.Livro;
import br.unipar.programacaointernet.servicecep.bibliotecaapi.model.Usuario;
import br.unipar.programacaointernet.servicecep.bibliotecaapi.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Usuario")
public class UsuarioController {

    @Inject
    private UsuarioService usuarioService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarUsuarios(){ return Response.ok(usuarioService.listar()).build();}

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarUsuario(Usuario usuario){
        try {
            usuarioService.cadastrar(usuario);
            return Response.status(201).entity("Usuario cadastrado com sucesso").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response atualizarUsuario(Usuario usuario) {
        try {
            usuarioService.atualizar(usuario);
            return Response.status(201).entity("Usuario atualizado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletarLivro(Usuario usuario){
        try {
            usuarioService.deletar(usuario);
            return Response.status(201).entity("Usuario deletado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
