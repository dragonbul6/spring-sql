package com.test.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.test.entity.Backpack;
import com.test.entity.Book;
import com.test.entity.Member;

@Stateless
@Remote(BackpackService.class)
public class BackpackServiceBean implements BackpackService {
	@PersistenceContext (unitName = "myDatabase")
	EntityManager em;
	@Override
	public void insert(Backpack bp) {
		// TODO Auto-generated method stub
		this.em.persist(bp);
	}

	@Override
	public void update(Backpack mb) {
		// TODO Auto-generated method stub
		this.em.merge(mb);
	}

	@Override
	public List<Backpack> showbackpack(long bid) {
		return em.createQuery("SELECT em FROM Backpack em WHERE em.member.memberId = :fn").setParameter("fn", bid).getResultList();
	}

	public void delete(long mbId) {
		// TODO Auto-generated method stub
		Backpack mn = findbackpack(mbId);
		if (mn != null){
		em.remove(mn);
	}
	}

		public Backpack findbackpack(long memberId) {
			// TODO Auto-generated method stub
			return this.em.find(Backpack.class,memberId);
		}

	}




