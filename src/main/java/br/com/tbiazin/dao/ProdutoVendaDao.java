package br.com.tbiazin.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import br.com.tbiazin.domain.ProdutoVenda;

public class ProdutoVendaDao {

	public class ProdutoDao {

		public ProdutoVenda cadastrar(ProdutoVenda produtoVenda) {
				
				EntityManagerFactory entityManagerFactory = 
						Persistence.createEntityManagerFactory("ExemploJPA");
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				
				entityManager.getTransaction().begin();
				entityManager.persist(produtoVenda);
				entityManager.getTransaction().commit();
				 
				entityManager.close();
				entityManagerFactory.close();
				
				
				return produtoVenda;
			}

			
			public void excluir(ProdutoVenda produtoVenda) {
				EntityManagerFactory entityManagerFactory = 
						Persistence.createEntityManagerFactory("ExemploJPA");
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				
				entityManager.getTransaction().begin();
				produtoVenda = entityManager.merge(produtoVenda);
				entityManager.remove(produtoVenda);
				entityManager.getTransaction().commit();
				 
				entityManager.close();
				entityManagerFactory.close();
				
			}

			
			public List<ProdutoVenda> buscarTodos() {
				EntityManagerFactory entityManagerFactory = 
						Persistence.createEntityManagerFactory("ExemploJPA");
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				
				
				CriteriaBuilder builder = entityManager.getCriteriaBuilder();
				CriteriaQuery<ProdutoVenda> query = builder.createQuery(ProdutoVenda.class);
				Root<ProdutoVenda> root = query.from(ProdutoVenda.class);
				query.select(root);
				
				TypedQuery<ProdutoVenda> tpQuery = 
						entityManager.createQuery(query);
				List<ProdutoVenda> list = tpQuery.getResultList();  
				
				entityManager.close();
				entityManagerFactory.close();
				return list;
			}
      }

	public ProdutoVenda cadastrar(ProdutoVenda produtoVenda) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(produtoVenda);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		
		
		return produtoVenda;
	}
}