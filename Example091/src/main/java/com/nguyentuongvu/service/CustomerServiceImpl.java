package com.nguyentuongvu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.nguyentuongvu.dao.CustomerDAO;
import com.nguyentuongvu.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;

	}

	@Transactional
	public void addCustomer(Customer p) {
		this.customerDAO.addCustomer(p);
	}

	@Transactional
	public void updateCustomer(Customer p) {
		this.customerDAO.updateCustomer(p);
	}

	@Transactional
	public List<Customer> listCustomers() {
		return this.customerDAO.listCustomers();
	}

	@Transactional
	public Customer getCustomerById(int id) {
		return this.customerDAO.getCustomerById(id);
	}

	@Transactional
	public void removeCustomer(int id) {
		this.customerDAO.removeCustomer(id);
	}


}
