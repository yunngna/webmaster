package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.ProductVO;

public interface ProductMapper {
	
	String selectMessage();
	String selectHint(String remainTimeString);
	
	//목록 보기 
	List<ProductVO>productList();
	
	//상세 조회
	ProductVO selectProduct(String proCode);

}
