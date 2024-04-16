package br.unipar.programacaointernet.servicecep.bibliotecaapi.service;

import br.unipar.programacaointernet.servicecep.bibliotecaapi.model.Livro;
import br.unipar.programacaointernet.servicecep.bibliotecaapi.model.Usuario;
import br.unipar.programacaointernet.servicecep.bibliotecaapi.repository.UsuarioRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listar(){return usuarioRepository.listar();}

    public void cadastrar(Usuario usuario) throws Exception{
        usuarioRepository.cadastrar(usuario);
    }

    public void atualizar(Usuario usuario) throws Exception{
        usuarioRepository.atualizar(usuario);
    }

    public void deletar(Usuario usuario) throws Exception{
        deletar(usuario.getId());
    }
    private void deletar(Integer id) throws Exception {
        try {
            usuarioRepository.deletar(id);
        } catch (Exception ex) {
            throw new Exception("Erro ao deletar usuario: " + ex.getMessage());
        }
    }
}
