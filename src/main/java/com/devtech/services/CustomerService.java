package com.devtech.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devtech.entity.Category;
import com.devtech.entity.Coupon;
import com.devtech.entity.Customer;
import com.devtech.repository.CouponRepository;
import com.devtech.repository.CustomerRepository;
import exceptions.CouponException;

@Service
public class CustomerService implements CustomerServiceIF {

	Customer customer;

	public CustomerService() {
	}

	@Autowired
	private CouponRepository couponRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public boolean login(String Email, String Password) throws CouponException {
		Customer isCustomerExist = customerRepo.findCustomerByEmailAndPassword(Email, Password);
		if (isCustomerExist != null) {
			this.customer = isCustomerExist;
			return true;
		}
		return false;
	}

	public void purchaseCoupon(Coupon coupon) throws CouponException {
		if (coupon != null) {
			Coupon isCouponExsist = couponRepo.findCouponById(coupon.getId());
			if (isCouponExsist!=null) {
				Date currentDate = new Date();
				Date endDate = coupon.getEndDate();
				int ifExpired = endDate.compareTo(currentDate);// should>0
				if (coupon.getAmount() > 0) {
					if (ifExpired > 0) {
						// check if the customer purchase this coupon before that
						Coupon couponToCustomer = couponRepo.findCustomerCoupon(this.customer.getId(), coupon.getId());
						if (couponToCustomer == null) {
							coupon.setAmount(coupon.getAmount() - 1);
							// After Purchase Update Amount -1
							couponRepo.saveAndFlush(coupon);
							customer.purchaseCoupon(coupon);
							// we have to save the customer again??
							customerRepo.saveAndFlush(this.customer);
						} else
							System.err.println("This Coupon Bought By The Customer, Sorry Can't Add Again");
					} else
						System.err.println("Can't Add The Expired Coupon.");
				} else {
					System.err.println("Sorry, Amount Of This Coupon Finished.");
				}
			} else {
				System.err.println("STOP! Coupon Dosen't Exists!");
			}
		} else
			System.err.println("STOP! Coupon Information Null! Purchase Coupon Failed!");
	}

	public List<Coupon> getCustomerCoupons() throws CouponException {
		return couponRepo.findCustomerCoupons(this.customer.getId());
	}

	public List<Coupon> getCustomerCoupons(Category category) throws CouponException {
		return couponRepo.findCustomerCouponsByCategory(this.customer.getId(), category);
	}

	public List<Coupon> getCustomerCoupons(double price) throws CouponException {
		return couponRepo.findCustomerCouponsByPrice(this.customer.getId(), price);
	}

	public Customer getCustomerDetails() throws CouponException {
		return this.customer;
	}
}
