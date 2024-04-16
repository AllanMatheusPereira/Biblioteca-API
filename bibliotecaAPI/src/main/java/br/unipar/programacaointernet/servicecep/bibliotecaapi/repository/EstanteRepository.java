package br.unipar.programacaointernet.servicecep.bibliotecaapi.repository;

import br.unipar.programacaointernet.servicecep.bibliotecaapi.model.Estante;
import br.unipar.programacaointernet.servicecep.bibliotecaapi.model.Livro;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class EstanteRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Estante> listar(){
        String jpql = "SELECT E FROM Estante E";
        return em.createQuery(jpql, Estante.class).getResultList();
    }

    public void cadastrar(Estante estante) throws Exception{
        try {
            em.persist(estante);
        }catch (Exception ex){
            throw new Exception("Estante não pode ser cadastrada");
        }
    }

    public void atualizar(Estante estante) throws Exception {
        try {
            em.merge(estante);
        } catch (Exception ex) {
            throw new Exception("Estante não pode ser atualizada");
        }
    }

    public void deletar(Integer id) throws Exception {
        try {
            Estante estante= em.find(Estante.class, id);
            em.remove(estante);
        } catch (Exception ex) {
            throw new Exception("Estante não pode ser deletada");
        }
    }

}
