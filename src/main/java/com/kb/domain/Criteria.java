package com.kb.domain;

import lombok.Data;

@Data
public class Criteria {

	private int pageNum; 	//현재페이지번호
	private int amount;		//한 페이지당 보여줄 게시글 수
	
	public Criteria() {
		this(1, 10);
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	//사용법: Mybatis xml에서 #{pageStart} 로 사용된다.
	//mySql에서 (getPageNum() -1) * getAmount()가 syntax에러가 나서 메소드로 만들어준다.
	public int getPageStart() {
		return (getPageNum() -1) * getAmount();
	}
	
}
