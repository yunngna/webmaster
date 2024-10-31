package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.service.ProductService;
import co.yedam.service.ProductServiceImpl;
import co.yedam.vo.ProductVO;
import main.java.co.yedam.common.Control;

public class ProductControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//커피코드 받아오기 
		String prdCode = req.getParameter("prdCode");
		
		ProductService svc = new ProductServiceImpl();
		ProductVO product = svc.selectProduct(prdCode);
		
		List<ProductVO>list = svc.productList();
		
		req.setAttribute("productList", list);
		
		req.setAttribute("products",product);
		
		req.getRequestDispatcher("product/productInfo.tiles").forward(req, resp);
		
		
		

	}

}
