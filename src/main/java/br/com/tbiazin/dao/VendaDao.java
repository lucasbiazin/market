package br.com.tbiazin.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import br.com.tbiazin.domain.Venda;

public class VendaDao {

    private EntityManagerFactory entityManagerFactory;

    public VendaDao() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
    }

    public Venda cadastrar(Venda venda) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(venda);
        entityManager.getTransaction().commit();

        entityManager.close();

        return venda;
    }

    public Venda buscarPorId(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Venda venda = entityManager.find(Venda.class, id);
        entityManager.close();
        return venda;
    }
}
