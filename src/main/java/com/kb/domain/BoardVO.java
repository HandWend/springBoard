package com.kb.domain;


import java.util.Date;

import lombok.Data;

//lombok
@Data
public class BoardVO {

	
	private int bno;
	private String title;
	private String content;
	private String wrtier;
	private Date regDate;
	private Date updateDate;
	
}
