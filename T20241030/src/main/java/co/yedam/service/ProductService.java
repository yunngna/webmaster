package co.yedam.service;

import java.util.List;

import co.yedam.vo.ProductVO;

public interface ProductService {
	String cheeringMessage();
	String hintMessage(String remainTimeString);
	
	//전체조회
	List<ProductVO>productList();
	//상세조회
	ProductVO selectProduct(String prdCode);
	
}
