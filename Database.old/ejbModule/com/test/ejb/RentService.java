package com.test.ejb;

import java.util.List;


import com.test.entity.Rent;

public interface RentService {

	public void insert(Rent bp);
	public void update(Rent mb);
	public List<Rent> showrent(long bid);
	public void delete(long mbId);
	public Rent findrent(long memberId);
}
