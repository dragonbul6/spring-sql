package com.test.ejb;

import java.util.List;

import com.test.entity.Book;
import com.test.entity.Member;

public interface BookService {

	public void insert(Book mb);
	public Book findBook(long mbId);
	public void update(Book mb);
	public void delete(long mbId);
	public List<Book> allbook();
	public List<Book> getbookcata(String Cata);
	public List<Book> getIdbyname(String name);
}
