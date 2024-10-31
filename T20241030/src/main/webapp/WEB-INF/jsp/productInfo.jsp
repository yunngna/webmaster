<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Product section-->
		<section class="py-5">
			<div class="container px-4 px-lg-5 my-5">
				<div class="row gx-4 gx-lg-5 align-items-center">
					<div class="col-md-6">
						<img class="card-img-top mb-5 mb-md-0"
							src="images/${products.prodImage }" alt="..." />
					</div>
					<div class="col-md-6">
						<div class="small mb-1">${Products.prdCode}</div>
						<h1 class="display-5 fw-bolder">${products.prdName}</h1>
						<div class="fs-5 mb-5">
						<!-- Product price-->
                         <span class="text-muted text-decoration-line-through">
							<fmt:formatNumber value="${products.originPrice}" pattern="#,###"/>원
						</span><fmt:formatNumber value="${products.salePrice}" pattern="#,###"/>원
						</div>
						<p class="lead">${products.prdDesc}</p>
						<div class="d-flex">
							<input class="form-control text-center me-3" id="inputQuantity"
								type="num" value="1" style="max-width: 3rem" />
							<button class="btn btn-outline-dark flex-shrink-0" type="button">
								<i class="bi-cart-fill me-1"></i> Add to cart
							</button>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- Related items section-->
		<section class="py-5 bg-light">
			<div class="container px-4 px-lg-5 mt-5">
				<h2 class="fw-bolder mb-4">평점순 정렬된 목록</h2>
				<div
					class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
					<c:forEach var="product" items="${productList}" begin="1" end="4">
						<div class="col mb-5">
							<div class="card h-100">
								<!-- Sale badge-->
								<div class="badge bg-dark text-white position-absolute"
									style="top: 0.5rem; right: 0.5rem">Sale</div>
								<!-- Product image-->
								<img class="card-img-top" src="images/${product.prodImage}"
									alt="..." />
								<!-- Product details-->
								<div class="card-body p-4">
									<div class="text-center">
										<!-- Product name-->
										<h5 class="fw-bolder">${product.prdName}</h5>
										<!-- Product reviews-->
										<div
											class="d-flex justify-content-center small text-warning mb-2">
											<c:forEach var="star" begin="1" end="${product.starPoint}">
												<div class="bi-star-fill"></div>
											</c:forEach>
										</div>
										<!-- Product price-->
										<!-- Product price-->
                                    <span class="text-muted text-decoration-line-through">
										<fmt:formatNumber value="${product.originPrice}" pattern="#,###"/>원
									</span><fmt:formatNumber value="${product.salePrice}" pattern="#,###"/>원
										
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>
	
		
