package com.kb.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kb.domain.BoardVO;
import com.kb.domain.MemberCriteria;
import com.kb.domain.MemberVO;
import com.kb.domain.BoardCriteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//DB연결 들어있는 부분
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTests {

	@Setter(onMethod_ =@Autowired)
	MemberMapper mapper;
	
	
	public void getListTest() {
		log.info(mapper.getList());
	}
	
	@Test
	public void testRead() {
		MemberVO vo = mapper.readLogin("admin9");
		log.info(vo);
	}
	
	
	public void getListWithPaging() {
		MemberCriteria cri = new MemberCriteria();
		cri.setPageNum(1);
		cri.setAmount(20);/*
							 * cri.setType("uid"); cri.setKeyword("uname");
							 */
		List<MemberVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
	
	public void insert() {
		MemberVO member = new MemberVO();
		member.setUname("");
		member.setSchoolname("");
		member.setGradeclass("");
		member.setUid("");
		member.setUpw("");
		member.setRoute("");
		member.setBoardingplace("");
		mapper.insert(member);
	}
	
	
	public void read() {
		log.info(mapper.read(13));
	}
	
	
	public void update() {
		MemberVO member = new MemberVO();
		member.setUname("");
		member.setSchoolname("");
		member.setGradeclass("");
		member.setUid("");
		member.setUpw("");
		member.setRoute("");
		member.setBoardingplace("");
		mapper.update(member);
	}
	
	
	public void delete() {
		mapper.delete(13);
	}
	
	
}
