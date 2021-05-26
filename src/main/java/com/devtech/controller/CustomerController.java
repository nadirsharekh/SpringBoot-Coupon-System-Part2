package com.devtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.devtech.LoginManager.LoginManager;
import com.devtech.entity.Category;
import com.devtech.entity.ClientType;
import com.devtech.entity.Coupon;
import com.devtech.services.CustomerServiceIF;
import exceptions.CouponException;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	CustomerServiceIF CustomerServiceif;

	@Autowired
	private LoginManager loginManager;

	@GetMapping(value = "/{email}/{password}", consumes = "application/json")
	public ResponseEntity<Boolean> login(@PathVariable("email") String email, @PathVariable("password") String password)
			throws CouponException {
		CustomerServiceif = (CustomerServiceIF) loginManager.login(email, password, ClientType.Customer);
		boolean flag = CustomerServiceif != null;
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}

	@RequestMapping(value = "/purchaseCoupon", consumes = "application/json", method = RequestMethod.POST)
	public ResponseEntity<?> purchaseCoupon(@RequestBody Coupon coupon) throws CouponException {
		if (CustomerServiceif != null) {
			try {
				CustomerServiceif.purchaseCoupon(coupon);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>("Sorry Can't Add", HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getCustomerCoupons", consumes = "application/json")
	public ResponseEntity<?> getCustomerCoupons() throws CouponException {
		if (CustomerServiceif != null) {
			try {
				return new ResponseEntity<>(CustomerServiceif.getCustomerCoupons(), HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getCustomerCouponsByCategory/{category}", consumes = "application/json")
	public ResponseEntity<?> getCustomerCoupons(@PathVariable("category") Category category) throws CouponException {
		if (CustomerServiceif != null) {
			try {
				return new ResponseEntity<>(CustomerServiceif.getCustomerCoupons(category), HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getCustomerCouponsByPrice/{price}", consumes = "application/json")
	public ResponseEntity<?> getCustomerCoupons(@PathVariable("price") double price) throws CouponException {
		if (CustomerServiceif != null) {
			try {
				return new ResponseEntity<>(CustomerServiceif.getCustomerCoupons(price), HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getCustomerDetails", consumes = "application/json")
	public ResponseEntity<?> getCustomerDetails() throws CouponException {
		if (CustomerServiceif != null) {
			try {
				return new ResponseEntity<>(CustomerServiceif.getCustomerDetails(), HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}
}
