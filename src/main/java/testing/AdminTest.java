package testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.devtech.LoginManager.LoginManager;
import com.devtech.entity.ClientType;
import com.devtech.entity.Company;
import com.devtech.entity.Customer;
import com.devtech.services.AdminService;
import com.devtech.services.AdminServiceIF;
import com.devtech.services.CompanyService;
import com.devtech.services.CustomerService;

import exceptions.CouponException;

@Component
@Scope("singleton")
public class AdminTest {
	
	
	LoginManager loginManager;

	AdminServiceIF adminServiceIF;

	private Customer[] customers;
	private Company[] companies;

	@Autowired
	public AdminTest(LoginManager loginManager) throws CouponException {
		this.loginManager = loginManager;
		adminServiceIF = (AdminServiceIF) loginManager.login("admin@admin.com", "admin", ClientType.Administrator);
		fillCustomerAndCompany();
	}

	public void fillCustomerAndCompany () {
		customers = new Customer[] { new Customer("salim", "masri", "solico93@gmail.com", "customer1"),
				new Customer("maor", "kalman", "kalman@gmail.com", "customer2"),
				new Customer("mohamed", "soso", "soso@gmail.com", "customer3") };

		companies = new Company[] { new Company("pizzaDomino", "company1@gmail.com", "company1"),
				new Company("burgerBoom", "company2@gmail.com", "company2"),
				new Company("crsipyChicken", "company3@gmail.com", "company3") };
	}

}


////
////		public void updateCompany() {
////			for (Company company : companies) {
////				CompanyService companyService = (CompanyService) loginManager.login(company.getEmail(),
////						company.getPassword(), ClientType.Company);
////				if (companyService != null) {
////					Integer companyInDBId = companyService.getCompanyId();
////					if (companyInDBId != null) {
////						company.setId(companyInDBId);
////						company.setName(company.getName().toLowerCase(Locale.ROOT));
////						try {
////							adminService.updateCompany(company);
////						} catch (Exception e) {
////							e.getMessage();
////						}
////					}
////				}
////			}
////
////		}
////
////		public void deleteCompany() {
////			for (Company company : companies) {
////				CompanyService companyService = (CompanyService) loginManager.login(company.getEmail(),
////						company.getPassword(), ClientType.Customer);
////				if (companyService != null) {
////					Integer companyInDBId = companyService.getCompanyId();
////					if (companyInDBId != null) {
////						try {
////							adminService.deleteCompany(companyInDBId);
////						} catch (Exception e) {
////							e.getMessage();
////						}
////					}
////				}
////			}
////
////		}
////
////		public void getAllCompanies() throws CouponException {
////			adminService.getAllCompanies();
////		}
////
////		public void getOneCompany() {
////			for (Company company : companies) {
////				CompanyService companyService = (CompanyService) loginManager.login(company.getEmail(),
////						company.getPassword(), ClientType.Company);
////				if (companyService != null) {
////					Integer companyInDBId = companyService.getCompanyId();
////					if (companyInDBId != null) {
////						Company companyFromDB = adminService.getOneCompany(companyInDBId);
////						if (companyFromDB != null) {
////							logger.log(companyFromDB.toString());
////						}
////					}
////				}
////			}
////		}
////
////		public void addCustomer() {
////			for (Customer customer : customers) {
////				try {
////					adminService.createCustomer(customer);
////				} catch (Exception e) {
////					e.getMessage();
////				}
////			}
////
////		}
////
////		public void updateCustomer() {
////			for (Customer customer : customers) {
////				CustomerService customerService = (CustomerService) loginManager.login(customer.getEmail(),
////						customer.getPassword(), ClientType.Customer);
////				if (customerService != null) {
////					Integer customerInDBId = customerService.getCustomerId();
////					if (customerInDBId != null) {
////						customer.setId(customerService.getCustomerId());
////						customer.setFirstName(customer.getFirstName().toLowerCase(Locale.ROOT));
////						try {
////							adminService.updateCustomer(customer);
////						} catch (Exception e) {
////							e.getMessage();
////						}
////					}
////				}
////			}
////
////		}
////
////		public void deleteCustomer() {
////			for (Customer customer : customers) {
////				CustomerService customerService = (CustomerService) loginManager.login(customer.getEmail(),
////						customer.getPassword(), ClientType.Customer);
////				if (customerService != null) {
////					Integer customerInDBId = customerService.getCustomerId();
////					if (customerInDBId != null) {
////						try {
////							adminService.deleteCustomer(customerInDBId);
////						} catch (Exception e) {
////							e.getMessage();
////						}
////					}
////				}
////			}
////		}
////
////		public void getAllCustomers() throws CouponException {
////			adminService.getAllCustomers();
////		}
////
////		public void getOneCustomer() {
////			for (Customer customer : customers) {
////				CustomerService customerService = (CustomerService) loginManager.login(customer.getEmail(),
////						customer.getPassword(), ClientType.Customer);
////				if (customerService != null) {
////					Integer customerInDBId = customerService.getCustomerId();
////					if (customerInDBId != null) {
////						Customer customerInDB = adminService.getOneCustomer(customerInDBId);
////						if (customerInDB != null) {
////							customerInDB.toString();
////						}
////					}
////				}
////			}
////		}
////
////		public void getCompanyByName() {
////			for (Company company : companies) {
////				Company companyInDB = adminService.getCompanyByName(company.getName());
////				if (companyInDB != null) {
////					logger.log(companyInDB.toString());
////				}
////			}
////		}
////	}
////	@Autowired
////	private LoginManager loginManager;
////	private AdminServiceIF adminServiceIf;
////
////	private Company[] ourCompanies;
////	private Customer[] ourCustomers;
////
////	@Autowired
////	public AdminTest(LoginManager loginManager) throws CouponException {
////		this.loginManager = loginManager;
////		adminServiceIf = (AdminServiceIF) loginManager.login("admin@admin.com", "admin", ClientType.Administrator);
////		fillData();
////	}
////
////	public void fillData() {
////		ourCompanies = new Company[] { new Company("Amdocs", "amdocs@com.co.il", "111"),
////				new Company("Roy", "Roy@com.co.il", "222"), new Company("Docs", "Docs@com.co.il", "333"),
////				new Company("Sclass", "Sclass@com.co.il", "444"), new Company("Soya", "Soya@com.co.il", "555"),
////
////		};
////		ourCustomers = new Customer[] { new Customer("Natheer", "Sharek", "Natheer@com.co.il", "111"),
////				new Customer("Salim", "Masri", "Salim@com.co.il", "222"),
////				new Customer("Zienb", "Garbou", "Zienb@com.co.il", "333"),
////				new Customer("Dawod", "Kabha", "Dawod@com.co.il", "444"),
////				new Customer("Mahmod", "Nono", "Mahmod@com.co.il", "555") };
////	}
////	
////	public void printMe() 
////	{System.out.println("here i am ");}
////
////	public void addCompany() {
////		//fillData();
////		for (Company company : ourCompanies) {
////			try {
////				adminServiceIf.createCompany(company);
////			} catch (Exception e) {
////				System.err.println(e.getMessage());
////			}
////		}
////	}z