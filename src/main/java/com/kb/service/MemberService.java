package com.kb.service;

import java.util.List;

import com.kb.domain.MemberVO;
import com.kb.domain.MemberCriteria;

public interface MemberService {

	

	// insert
	public void register(MemberVO member);
	
	// read(int)
	public  MemberVO get(int num);
	
	//update
	public boolean modify(MemberVO member);
	
	//delete
	public boolean remove(int num);
	
	// read(list)
	public List<MemberVO> getList();
	
	public List<MemberVO> getListWithPaging(MemberCriteria cri);

	public int getListWithCnt(MemberCriteria cri);

	
}
