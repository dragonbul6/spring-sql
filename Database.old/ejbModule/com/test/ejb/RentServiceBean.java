package com.test.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.test.entity.Backpack;
import com.test.entity.Rent;

@Stateless
@Remote(RentService.class)
public class RentServiceBean implements RentService{

	@PersistenceContext (unitName = "myDatabase")
	EntityManager em;
	@Override
	public void insert(Rent bp) {
		// TODO Auto-generated method stub
		this.em.persist(bp);
	}

	@Override
	public void update(Rent mb) {
		// TODO Auto-generated method stub
		this.em.merge(mb);
	}

	@Override
	public List<Rent> showrent(long bid) {
		return em.createQuery("SELECT em FROM Rent em WHERE em.member.memberId = :fn").setParameter("fn", bid).getResultList();
	}

	public void delete(long mbId) {
		// TODO Auto-generated method stub
		Rent mn = findrent(mbId);
		if (mn != null){
		em.remove(mn);
	}
	}

		public Rent findrent(long memberId) {
			// TODO Auto-generated method stub
			return this.em.find(Rent.class,memberId);
		}
		
		

		
}
