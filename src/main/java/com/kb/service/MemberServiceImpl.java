package com.kb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kb.domain.BoardVO;
import com.kb.domain.MemberVO;
import com.kb.domain.MemberCriteria;
import com.kb.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;	//mapper 객체를 만들어야 mapper로 갈거 아녀~
	
	
	
	@Override
	public void register(MemberVO member) {
		log.info("register");	// 게시글 등록한다~
		mapper.insert(member); 	// service -> mapper의 insert
		// service의 register 호출하면 mapper의 insert가 딩동~
	}

	@Override
	public MemberVO get(int num) {
		// TODO Auto-generated method stub
		return mapper.read(num);
	}

	@Override
	public boolean modify(MemberVO member) {
		// TODO Auto-generated method stub
		return mapper.update(member) == 1;
	}

	@Override
	public boolean remove(int num) {
		// TODO Auto-generated method stub
		return mapper.delete(num) == 1;
	}

	@Override
	public List<MemberVO> getList() {
		log.info("getList..................");
		return mapper.getList();				// 전체 내용을 보여달라
	}

	@Override
	public List<MemberVO> getListWithPaging(MemberCriteria cri) {
		//전체 내용
		log.info("getList..................");
		
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getListWithCnt(MemberCriteria cri) {
log.info("getList..................");
		
		return mapper.getListWithCnt(cri);
	}

	

	
}
