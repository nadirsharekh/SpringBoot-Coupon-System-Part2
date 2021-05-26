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
import com.devtech.entity.Category;
import com.devtech.entity.ClientType;
import com.devtech.entity.Coupon;
import com.devtech.services.CompanyServiceIF;
import exceptions.CouponException;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

	CompanyServiceIF companyServiceIf;

	@Autowired
	private LoginManager loginManager;

	@GetMapping(value = "/{email}/{password}", consumes = "application/json")
	public ResponseEntity<Boolean> login(@PathVariable("email") String email, @PathVariable("password") String password)
			throws CouponException {
		companyServiceIf = (CompanyServiceIF) loginManager.login(email, password, ClientType.Company);
		boolean flag = companyServiceIf != null;
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}

	@RequestMapping(value = "/addCoupon", consumes = "application/json", method = RequestMethod.POST)
	public ResponseEntity<?> addCoupon(@RequestBody Coupon coupon) {
		if (companyServiceIf != null) {
			try {
				companyServiceIf.createCoupon(coupon);
				return new ResponseEntity<>(HttpStatus.CREATED);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/updateCoupon", consumes = "application/json")
	public ResponseEntity<?> updateCompany(@RequestBody Coupon coupon) throws CouponException {
		if (companyServiceIf != null) {
			try {
				companyServiceIf.updateCoupon(coupon);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping(value = "/deleteCoupon/{couponId}", consumes = "application/json")
	public ResponseEntity<?> deleteCoupon(@PathVariable("couponId") int couponId) {
		if (companyServiceIf != null) {
			try {
				companyServiceIf.deleteCoupon(couponId);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getCompanyCoupons", consumes = "application/json")
	public ResponseEntity<?> getCompanyCoupons() throws CouponException {
		if (companyServiceIf != null) {
			try {
				return new ResponseEntity<>(companyServiceIf.getCompanyCoupons(), HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getAllCouponsByCategory/{category}", consumes = "application/json")
	public ResponseEntity<?> getCompanyCoupons(@PathVariable("category") Category category) throws CouponException {
		if (companyServiceIf != null) {
			try {
				return new ResponseEntity<>(companyServiceIf.getCompanyCoupons(category), HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getAllCouponsByPrice/{price}", consumes = "application/json")
	public ResponseEntity<?> getCompanyCoupons(@PathVariable("price") double price) throws CouponException {
		if (companyServiceIf != null) {
			try {
				return new ResponseEntity<>(companyServiceIf.getCompanyCoupons(price), HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getCompanyDetails", consumes = "application/json")
	public ResponseEntity<?> getCompanyDetails() throws CouponException {
		if (companyServiceIf != null) {
			try {
				return new ResponseEntity<>(companyServiceIf.getCompanyDetails(), HttpStatus.OK);
			} catch (CouponException e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Error Login", HttpStatus.BAD_REQUEST);
		}
	}
}
