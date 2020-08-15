package com.human.domain;

public class SuppliersDto {
	private int supplierID =0;
	private String companyName =null;
	private String contactName =null;
	private String contactTitle =null;
	private String address =null;
	private String city =null;
	private String region =null;
	private String postalCode =null;
	private String country =null;
	private String phone =null;
	private String fax =null;
	private String homePage =null;
	
	@Override
	public String toString() {
		return "SuppliersDto [���޾�ü ID =" + supplierID + ", \tȸ��� =" + companyName + ", \t�̸� ="
				+ contactName + ", \t���� =" + contactTitle + ", \t�ּ� =" + address + ", \t���ø� =" + city
				+ ", \t���� =" + region + ", \t�����ȣ =" + postalCode + ", \t���� =" + country + ", \t����ó =" + phone
				+ ", \t�ѽ� ��ȣ =" + fax + ", \tȨ������ �ּ�=" + homePage + "]";
	}

	public int getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTitle() {
		return contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

}