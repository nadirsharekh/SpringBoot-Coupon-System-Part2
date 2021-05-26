package com.devtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.devtech.LoginManager.LoginManager;
import com.devtech.entity.ClientType;
import com.devtech.entity.Company;
import com.devtech.entity.Customer;
import com.devtech.services.AdminServiceIF;
import exceptions.CouponException;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	AdminServiceIF adminServiceIf;

	@Autowired
	private LoginManager loginManager;

	@GetMapping(value = "/{email}/{password}", consumes = "application/json")
	public ResponseEntity<Boolean> login(@PathVariable("email") String email, @PathVariable("password") String password)
			throws CouponException {
		adminServiceIf = (AdminServiceIF) loginManager.login(email, password, ClientType.Administrator);
		boolean flag=adminServiceIf!=null;
		return new ResponseEntity<>(flag,HttpStatus.OK);
	}

	@RequestMapping(value = "/addCompany", consumes = "application/json", method = RequestMethod.POST)
	public ResponseEntity<?> createCompany(@RequestBody Company company) {
		if (adminServiceIf != null) {
			try {
				adminServiceIf.createCompany(company);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/updateCompany", consumes = "application/json")
	public ResponseEntity<?> updateCompany(@RequestBody Company company) throws CouponException {
		if (adminServiceIf != null) {
			try {
				adminServiceIf.updateCompany(company);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value = "/deleteCompany/{companyId}", consumes = "application/json")
	public ResponseEntity<?> deleteCompany(@PathVariable("companyId") int companyId) throws CouponException {
		if (adminServiceIf != null) {
			try {
				adminServiceIf.deleteCompany(companyId);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/getOneCompany/{companyId}", consumes = "application/json")
	public ResponseEntity<?> getOneCompany(@PathVariable("companyId") int companyId) throws CouponException {
		if (adminServiceIf != null) {
			try {
				return new ResponseEntity<>(adminServiceIf.getOneCompany(companyId), HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getAllCompanies", consumes = "application/json")
	public ResponseEntity<?> getAllCompanies() throws CouponException {
		if (adminServiceIf != null) {
			try {
				return new ResponseEntity<>(adminServiceIf.getAllCompanies(), HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/addCustomer", consumes = "application/json", method = RequestMethod.POST)
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) throws CouponException {
		if (adminServiceIf != null) {
			try {
				adminServiceIf.createCustomer(customer);
				return new ResponseEntity<>(HttpStatus.CREATED);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/updateCustomer", consumes = "application/json")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) throws CouponException {
		if (adminServiceIf != null) {
			try {
				adminServiceIf.updateCustomer(customer);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value = "/deleteCustomer/{customerId}", consumes = "application/json")
	public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") int customerId) throws CouponException {
		if (adminServiceIf != null) {
			try {
				adminServiceIf.deleteCustomer(customerId);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getAllCustomers", consumes = "application/json")
	public ResponseEntity<?> getAllCustomers() throws CouponException {
		if (adminServiceIf != null) {
			try {
				return new ResponseEntity<>(adminServiceIf.getAllCustomers(), HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getOneCustomer/{customerId}", consumes = "application/json")
	public ResponseEntity<?> getOneCustomer(@PathVariable("customerId") int customerId) throws CouponException {
		if (adminServiceIf != null) {
			try {
				return new ResponseEntity<>(adminServiceIf.getOneCustomer(customerId), HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}
}
