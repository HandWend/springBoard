package com.kb.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kb.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//DB연결 들어있는 부분
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ =@Autowired)
	BoardMapper mapper;
	
	
	public void getListTest() {
		log.info(mapper.getList());
	}
	
	
	public void insert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성한 글");
		board.setContent("새로 작성한 내용");
		board.setWrtier("newbie");
		mapper.insert(board);
	}
	
	@Test
	public void read() {
		log.info(mapper.read(13));
	}
	
	
	public void update() {
		BoardVO board = new BoardVO();
		board.setBno(13);
		board.setTitle("다시 수정한 글");
		board.setContent("다시 수정한 내용");
		board.setWrtier("newbie");
		mapper.update(board);
	}
	
	
	public void delete() {
		mapper.delete(13);
	}
}
