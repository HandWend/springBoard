package com.kb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kb.domain.BoardVO;
import com.kb.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;	//mapper 객체를 만들어야 mapper로 갈거 아녀~
	
	
	
	@Override
	public void register(BoardVO board) {
		log.info("register");	// 게시글 등록한다~
		mapper.insert(board); 	// service -> mapper의 insert
		// service의 register 호출하면 mapper의 insert가 딩동~
	}

	@Override
	public BoardVO get(int bno) {
		// TODO Auto-generated method stub
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(int bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getList..................");
		return mapper.getList();				// 전체 내용을 보여달라
	}

	

	
}
