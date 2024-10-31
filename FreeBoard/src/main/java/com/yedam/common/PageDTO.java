package com.yedam.common;

import lombok.Data;
@Data
public class PageDTO {
	private int startPage, endPage; //첫페이지와 마지막 페이지 
	private boolean prev , next;
	
	private int page; // 현재페이지
	
	public PageDTO(int page, int totalCnt) {
//		int totalCnt = 392; // 총 데이터 갯수 
		// 데이터 총 갯수 |(mapper에서 만들어서 사용하기) toalCnt 를 매개값으로 받아서 사용 
		
		// 현재 페이지 값을 가져오기 (현재 위치 페이지 가져오기 )
		this.page = page; 
		
		//Math.ceil = 반올림 
		this.endPage = (int) Math.ceil(page/10.0)*10; // 기준의 마지막 페이지 지정
		this.startPage = this.endPage - 9; // 기준의 첫 페이지 지정 
		
		// 실제 마지막 페이지
		int realEnd = (int)Math.ceil(totalCnt/5.0); // 실제 데이터 건수에 따라 최종 데이터를 가져오기  (만약 데이터가 49 개 이면.. 49/5.0 => 9.8 이라서 반올림으로 10 ) 
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage; 
		// 만약 기준의 마지막 페이지가 실제 마지막 페이지 보다 크다면, 실제 페이지 = 마지막 페이지 
		//, 그러나 아닌 경우에는 기준의 마지막 페이지 = 마지막 페이지 

		// 이전페이지 가기
		this.prev = this.startPage >1; // 시작 페이지가 1 이 아니면 true (=이전 페이지가 있음)
		
		// 다음페이지 가기 
		this.next = this.endPage < realEnd; // 마지막 페이지가  실제 페이지 보다 작으면 true ( 다음 페이지가 있음)
	}

}
