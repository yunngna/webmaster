package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.ProductService;
import co.yedam.service.ProductServiceImpl;
import co.yedam.vo.ProductVO;

public class ProductControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String code = req.getParameter("proCode");
		
		ProductService svc = new ProductServiceImpl();
		
		ProductVO product = svc.selectProduct(code);
		
		req.setAttribute("productvo", product);
		
		req.getRequestDispatcher("WEB-INF/jsp/productInfo.jsp").forward(req, resp);
		

	}

}
