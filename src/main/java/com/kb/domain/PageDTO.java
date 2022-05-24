package com.kb.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

	private int startPage;	//시작페이지
	private int endPage;	//끝 페이지
	
	private boolean prev, next;	//이전, 다음
	
	private int total;	//전체 레코드 수
	
	private Criteria cri; //현재 페이지, 한 페이지당 보여줄 갯수

	public PageDTO(int total, Criteria cri) {
		this.total = total;
		this.cri = cri;
		
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 5.0)) * 5;		//
		this.startPage = this.endPage - 4;		// 9: 마지막 페이지 -9
		
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;		//startPage가 1보다 크면 보여주겠다.	2쪽 이상이면 보여줌.
		this.next = this.endPage < realEnd;	//endPage가 realEnd보다 작으면 보여주겠다. 8쪽인데 9쪽까지 있으면 보여줌.
	}
	
	
}
