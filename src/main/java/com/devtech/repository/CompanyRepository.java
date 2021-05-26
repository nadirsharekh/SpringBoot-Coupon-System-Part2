package com.devtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.devtech.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	Company findCompanyByName(String Name);
	
	Company findCompanyById(int companyID);

	Company findCompanyByEmail(String Email);

	Company findCompanyByEmailAndPassword(String Email, String Password);

	@Transactional
	@Modifying
	@Query("DELETE FROM Company c WHERE c.id = ?1")
	void deleteCompanyById(int companyId);
}
