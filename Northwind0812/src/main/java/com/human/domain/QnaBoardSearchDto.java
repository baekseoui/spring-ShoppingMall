package com.human.domain;

public class QnaBoardSearchDto extends QnaBoardPageDto {
	private String searchVal;
	private String searchCol;
	private int productID;
	
	

	public void makePage(int page,int pageDataCount,int totalDataCount,String searchCol,String searchVal,int productID) {
		makePage(page,pageDataCount,totalDataCount);
		this.productID=productID;
		this.searchCol=searchCol;
		this.searchVal=searchVal;
		
	};

	@Override
	public String toString() {
		return super.toString()+"\n QnaBoardSearchDto [searchVal=" + searchVal + ", searchCol=" + searchCol + ", productID=" + productID
				+ "]";
	}
	
	public String getSearchVal() {
		return searchVal;
	}
	public void setSearchVal(String searchVal) {
		this.searchVal = searchVal;
	}
	public String getSearchCol() {
		return searchCol;
	}
	public void setSearchCol(String searchCol) {
		this.searchCol = searchCol;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	
}
