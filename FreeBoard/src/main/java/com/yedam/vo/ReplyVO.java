package com.yedam.vo;

import java.util.Date;

import lombok.Data;
@Data // getter,setter 자동으로 생성, 및 시퀀스,toString,equals,hashCode overide 해준다.
public class ReplyVO {
	private int replyNo;
	private String reply;
	private String replyer;
	private int boardNo;
	private Date replyDate;
}
