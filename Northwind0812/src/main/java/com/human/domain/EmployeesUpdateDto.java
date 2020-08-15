package com.human.domain;

import java.util.Date;

public class EmployeesUpdateDto{
	
	public EmployeesUpdateDto() {}
	public EmployeesUpdateDto(int employeeid, String lastname, String firstname, String title, String titleofcourtesy,
			String address, String city, String region, String postalcode, String country, String homephone,
			String extension, String photo, String notes, int reportsto, String photopath) {
		super();
		this.employeeid = employeeid;
		this.lastname = lastname;
		this.firstname = firstname;
		this.title = title;
		this.titleofcourtesy = titleofcourtesy;
		this.address = address;
		this.city = city;
		this.region = region;
		this.postalcode = postalcode;
		this.country = country;
		this.homephone = homephone;
		this.extension = extension;
		this.photo = photo;
		this.notes = notes;
		this.reportsto = reportsto;
		this.photopath = photopath;
	}
	int employeeid;
	String lastname;
	String firstname;
	String title;
	String titleofcourtesy;
	String address;
	String city;
	String region;
	String postalcode;
	String country;
	String homephone;
	String extension;
	String photo;
	String notes;
	int reportsto;
	String photopath;
	
	
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleofcourtesy() {
		return titleofcourtesy;
	}
	public void setTitleofcourtesy(String titleofcourtesy) {
		this.titleofcourtesy = titleofcourtesy;
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
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHomephone() {
		return homephone;
	}
	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getReportsto() {
		return reportsto;
	}
	public void setReportsto(int reportsto) {
		this.reportsto = reportsto;
	}
	public String getPhotopath() {
		return photopath;
	}
	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}
	@Override
	public String toString() {
		return "EmployeesUpdateDto [employeeid=" + employeeid + ", lastname=" + lastname + ", firstname=" + firstname
				+ ", title=" + title + ", titleofcourtesy=" + titleofcourtesy + ", address=" + address + ", city="
				+ city + ", region=" + region + ", postalcode=" + postalcode + ", country=" + country + ", homephone="
				+ homephone + ", extension=" + extension + ", photo=" + photo + ", notes=" + notes + ", reportsto="
				+ reportsto + ", photopath=" + photopath + "]";
	}
	
	
	
	
}
