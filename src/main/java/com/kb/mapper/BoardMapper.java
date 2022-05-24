package com.kb.mapper;

import java.util.List;

import com.kb.domain.BoardVO;
import com.kb.domain.Criteria;

public interface BoardMapper {

	// 목록보기
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	// 등록하기
	public void insert(BoardVO board);
	
	// 읽기(특정번호)
	public BoardVO read(int bno);
	
	public int update(BoardVO board);
	
	public int delete(int bno);

	public int getListWithCnt();
}
