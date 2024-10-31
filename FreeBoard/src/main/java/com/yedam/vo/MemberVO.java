package com.yedam.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// getter setter 자동으로 설치해주기 
// lombok 활용(설치) 
// 1. eclipse 설치 (구글에서 검색해서 다운 받기)  2. 라이브러리 
@Getter
@Setter
@ToString
public class MemberVO {
	// 필드 *tbl_member 테이블
	private String memberId;
	private String password;
	private String memberName;
	private String phone;
	private String responsibility;
	private Date creationDate;
	
	//프로젝트 테스트 용 
	private String memberIds;
	private String passwords;	
	private String memberNames;	
	private String address;
	private String email;
	private String tel;	
	private Date joinedDate;
	private String permission;
	
}
