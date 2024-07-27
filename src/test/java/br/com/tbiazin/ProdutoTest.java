package br.com.tbiazin;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import br.com.tbiazin.domain.Produto;

public class ProdutoTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Produto produto = new Produto();
            produto.setNome("Produto Teste");
            produto.setPreco(BigDecimal.valueOf(50.00));
            produto.setDescricao("Descrição Teste");
            produto.setTipo("Tipo Teste");
            produto.setEan("1234567890123");
            produto.setDataCadastro(LocalDate.now());
            produto.setEstoque(100);

            em.persist(produto);

            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
