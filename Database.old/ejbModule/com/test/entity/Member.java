package com.test.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Member implements Serializable{
	
	@Id
	private long memberId;
	
	private String studentid;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private String name;
	

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getStudentId() {
		return studentid;
	}
	public void setStudentId(String studentid) {
		this.studentid = studentid;
	}
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	@OneToMany (mappedBy="member",cascade= {CascadeType.ALL})
	private List<Backpack> backpack;
	public List<Backpack> getBackpack() {
		return backpack;
	}
	public void setBackpack(List<Backpack> backpack) {
		this.backpack = backpack;
	}

	@OneToMany (mappedBy="member", cascade= {CascadeType.ALL})
	private List<Rent> rent;
	public List<Rent> getRent() {
		return rent;
	}
	public void setRent(List<Rent> rent) {
		this.rent = rent;
	}
	
}
