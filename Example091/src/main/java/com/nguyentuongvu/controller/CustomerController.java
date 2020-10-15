package com.nguyentuongvu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nguyentuongvu.model.Customer;

import com.nguyentuongvu.service.CustomerService;

@Controller
public class CustomerController {
	private CustomerService customerService;

	@Autowired(required = true)
	@Qualifier(value = "customerService")
	public void setCustomerService(CustomerService ps) {
		this.customerService = ps;
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String listPhones(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("listCustomers", this.customerService.listCustomers());
		return "customer";
	}

// For add and update phone both
	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer") Customer p) {
		if (p.getId() == 0) {
//new phone, add it 
			this.customerService.addCustomer(p);
		} else {
//existing phone, call update
			this.customerService.updateCustomer(p);
		}

		return "redirect:/customers";

	}
	@RequestMapping("/remove/{id}")
	public String removeCustomer(@PathVariable("id") int id) {
		this.customerService.removeCustomer(id);
		return "redirect:/customers";
	}

	@RequestMapping("/edit/{id}")
	public String editCustomer(@PathVariable("id") int id, Model model) {
		model.addAttribute("customer", this.customerService.getCustomerById(id));
		model.addAttribute("listCustomers", this.customerService.listCustomers());
		return "customer";
	}
}