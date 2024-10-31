package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.ProductVO;

public interface ProductMapper {
	String selectMessage();
	String selectHint(String remainTimeString);
	
	// 전체조회 
	List<ProductVO> productList();
	
	//상세조회
	ProductVO selectProduct(String prdCode);
	

}
