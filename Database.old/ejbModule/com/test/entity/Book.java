package com.test.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book implements Serializable  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long bookId;
	private String namebook;
	private String author;
	private String serial;
	private String catagory;
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getNamebook() {
		return namebook;
	}
	public void setNamebook(String namebook) {
		this.namebook = namebook;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial1) {
		serial = serial1;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	
	
	

}
