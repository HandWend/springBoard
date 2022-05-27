package com.kb.service;

import java.util.List;

import com.kb.domain.BoardVO;
import com.kb.domain.BoardCriteria;

public interface BoardService {

	

	// insert
	public void register(BoardVO board);
	
	// read(int)
	public  BoardVO get(int bno);
	
	//update
	public boolean modify(BoardVO board);
	
	//delete
	public boolean remove(int bno);
	
	// read(list)
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(BoardCriteria cri);

	public int getListWithCnt(BoardCriteria cri);

	
}
