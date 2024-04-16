package br.unipar.programacaointernet.servicecep.bibliotecaapi.repository;

import br.unipar.programacaointernet.servicecep.bibliotecaapi.model.Livro;
import br.unipar.programacaointernet.servicecep.bibliotecaapi.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class UsuarioRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Usuario> listar(){
        String jpql = "SELECT U FROM Usuario U";
        return em.createQuery(jpql, Usuario.class).getResultList();
    }
    public void cadastrar(Usuario usuario) throws Exception{
        try {
            em.persist(usuario);
        }catch (Exception ex){
            throw new Exception("Usuario não pode ser cadastrado");
        }
    }

    public void atualizar(Usuario usuario) throws Exception {
        try {
            em.merge(usuario);
        } catch (Exception ex) {
            throw new Exception("Usuario não pode ser atualizado");
        }
    }

    public void deletar(Integer id) throws Exception {
        try {
            Usuario usuario= em.find(Usuario.class, id);
            em.remove(usuario);
        } catch (Exception ex) {
            throw new Exception("Usuario não pode ser deletado");
        }
    }
}
