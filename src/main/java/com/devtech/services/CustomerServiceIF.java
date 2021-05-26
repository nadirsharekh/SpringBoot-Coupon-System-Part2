package com.devtech.services;

import java.util.List;
import com.devtech.entity.Category;
import com.devtech.entity.Coupon;
import com.devtech.entity.Customer;
import exceptions.CouponException;

public interface CustomerServiceIF extends ClientServiceIF {

	boolean login(String Email, String Password) throws CouponException;

	public void purchaseCoupon(Coupon coupon) throws CouponException;

	public List<Coupon> getCustomerCoupons() throws CouponException;

	public List<Coupon> getCustomerCoupons(Category category) throws CouponException;

	public List<Coupon> getCustomerCoupons(double price) throws CouponException;

	public Customer getCustomerDetails() throws CouponException;
}
