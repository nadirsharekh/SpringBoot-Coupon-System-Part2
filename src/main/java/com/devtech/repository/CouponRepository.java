package com.devtech.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.devtech.entity.Category;
import com.devtech.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	Coupon findCouponById(int couponId);

	@Query("SELECT c FROM Coupon c where c.companyID = ?1")
	List<Coupon> findCompanyCoupons(int companyID);

	@Query("SELECT c FROM Coupon c where c.category = ?1 AND c.companyID = ?2")
	List<Coupon> findCompanyCouponsByCategory(Category category, int companyID);

	@Query("SELECT c FROM Coupon c where c.price <?1 AND c.companyID = ?2")
	List<Coupon> findCompanyCouponsByPrice(double price, int companyID);

	@Query("SELECT coup FROM Coupon coup WHERE coup.id=?2 AND coup.id IN (SELECT coup.id FROM coup.customers cust WHERE cust.id=?1)")
	Coupon findCustomerCoupon(int customerId, int couponId);

	@Query("SELECT coup FROM Coupon coup WHERE  coup.id IN (SELECT coup.id FROM coup.customers cust WHERE cust.id=?1)")
	List<Coupon> findCustomerCoupons(int customerId);

	@Query("SELECT coup FROM Coupon coup WHERE coup.category=?2 AND coup.id IN (SELECT coup.id FROM coup.customers cust WHERE cust.id=?1)")
	List<Coupon> findCustomerCouponsByCategory(int customerId, Category category);

	@Query("SELECT coup FROM Coupon coup WHERE coup.price < ?2 AND coup.id IN (SELECT coup.id FROM coup.customers cust WHERE cust.id=?1)")
	List<Coupon> findCustomerCouponsByPrice(int customerId, double price);

	@Transactional
	@Modifying
	@Query("DELETE FROM Coupon c WHERE c.id = ?1")
	void deleteCustomerCoupon(int couponId);

	@Modifying
	@Transactional
	@Query("DELETE FROM Coupon c WHERE c.endDate < CURRENT_DATE")
	void deleteExpiredCoupon();
}
