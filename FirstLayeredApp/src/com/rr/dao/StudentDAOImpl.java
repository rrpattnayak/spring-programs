package com.rr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.rr.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private static final String STUDENT_INSERT_QUERY="INSERT INTO SP_STUDENT VALUES(?,?,?,?,?)";
	private DataSource ds;
	
	public StudentDAOImpl(DataSource ds) {
		this.ds = ds;
	}


	@Override
	public int insert(StudentBO bo) {
		//write jdbc code insert record
		try {
			//get jdbc con
			Connection con=ds.getConnection();
			//create preparedstatement obj
			PreparedStatement ps=con.prepareStatement(STUDENT_INSERT_QUERY);
			//set query param vlaues
			ps.setInt(1, bo.getSno());
			ps.setString(2, bo.getSname());
			ps.setInt(3, bo.getTotal());
			ps.setFloat(4, bo.getAvg());
			ps.setString(5, bo.getResult());
			//execute the query
			int result=ps.executeUpdate();
			return result;
		}
		catch(SQLException se) {
			return 0;
		}
		catch(Exception e) {
			return 0;
		}
	}//method
}//class
