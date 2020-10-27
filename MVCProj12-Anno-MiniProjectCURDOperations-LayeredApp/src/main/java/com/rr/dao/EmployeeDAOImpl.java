package com.rr.dao;

import java.math.BigDecimal;

//CREATE SEQUENCE  "SYSTEM"."ENO_SEQ"  MINVALUE 1 MAXVALUE 1000 INCREMENT BY 1 START WITH 100 CACHE 20 NOORDER  NOCYCLE ;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.rr.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_ALL_EMPLOYEES="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP";
	private static final String INSERT_EMPLOYEE="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL,DEPTNO) VALUES(ENO_SEQ.NEXTVAL,?,?,?,?)";
	private static final String GET_ALL_DPETNO="SELECT DISTINCT DEPTNO FROM EMP WHERE DEPTNO IS NOT NULL";
	private static final String DELETE_EMP_BY_ID="DELETE FROM EMP WHERE EMPNO=?";
	private static final String FETCH_EMP_BY_ID="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	private static final String UPDATE_EMP_BY_ID="UPDATE EMP SET ENAME=?,JOB=?,SAL=?,DEPTNO=? WHERE EMPNO=?";
	@Autowired
	private JdbcTemplate jt;
	
	public List<EmployeeBO> getAllEmployees() {
		List<EmployeeBO> listbo=null;
		listbo=jt.query(GET_ALL_EMPLOYEES, new ListEmployeeRowMapper());
		return listbo;
	}
	
	class ListEmployeeRowMapper implements ResultSetExtractor<List<EmployeeBO>>{
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBO> listbo=new ArrayList<EmployeeBO>();
			//copy rs record to ListBO
			while(rs.next()) {
				EmployeeBO bo=new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getFloat(4));
				bo.setDeptNo(rs.getInt(5));
				listbo.add(bo);
			}//while
			return listbo;
		}//extractData
	}//inner class

	public int insertEmployee(EmployeeBO bo) {
		int count=0;
		count=jt.update(INSERT_EMPLOYEE, bo.getEname(),bo.getJob(),bo.getSal(),bo.getDeptNo());
		return count;
	}
	public List<Integer> getAllDeptnos() {
		 List<Integer> deptNosList=new ArrayList<Integer>();
		 List<Map<String, Object>> listMap=null;
		 listMap=jt.queryForList(GET_ALL_DPETNO);
		 listMap.forEach(e->{
			 deptNosList.add((Integer) ((BigDecimal)e.get("deptno")).intValue());
		 });
		return deptNosList;
	}
	public int deleteEmpById(int id) {
		int count=0;
		count=jt.update(DELETE_EMP_BY_ID,id);
		return count;
	}
	public EmployeeBO getEmpById(int id) {
		EmployeeBO bo=null;
		bo=jt.queryForObject(FETCH_EMP_BY_ID, new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class),id);
		return bo;
	}
	public int updateEmployee(EmployeeBO bo) {
		int count=0;
		count=jt.update(UPDATE_EMP_BY_ID, bo.getEname(),bo.getJob(),bo.getSal(),bo.getDeptNo(),bo.getEmpNo());
		return count;
	}
}
