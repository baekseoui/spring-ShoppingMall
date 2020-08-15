package com.human.mapper;

import java.util.List;

import com.human.domain.Criteria;
import com.human.domain.EmployeesDto;
import com.human.domain.EmployeesInsertDto;
import com.human.domain.EmployeesUpdateDto;
import com.human.domain.SearchCriteria;

public interface EmployeesMapper {

	public void update(EmployeesUpdateDto vo) throws Exception;

	public void delete(int employeeid) throws Exception;

	public List<EmployeesDto> listAll() throws Exception;

	public void insert(EmployeesInsertDto vo);

	public List<EmployeesDto> listCriteria(Criteria cri) throws Exception;

	public int countPaging(Criteria cri) throws Exception;

	public List<EmployeesDto> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

	public void update(EmployeesDto vo) throws Exception;
}
