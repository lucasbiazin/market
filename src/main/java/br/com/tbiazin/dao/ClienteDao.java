package br.com.tbiazin.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import br.com.tbiazin.domain.Cliente;

public class ClienteDao implements IClienteDao {

    private EntityManagerFactory entityManagerFactory;

    public ClienteDao() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
    }

    public Cliente cadastrar(Cliente cliente) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            if (cliente.getId() != null) {
                cliente = entityManager.merge(cliente);
            } else {
                entityManager.persist(cliente);
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }

        return cliente;
    }

    public void excluir(Cliente cliente) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            cliente = entityManager.merge(cliente);
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public List<Cliente> buscarTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Cliente> query = builder.createQuery(Cliente.class);
            Root<Cliente> root = query.from(Cliente.class);
            query.select(root);

            TypedQuery<Cliente> tpQuery = entityManager.createQuery(query);
            return tpQuery.getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Cliente buscarPorId(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            return entityManager.find(Cliente.class, id);
        } finally {
            entityManager.close();
        }
    }
}
