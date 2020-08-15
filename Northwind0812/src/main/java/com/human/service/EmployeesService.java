package com.human.service;

import java.util.List;

import com.human.domain.Criteria;
import com.human.domain.EmployeesDto;
import com.human.domain.SearchCriteria;

public interface EmployeesService {

	public List<EmployeesDto> listAll() throws Exception;

	public void insert(int employeeid, String lastname, String firstname, String title, String titleofcourtesy,
			String birthdate, String hiredate, String address, String city, String region, String postalcode,
			String country, String homephone, String extension, String photo, String notes, int reportsto,
			String photopath) throws Exception;

	public void update(int employeeid, String lastname, String firstname, String title, String titleofcourtesy,
			String address, String city, String region, String postalcode, String country, String homephone,
			String extension, String photo, String notes, int reportsto, String photopath) throws Exception;

	public void delete(int employeeid);

	public List<EmployeesDto> listCriteria(Criteria cri) throws Exception;

	public int listCountCriteria(Criteria cri) throws Exception;

	public List<EmployeesDto> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public void modify(EmployeesDto board) throws Exception;
}
