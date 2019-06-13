package br.com.caelum.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.caelum.JpaConfigurator;
import br.com.caelum.model.Produto;

public class TestaCache {

	public static void main(String[] args) {
		//O spring me da um entityManager por isso presciso do contexto
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfigurator.class);
		//ctx me retorna um EntityManagerFactory para criar o EntityManager
		EntityManagerFactory emf = ctx.getBean(EntityManagerFactory.class);
		
		EntityManager em = emf.createEntityManager();
		EntityManager em2 = emf.createEntityManager();
		Produto produto = em.find(Produto.class, 6);
		Produto produto2 = em2.find(Produto.class, 6);
		
		System.out.println(produto.getNome());
		System.out.println(produto2.getNome());
		
		em.close();		
	}
}
