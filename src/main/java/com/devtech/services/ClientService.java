package com.devtech.services;

import org.springframework.stereotype.Service;

import com.devtech.repository.CompanyRepository;
import com.devtech.repository.CouponRepository;
import com.devtech.repository.CustomerRepository;

import exceptions.CouponException;

@Service
public abstract class ClientService implements ClientServiceIF{
	protected CompanyRepository companyRepo;
	protected CouponRepository couponRepo;
	protected CustomerRepository customerRepo;
	
	public abstract boolean login(String email,String password) throws CouponException;

}
