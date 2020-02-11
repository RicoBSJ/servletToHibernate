package com.itoolsinfo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Dao {
	public boolean saveDetails(int employeeId, String employeeName, int salary) {

		boolean flag = true;

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setSalary(salary);
		Transaction transaction = session.beginTransaction();
		try {
			session.save(employee);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			flag = false;

		}
		session.close();
		return flag;
	}
}
