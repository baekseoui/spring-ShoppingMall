package com.human.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.domain.Criteria;
import com.human.domain.EmployeesDto;
import com.human.domain.EmployeesInsertDto;
import com.human.domain.EmployeesUpdateDto;
import com.human.domain.SearchCriteria;
import com.human.mapper.EmployeesMapper;



@Service
public class EmployeesServiceImpl implements EmployeesService {
	
	@Inject
	private EmployeesMapper dao;
	
	@Override
	public List<EmployeesDto> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public void insert(int employeeid, String lastname, String firstname, String title, String titleofcourtesy,
			String birthdate, String hiredate, String address, String city, String region, String postalcode,
			String country, String homephone, String extension, String photo, String notes, int reportsto,
			String photopath) throws Exception {
		// TODO Auto-generated method stub
		
		EmployeesInsertDto dto = new EmployeesInsertDto();
		
		dto.setEmployeeid(employeeid);
		dto.setLastname(lastname);
		dto.setFirstname(firstname);
		dto.setTitle(title);
		dto.setTitleofcourtesy(titleofcourtesy);
		dto.setBirthdate(birthdate);
		dto.setHiredate(hiredate);
		dto.setAddress(address);
		dto.setCity(city);
		dto.setRegion(region);
		dto.setPostalcode(postalcode);
		dto.setCountry(country);
		dto.setHomephone(homephone);
		dto.setExtension(extension);
		dto.setPhoto(photo);
		dto.setNotes(notes);
		dto.setReportsto(reportsto);
		dto.setPhotopath(photopath);
		
		dao.insert(dto);
	}



	@Override
	public void update(int employeeid,String lastname, String firstname, String title, String titleofcourtesy,
			String address, String city, String region, String postalcode,
			String country, String homephone, String extension, String photo, String notes, int reportsto,
			String photopath) throws Exception {
		// TODO Auto-generated method stub
		
		
		EmployeesUpdateDto dto = new EmployeesUpdateDto();
		
		
		dto.setEmployeeid(employeeid);
		dto.setLastname(lastname);
		dto.setFirstname(firstname);
		dto.setTitle(title);
		dto.setTitleofcourtesy(titleofcourtesy);
		dto.setAddress(address);
		dto.setCity(city);
		dto.setRegion(region);
		dto.setPostalcode(postalcode);
		dto.setCountry(country);
		dto.setHomephone(homephone);
		dto.setExtension(extension);
		dto.setPhoto(photo);
		dto.setNotes(notes);
		dto.setReportsto(reportsto);
		dto.setPhotopath(photopath);
		
		dao.update(dto);
		
		
		
	}



	@Override
	public void delete(int employeeid) {
		// TODO Auto-generated method stub
		
		try {
			dao.delete(employeeid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	@Override
	public List<EmployeesDto> listCriteria(Criteria cri) throws Exception {

		return dao.listCriteria(cri);
	}
	
	@Override
	public int listCountCriteria(Criteria cri) throws Exception {

		return dao.countPaging(cri);
	}



	@Override
	public List<EmployeesDto> listSearchCriteria(SearchCriteria cri) throws Exception {

		return dao.listSearch(cri);
	}

	
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {

		return dao.listSearchCount(cri);
	}
	
	

	@Override
	public void modify(EmployeesDto board) throws Exception {
		dao.update(board);
	}

	
	

}
