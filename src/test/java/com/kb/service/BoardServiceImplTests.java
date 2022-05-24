package com.kb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kb.domain.BoardVO;
import com.kb.domain.Criteria;
import com.kb.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class BoardServiceImplTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	
	// 등록하기(mapper에는 insert, service에는 register)
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성한 글");
		board.setContent("새로 작성한 내용");
		board.setWrtier("newbie");
		service.register(board);
	}
	
	
	public void getList() {
		service.getList();		// 호출만 하면  된다.
	}
	
	
	public void get() {
		log.info(service.get(14));
	}
	
	@Test
	public void getListWithPaging() {
		Criteria cri = new Criteria();
		service.getListWithPaging(cri);
	}
	
	public void modify() {
		BoardVO board = new BoardVO();
		board.setBno(14);
		board.setTitle("다시 수정한 글");
		board.setContent("다시 수정한 내용");
		board.setWrtier("newbie");
		service.modify(board);
	}
	
	
	public void remove() {
		service.remove(14);
	}
	
}
