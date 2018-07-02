package com.assetmanagementsystem.model.dao;

import com.assetmanagementsystem.model.entity.EmployeeEntity;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
public class EmployeeDao {
	
	public int addEmployee(EmployeeEntity e) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		int i=-1;
		i = (int)session.save(e);
		if(i >- 1) {	
			session.getTransaction().commit();
			return i;
		}
		return i;
	}
	
	public EmployeeEntity displayEmployeeByEno(int eno) {
		Session session = DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		EmployeeEntity e=(EmployeeEntity)session.get(EmployeeEntity.class, eno);
		return e;
	}
	
	public EmployeeEntity displayEmployeeByUsername(String username) {
		Session session = DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "from EmployeeEntity where employeeUsername = :username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		EmployeeEntity e = (EmployeeEntity) query.uniqueResult();
		return e;
	}
	
	public boolean updateEmployee(EmployeeEntity e) {
		Session session= DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		EmployeeEntity e2=(EmployeeEntity)session.get(EmployeeEntity.class, e.getEmployeeId());
		e2.setEmployeeName(e.getEmployeeName());
		e2.setManagerId(e.getManagerId());
		e2.setProjectId(e.getProjectId());
		e2.setEmployeeDepartment(e.getEmployeeDepartment());
		e2.setEmployeeSalary(e.getEmployeeSalary());
		e2.setEmployeePhoneNumber(e.getEmployeePhoneNumber());
		e2.setEmployeePostingCity(e.getEmployeePostingCity());
		e2.setAddress(e.getAddress());
		if(session.save(e2)!=null) {	
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	 
	
	public boolean checkLogin(String username, String password, String department) {
		Session session = DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql="from EmployeeEntity where employeeUsername = :uname and employeePassword = :pwd and employeeDepartment = :dept";
		Query query=session.createQuery(hql);
		query.setParameter("uname", username);
		query.setParameter("pwd", password);
		query.setParameter("dept", department);
		EmployeeEntity e=(EmployeeEntity) query.uniqueResult();
		if(e!=null) {
			return true;
		}
		return false;
	}
	
	public boolean deleteEmployee(int eno) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="delete from employee_table where employee_id = :eno";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter("eno",eno);
		if(query.executeUpdate()>0) {	
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public boolean changePassword(int eno, String password) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="update employee_table set password= :password where employee_id= :eno";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter("password", password);
		query.setParameter("eno", eno);
		if(query.executeUpdate()>0) {
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public boolean changePhoneNumber(int eno, long phoneNo) {
		Session session=DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql="update employee_table set phone_number= :phoneNo where employee_id= :eno";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter("phoneNo", phoneNo);
		query.setParameter("eno", eno);
		if(query.executeUpdate()>0) {
			session.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public List<EmployeeEntity> listEmployeeByManager(int mId) {
		Session session = DaoUtility.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "from EmployeeEntity where managerId = :mId";
		Query query = session.createQuery(hql);
		query.setParameter("mId", mId);
		List<EmployeeEntity> employeeList = (List<EmployeeEntity>) query.list();
		return employeeList;
	}
}
