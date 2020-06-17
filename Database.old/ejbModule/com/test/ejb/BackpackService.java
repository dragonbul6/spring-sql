package com.test.ejb;

import java.util.List;

import com.test.entity.Backpack;
import com.test.entity.Member;

public interface BackpackService {
	
	public void insert(Backpack bp);
	public void update(Backpack mb);
	public List<Backpack> showbackpack(long bid);
	public void delete(long mbId);
	public Backpack findbackpack(long memberId);
	
	
}
