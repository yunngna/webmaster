package co.yedam.service;

import java.util.List;

import co.yedam.vo.ProductVO;

public interface ProductService {
	String cheeringMessage();
	String hintMessage(String remainTimeString);
	
	//전체 조회
	List<ProductVO> productList();
	
	//단건 조회 
	ProductVO selectProduct(String proCode);
	
}
