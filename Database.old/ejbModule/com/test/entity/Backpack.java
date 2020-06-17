package com.test.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Backpack implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookId;
	private String bookName;
	
	public void setBookId(long bId) {
		this.bookId = bId;
	}
	public void setBookName(String bname) {
		this.bookName = bname;
	}
	public long getBookId() {
		return bookId;
	}
	public String getBookName() {
		return bookName;
	}
	@ManyToOne
	private Member member;
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	@OneToMany (mappedBy="backpack",cascade= {CascadeType.ALL})
	private List<Rent> rent;

	public List<Rent> getRent() {
		return rent;
	}
	public void setRent(List<Rent> rent) {
		this.rent = rent;
	}
	
}
