package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.StringJoiner;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.bean.Dept;
import com.bean.Emp;
import com.urils.GetUri;

public class EmpDao {
	
	//显示所有的员工
	
	public List<Emp> listEmp(String LikeNname,String LikeDid) throws Exception{
		
		Connection conn = GetUri.getconn();
		QueryRunner run = new QueryRunner();
		String sql = " select e.*,d.dname from emp e,dept d where e.deptid = d.did and 0=0 ";
		if(LikeNname!=null){
			sql = sql +" and e.ename like  '%"+LikeNname+"%' ";
		}
		if(LikeDid!=null){
			sql = sql + " and e.deptid = "+LikeDid+" ";
		}
		List<Emp> list = run.query(conn, sql, new BeanListHandler<>(Emp.class));
		return list;
	}
	
	
	
	
	
	public void saveEmp(String ename,String bdate,String sex,String deptid){
		try {
			
			QueryRunner run = new QueryRunner();
			Connection conn = GetUri.getconn();
			String sql = " insert into emp values(0,?,?,?,?) ";
			run.insert(conn, sql, new BeanListHandler<>(Emp.class),ename,bdate,sex,deptid);			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
	
	public List<Dept> listDept(){
		
		List<Dept> list = null;
		try {
			QueryRunner run = new QueryRunner();
			Connection conn = GetUri.getconn();
			String sql = " select * from dept ";
			list = run.query(conn,sql, new BeanListHandler<>(Dept.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	public void deleteEmp(String eid){
		try {
			QueryRunner run = new QueryRunner();
			Connection conn = GetUri.getconn();
			String sql = " delete from emp where eid = ? ";
			run.insert(conn,sql, new BeanListHandler<>(String.class),eid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void test1() throws Exception{
//		List<Emp> list = listEmp();
//		for (Emp emp : list) {
//			System.out.println(emp.getEname());
//		}
	}
	
	
}
