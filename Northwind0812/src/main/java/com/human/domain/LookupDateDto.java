package com.human.domain;

//import java.sql.Timestamp;
import java.util.Date;

public class LookupDateDto {
	private String orderID;
	private String customerid;
	private Date applicationDate;
	private Date finishDate;
	private String  type;
	
	private String dateFormat;
	
	
	public String getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public String getCustomerID() {
		return customerid;
	}
	public void setCustomerID(String customerID) {
		this.customerid = customerID;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
	@Override
	public String toString() {
		return "LookupDateDto [orderID=" + orderID + ", customerID=" + customerid + ", applicationDate="
				+ applicationDate + ", finishDate=" + finishDate + ", type=" + type + "]";
	}
	public LookupDateDto(String customerID,String orderID, Date applicationDate, Date finishDate, String type) {
		super();
		this.orderID=orderID;
		this.customerid = customerID;
		this.applicationDate = applicationDate;
		this.finishDate = finishDate;
		this.type = type;
	}
	public LookupDateDto() {}
}
