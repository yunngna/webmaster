package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data // getter,setter 자동으로 생성, 및 시퀀스,toString,equals,hashCode overide 해준다.
public class BoardVO {
	private int boardNo; // board_no - boardNo
	private String title; 
	private String content;
	private String writer;
	private String writerName;
	private int viewCnt;
	private Date writeDate;
	private Date updateDate;
}
