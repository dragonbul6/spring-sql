package com.test.ejb;

import java.util.List;

import com.test.entity.Book;
import com.test.entity.Member;

public interface MemberService {
	public void insert(Member mb);
	public Member findMember(long mbId);
	public void update(Member mb);
	public void delete(long mbId);
	public List<Member> allMember(String username);
	public List<Member> listmember(String username, String password);
	public List<Member> getid(String name);
	public List<Member> getidbyname(String user);
}
