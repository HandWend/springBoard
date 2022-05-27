package com.kb.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberVO {

	private int num;
	private String uname;
	private String schoolname;
	private String gradeclass;
	private String uid;
	private String upw;
	private String route;
	private String boardingplace;
	private Timestamp joindate;
	private int coupon;
	
}
