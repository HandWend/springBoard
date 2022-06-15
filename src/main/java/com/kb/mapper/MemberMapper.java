package com.kb.mapper;

import java.util.List;


import com.kb.domain.MemberCriteria;
import com.kb.domain.MemberVO;


public interface MemberMapper {

	// 목록보기
	public List<MemberVO> getList();
	
	public List<MemberVO> getListWithPaging(MemberCriteria cri);
	
	// 등록하기
	public void insert(MemberVO member);
	
	// 읽기(특정번호)
	public MemberVO read(int num);
	
	public MemberVO readLogin(String userid);
	
	public int update(MemberVO member);
	
	public int delete(int num);

	public int getListWithCnt(MemberCriteria cri);
}
