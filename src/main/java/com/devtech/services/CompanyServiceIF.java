package com.devtech.services;

import java.util.List;
import com.devtech.entity.Category;
import com.devtech.entity.Company;
import com.devtech.entity.Coupon;
import exceptions.CouponException;

public interface CompanyServiceIF extends ClientServiceIF {

	boolean login(String Email, String Password) throws CouponException;

	public void createCoupon(Coupon coupon) throws CouponException;

	public void updateCoupon(Coupon coupon) throws CouponException;

	public void deleteCoupon(int couponId) throws CouponException;

	public List<Coupon> getCompanyCoupons() throws CouponException;

	public List<Coupon> getCompanyCoupons(Category category) throws CouponException;

	public List<Coupon> getCompanyCoupons(double price) throws CouponException;

	public Company getCompanyDetails() throws CouponException;
}
