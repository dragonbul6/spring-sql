package com.test.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import com.test.entity.Book;
import com.test.entity.Member;

@Stateless
@Remote(MemberService.class)
public class MemberServiceBean implements MemberService {
	
	@PersistenceContext(unitName = "myDatabase")
	EntityManager em;
	
	@Override
	public void insert(Member mb) {
		// TODO Auto-generated method stub
		this.em.persist(mb);
	}

	@Override
	public Member findMember(long memberId) {
		// TODO Auto-generated method stub
		return this.em.find(Member.class,memberId);
	}

	@Override
	public void update(Member mb) {
		// TODO Auto-generated method stub
		this.em.merge(mb);
	}

	@Override
	public void delete(long mbId) {
		// TODO Auto-generated method stub
		Member mn = findMember(mbId);
		if (mn != null){
		em.remove(mn);
	}
	}

	@Override
	public List<Member> allMember(String user) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT em FROM Member em WHERE em.studentid LIKE :fn").setParameter("fn", user + "%").getResultList();
	}

	@Transactional
	public List<Member> listmember(String username, String password) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
        Root<Member> Member = criteriaQuery.from(Member.class);
       
        	criteriaQuery.select(Member).where(criteriaBuilder.equal(Member.get("studentid"), username), 
            		criteriaBuilder.equal(Member.get("password"), password));
        
        
        return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public List<Member> getid(String name) {
		
		return em.createQuery("SELECT studentid FROM Member em WHERE em.name LIKE :fn").setParameter("fn", name + "%").getResultList();
	}

	@Override
	public List<Member> getidbyname(String user) {
		
		return em.createQuery("SELECT memberId FROM Member em WHERE em.name LIKE :fn").setParameter("fn", user + "%").getResultList();
	}
	
	

	

	
	
	
	
	
	

}
