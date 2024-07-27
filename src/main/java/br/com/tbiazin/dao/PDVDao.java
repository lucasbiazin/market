package br.com.tbiazin.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import br.com.tbiazin.domain.PDV;

public class PDVDao {

    private EntityManagerFactory entityManagerFactory;

    public PDVDao() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
    }

    public PDV cadastrar(PDV pdv) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            if (pdv.getId() != null) {
                pdv = entityManager.merge(pdv);
            } else {
                entityManager.persist(pdv);
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

        return pdv;
    }

    public void excluir(PDV pdv) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            pdv = entityManager.merge(pdv);
            entityManager.remove(pdv);
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

    public List<PDV> buscarTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<PDV> query = builder.createQuery(PDV.class);
            Root<PDV> root = query.from(PDV.class);
            query.select(root);

            TypedQuery<PDV> tpQuery = entityManager.createQuery(query);
            return tpQuery.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public PDV buscarPorNome(String nome) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<PDV> query = builder.createQuery(PDV.class);
            Root<PDV> root = query.from(PDV.class);
            query.select(root).where(builder.equal(root.get("nome"), nome));

            TypedQuery<PDV> tpQuery = entityManager.createQuery(query);
            return tpQuery.getResultStream().findFirst().orElse(null);
        } finally {
            entityManager.close();
        }
    }
}
