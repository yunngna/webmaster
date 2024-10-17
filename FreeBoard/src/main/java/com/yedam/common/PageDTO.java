package com.yedam.common;

import lombok.Data;
@Data
public class PageDTO {
	private int startPage, endPage; //첫페이지와 마지막 페이지 
	private boolean prev , next;
	
	private int page; // 현재페이지
	
	public PageDTO(int page) {
		int totalCnt = 49; // 총 데이터 갯수
		
		//Math.ceil = 반올림 
		this.endPage = (int)Math.ceil(page/10.0)*10; // 기준의 마지막 페이지 지정
		this.startPage = this.endPage - 9; // 기준의 첫 페이지 지정 
		
		// 실제 마지막 페이지
		int realEnd = (int)Math.ceil(totalCnt/5.0);
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage; 
		// 만약 기준의 마지막 페이지가 실제 마지막 페이지 보다 크다면, 실제 페이지 = 마지막 페이지 
		//, 그러나 아닌 경우에는 기준의 마지막 페이지 = 마지막 페이지 

		// 이전페이지 가기
		this.prev = this.startPage >1; // 시작 페이지 1보다 
		
		// 다음페이지 가기 
		this.next = this.endPage < realEnd;
	}

}
