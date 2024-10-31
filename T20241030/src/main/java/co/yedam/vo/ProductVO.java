package co.yedam.vo;

import java.sql.Date;

import lombok.Data;

@data
public class ProductVO {
	private String prdCode;
	private String prdName;
	private String prdDesc;
	private int originPrice;
	private int salePrice;
	private int starPoint;
	private String prodImage;
	private Date creationDate;

}
