package com.kb.domain;


import java.util.Date;
import java.util.List;

import lombok.Data;

//lombok
@Data
public class BoardVO {

	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private Date updateDate;
	private String realFileName;
	private String realSaveFileName;
	
	private List<BoardAttachVO> attachList;
	
}
