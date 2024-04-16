package br.unipar.programacaointernet.servicecep.bibliotecaapi.repository;

import br.unipar.programacaointernet.servicecep.bibliotecaapi.model.Livro;
import jakarta.ejb.Stateless;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class LivroRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Livro> listar() {
        String jpql = "SELECT l FROM Livro l";
        return em.createQuery(jpql, Livro.class).getResultList();
    }

    public List<Livro> listarLivre() {
        String jpql = "SELECT l FROM Livro l WHERE l.classificacao_etaria='Livre' ";
        return em.createQuery(jpql, Livro.class).getResultList();
    }

    public void cadastrar(Livro livro) throws Exception {
        try {
            em.persist(livro);
        } catch (Exception ex) {
            throw new Exception("Livro não pode ser cadastrado");
        }
    }

    public void atualizar(Livro livro) throws Exception {
        try {
            em.merge(livro);
        } catch (Exception ex) {
            throw new Exception("Livro não pode ser atualizado");
        }
    }

    public void deletar(Integer id) throws Exception {
        try {
            Livro livro= em.find(Livro.class, id);
            em.remove(livro);
        } catch (Exception ex) {
            throw new Exception("Livro não pode ser deletado");
        }
    }

}