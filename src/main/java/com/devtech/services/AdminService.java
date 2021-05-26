package com.devtech.services;

import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devtech.entity.Company;
import com.devtech.entity.Coupon;
import com.devtech.entity.Customer;
import com.devtech.repository.CompanyRepository;
import com.devtech.repository.CouponRepository;
import com.devtech.repository.CustomerRepository;
import exceptions.CouponException;

@Service
public class AdminService implements AdminServiceIF {
	private final String email = "admin@admin.com";
	private final String password = "admin";

	@Autowired
	private CompanyRepository companyRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private CouponRepository couponRepo;

	public AdminService() {
	}

	public boolean login(String user, String password) {
		return (user.equals(this.email) && password.equals(this.password));
	}

	@Override
	public void createCompany(Company company) throws CouponException {
		if (company != null) {
			if (companyRepo.findCompanyByName(company.getName())==null) {
				if (companyRepo.findCompanyByEmail(company.getEmail())==null) {
					companyRepo.save(company);
					System.out.println("Company Added");
				} else {
					System.err.println("Company Email: " + company.getEmail() + " Already Exists.");
				}
			} else {
				System.err.println("Company name: " + company.getName() + " Already Exists.");
			}
		} else
			System.err.println("STOP! Company Information Null! Add Company Failed!");
	}

	@Override
	public void updateCompany(Company company) {
		if (company != null) {
			Company companyToUpdate = companyRepo.findCompanyById(company.getId());
			if (companyToUpdate != null) {
				if (companyToUpdate.getName().equals(company.getName())) {
					if (companyRepo.findCompanyByEmail(company.getEmail())==null) {
						companyRepo.saveAndFlush(company);
						System.out.println("Company Updated");
					} else {
						System.err.println("Company Email: " + company.getEmail() + " Already Exists.");
					}
				} else {
					System.err.print("You Can Not Update The Company Name! ");
				}
			} else {
				System.err.print("This Company Dosn't Exist!!");
			}
		} else {
			System.err.println("STOP! Company Information Null! Add Company Failed!");
		}
	}

	@Transactional
	public void deleteCompany(int companyID) throws CouponException {
		Company company = companyRepo.findCompanyById(companyID);
		if (company != null) {
			for (Coupon coupon : company.getCoupons()) {
				couponRepo.deleteCustomerCoupon(coupon.getId());
			}
		
			companyRepo.deleteCompanyById(companyID);
			System.out.println("Company Deleted");
		} else {
			System.out.println("Company " + companyID + " Dosen't Exists");
		}
	}

	@Override
	public ArrayList<Company> getAllCompanies() throws CouponException {
		ArrayList<Company> companies = new ArrayList<Company>(companyRepo.findAll());
		return companies;
	}

	@Override
	public Company getOneCompany(int companyId) throws CouponException {
		return companyRepo.findCompanyById(companyId);
	}

	@Override
	public void createCustomer(Customer customer) throws CouponException {
		if (customerRepo.findCustomerByEmailAndPassword(customer.getEmail(), customer.getPassword()) == null) {
			customerRepo.saveAndFlush(customer);
			System.out.println("Customer Added");
		} else
			System.err.println("Customer Exists, Can't Add");
	}

	@Override
	public void updateCustomer(Customer customer) throws CouponException {
		if (customer != null) {
			Customer customerToUpdate = customerRepo.findCustomerById(customer.getId());
			if (customerToUpdate != null) {
				customerRepo.saveAndFlush(customer);
				System.out.println("Customer Updated");
			} else {
				System.out.println("Customer " + customer.getId() + " Dosen't Exists");
			}
		} else
			System.err.print("STOP! Customer Information Null! Update Customer Failed!");
	}

	@Transactional
	public void deleteCustomer(int customerId) throws CouponException {
		Customer customer = customerRepo.findCustomerById(customerId);
		if (customer != null) {
			for (Coupon coupon : customer.getCoupons()) {
				couponRepo.deleteCustomerCoupon(coupon.getId());
			}
			customerRepo.deleteById(customerId);
			System.out.println("Customer Deleted");
		} else {
			System.out.println("Customer " + customerId + " Dosen't Exists");
		}
	}

	public ArrayList<Customer> getAllCustomers() throws CouponException {
		ArrayList<Customer> customeres = new ArrayList<Customer>(customerRepo.findAll());
		return customeres;
	}

	public Customer getOneCustomer(int customerId) throws CouponException {
		return customerRepo.findCustomerById(customerId);
	}
}
