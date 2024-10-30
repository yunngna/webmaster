package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.ProductService;
import co.yedam.service.ProductServiceImpl;
import co.yedam.vo.ProductVO;

public class ProductListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//목록 보여주기 
		req.setCharacterEncoding("utf-8");
	
		ProductService svc = new ProductServiceImpl();
		List<ProductVO> list = svc.productList();
		req.setAttribute("productList", list);
	
		
		
		for (ProductVO pro : list) {
			System.out.println(pro);
		}
		req.getRequestDispatcher("WEB-INF/jsp/productList.jsp").forward(req, resp);

	}

}
