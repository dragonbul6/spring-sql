package com.test.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Rent implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long rentId;
	private String date;
	public long getRentId() {
		return rentId;
	}
	public void setRentId(long rentId) {
		this.rentId = rentId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@ManyToOne
	private Member member;

	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	@ManyToOne
	private Backpack backpack;
	public Backpack getbackpack() {
		return backpack;
	}
	public void setbackpack(Backpack backpack) {
		this.backpack = backpack;
	}
	
	
}
