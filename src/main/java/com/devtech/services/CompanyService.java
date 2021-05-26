package com.devtech.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devtech.entity.Category;
import com.devtech.entity.Company;
import com.devtech.entity.Coupon;
import com.devtech.repository.CompanyRepository;
import com.devtech.repository.CouponRepository;
import exceptions.CouponException;

@Service
public class CompanyService implements CompanyServiceIF {

	Company company;

	@Autowired
	private CompanyRepository companyRepo;

	@Autowired
	private CouponRepository couponRepo;

	public CompanyService() {
	}

	@Override
	public boolean login(String Email, String Password) throws CouponException {
		Company isCompanyExist = companyRepo.findCompanyByEmailAndPassword(Email, Password);
		if (isCompanyExist != null) {
			this.company = isCompanyExist;
			return true;
		}
		return false;
	}

	public void createCoupon(Coupon coupon) throws CouponException {
		if (coupon != null) {
			boolean flag = true;
			List<Coupon> couponList = getCompanyCoupons();
			if (couponList != null) {
				for (Coupon couponIndex : couponList) {
					if (couponIndex.getTitle().equals(coupon.getTitle())) {
						flag = false;
						break;
					}
				}
			} else {
				System.err.println("This Company Dosen't Has Any Coupons");
			}
			if (flag) {
				coupon.setCompanyID(this.company.getId());
				couponList.add(coupon);
				couponRepo.saveAndFlush(coupon);
				this.company.setCoupons(getCompanyCoupons());
			} else {
				System.err.println("Can't Add Similar Title Coupon To This Company!");
			}

		} else
			System.err.println("STOP! Coupon Information Null! Add Coupon Failed!");
	}

	public void updateCoupon(Coupon coupon) throws CouponException {
		if (coupon != null) {
			Coupon checkIfExsist = couponRepo.getOne(coupon.getId());
			if (checkIfExsist != null) {
				System.out.println(coupon.getTitle());
				System.out.println(checkIfExsist.getTitle());
				if (checkIfExsist.getTitle().equals(coupon.getTitle())) {
					couponRepo.saveAndFlush(coupon);
					this.company.setCoupons(getCompanyCoupons());
					System.out.println("Coupon Updated");
				} else {
					System.err.println("STOP! You Can't Update The Title! Update Company Failed!");
				}

			} else
				System.err.println("STOP! Coupon Dosen't Exists! Update Company Failed!");
		} else
			System.err.println("STOP! Coupon Information Null! Update Coupon Failed!");
	}

	@Transactional
	public void deleteCoupon(int couponId) throws CouponException {
		Coupon couponExists = couponRepo.findCouponById(couponId);
		if (couponExists!=null) {
			couponRepo.deleteCustomerCoupon(couponId);
			System.out.println("Coupon Deleted");
		} else {
			System.out.println("Coupon Dosen't Exists");
		}
	}

	public List<Coupon> getCompanyCoupons() throws CouponException {
		return couponRepo.findCompanyCoupons(this.company.getId());
	}

	public List<Coupon> getCompanyCoupons(Category category) throws CouponException {
		return couponRepo.findCompanyCouponsByCategory(category, this.company.getId());
	}

	public List<Coupon> getCompanyCoupons(double price) throws CouponException {
		return couponRepo.findCompanyCouponsByPrice(price, this.company.getId());
	}

	public Company getCompanyDetails() throws CouponException {
		return this.company;
	}
}
