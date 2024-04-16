package br.unipar.programacaointernet.servicecep.bibliotecaapi.service;

import br.unipar.programacaointernet.servicecep.bibliotecaapi.model.Estante;
import br.unipar.programacaointernet.servicecep.bibliotecaapi.model.Livro;
import br.unipar.programacaointernet.servicecep.bibliotecaapi.repository.EstanteRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class EstanteService {

    @Inject
    private EstanteRepository estanteRepository;

    public List<Estante> listar(){return estanteRepository.listar();}

    public void cadastrar(Estante estante) throws Exception{
        estanteRepository.cadastrar(estante);
    }

    public void atualizar(Estante estante) throws Exception{
        estanteRepository.atualizar(estante);
    }

    public void deletar(Estante estante) throws Exception{
        deletar(estante.getId());
    }
    private void deletar(Integer id) throws Exception {
        try {
            estanteRepository.deletar(id);
        } catch (Exception ex) {
            throw new Exception("Erro ao deletar estante: " + ex.getMessage());
        }
    }
}
