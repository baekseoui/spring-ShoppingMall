package com.human.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.human.domain.Criteria;
import com.human.domain.EmployeesDto;
import com.human.domain.EmployeesInsertDto;
import com.human.domain.EmployeesUpdateDto;
import com.human.domain.SearchCriteria;


@Repository
public class EmployeesDAOImpl implements EmployeesDAO {
	@Inject
	private SqlSession session;

	private static String namespace = "com.human.mapper.employeesMapper";


	@Override
	public void delete(int employeeid) throws Exception {
		session.delete(namespace + ".delete", employeeid);
	}

	@Override
	public List<EmployeesDto> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}


	@Override
	public void insert(EmployeesInsertDto vo) {
		// TODO Auto-generated method stub
		session.insert(namespace + ".insert", vo);
		
	}

	
	@Override
	public void update(EmployeesUpdateDto vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".update", vo);
	}
	
	@Override
	public List<EmployeesDto> listCriteria(Criteria cri) throws Exception {

		return session.selectList(namespace + ".listCriteria", cri);
	}

	
	@Override
	public int countPaging(Criteria cri) throws Exception {

		return session.selectOne(namespace + ".countPaging", cri);
	}
	
	
	@Override
	public List<EmployeesDto> listSearch(SearchCriteria cri) throws Exception {

		return session.selectList(namespace + ".listSearch", cri);
	}
	
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {

		return session.selectOne(namespace + ".listSearchCount", cri);
	}
	
	@Override
	public void update(EmployeesDto vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	
}
