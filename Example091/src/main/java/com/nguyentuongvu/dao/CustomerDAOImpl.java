package com.nguyentuongvu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.nguyentuongvu.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addCustomer(Customer p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Customer saved successfully, Customer Details=" + p);
	}

	public void updateCustomer(Customer p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Customer updated successfully, Customer Details=" + p);
	}

	@SuppressWarnings("unchecked")

	public List<Customer> listCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customersList = session.createQuery("from Customer ").list();
		for (Customer p : customersList) {
			logger.info("Customer List::" + p);
		}
		return customersList;
	}

	public Customer getCustomerById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer p = (Customer) session.load(Customer.class, new Integer(id));
		logger.info("Customer loaded successfully, Customer details=" + p);
		return p;
	}

	public void removeCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer p = (Customer) session.load(Customer.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Customer deleted successfully, Customer details=" + p);
	}




}