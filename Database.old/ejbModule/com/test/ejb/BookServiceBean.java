package com.test.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.test.entity.Book;

@Stateless
@Remote(BookService.class)
public class BookServiceBean implements BookService {

	@PersistenceContext (unitName = "myDatabase")
	EntityManager em;
	
	@Override
	public void insert(Book mb) {
		
		this.em.persist(mb);
	}

	@Override
	public Book findBook(long mbId) {
		
		return this.em.find(Book.class,mbId);
	}

	@Override
	public void update(Book mb) {
		this.em.merge(mb);
		
	}

	@Override
	public void delete(long mbId) {
		Book bn = findBook(mbId);
		if (bn != null){
		em.remove(bn);
		}
		
	}

	@Override
	public List<Book> allbook() {
		return em.createQuery("SELECT x FROM Book x").getResultList();
	}

	@Override
	public List<Book> getbookcata(String Cata) {
		return em.createQuery("SELECT em FROM Book em WHERE em.catagory LIKE :fn").setParameter("fn", Cata + "%").getResultList();
	}

	@Override
	public List<Book> getIdbyname(String name) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT bookId FROM Book em WHERE em.namebook LIKE :fn").setParameter("fn", name + "%").getResultList();
	}
	
	

}
