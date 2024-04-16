package br.unipar.programacaointernet.servicecep.bibliotecaapi.service;

import br.unipar.programacaointernet.servicecep.bibliotecaapi.model.Livro;
import br.unipar.programacaointernet.servicecep.bibliotecaapi.repository.LivroRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class LivroService {

    @Inject
    private LivroRepository livroRepository;

    public List<Livro> listar(){
        return livroRepository.listar();
    }

    public List<Livro>listarLivre(){
        return livroRepository.listarLivre();
    }

    public void cadastrar(Livro livro) throws Exception{
        livroRepository.cadastrar(livro);
    }

    public void atualizar(Livro livro) throws Exception{
        livroRepository.atualizar(livro);
    }

    public void deletar(Livro livro) throws Exception{
        deletar(livro.getId());
    }

    private void deletar(Integer id) throws Exception {
        try {
            livroRepository.deletar(id);
        } catch (Exception ex) {
            throw new Exception("Erro ao deletar livro: " + ex.getMessage());
        }
    }
}
