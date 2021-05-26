package com.devtech.services;

import java.util.ArrayList;
import java.util.List;
import com.devtech.entity.Company;
import com.devtech.entity.Customer;
import exceptions.CouponException;

public interface AdminServiceIF extends ClientServiceIF {

	public boolean login(String user, String password);

	public void createCompany(Company company) throws CouponException;

	public void updateCompany(Company company) throws CouponException;

	public void deleteCompany(int companyID) throws CouponException;

	public List<Company> getAllCompanies() throws CouponException;

	public Company getOneCompany(int companyId) throws CouponException;

	void createCustomer(Customer customer) throws CouponException;

	void updateCustomer(Customer customer) throws CouponException;

	public void deleteCustomer(int customerId) throws CouponException;

	public ArrayList<Customer> getAllCustomers() throws CouponException;

	public Customer getOneCustomer(int customerId) throws CouponException;
}
