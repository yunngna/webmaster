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

public class ProductListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductService svc = new ProductServiceImpl();
		List<ProductVO>list = svc.productList();
		
		req.setAttribute("productList", list);
		
		req.getRequestDispatcher("product/productList.tiles").forward(req, resp);

	}

}
