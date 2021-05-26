package testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.devtech.LoginManager.LoginManager;

@Component
@Configuration
@Scope("singleton")
public class Tests implements CommandLineRunner{
	
    private LoginManager loginManager;
	
    @Autowired
    private AdminTest adminTest;
    @Autowired
    private CompanyTest companyTest;
    @Autowired
    private CustomerTest customerTest;
    
    

		@Override
	    public void run(String... arg0) throws Exception {
//			adminTest.run(arg0);
			
			System.out.println("hello i am i  test ");
			
	    }
}
	
	









			
			
//			        adminServiceTest.updateCompany();
//			        adminServiceTest.getAllCompanies();
			//
//			        adminServiceTest.addCustomer();
//			        adminServiceTest.updateCustomer();
//			        adminServiceTest.getAllCustomers();
			//
//			        companyServiceTest.addCoupon();
//			        companyServiceTest.getCompanyCoupons();
			//
//			        customerServiceTest.purchaseCoupon();
//			        customerServiceTest.getCustomerCoupons();
//			        customerServiceTest.testGetCustomerCoupons();
//			        customerServiceTest.testGetCustomerCoupons1();
//			        customerServiceTest.getCustomerDetails();
			//
			//
//			        companyServiceTest.updateCoupon();
//			        companyServiceTest.testGetCompanyCoupons();
//			        companyServiceTest.testGetCompanyCoupons1();
//			        companyServiceTest.getCompanyDetails();
			//
////			        deleting all data
//			        companyServiceTest.deleteCoupon();
//			        adminServiceTest.deleteCompany();
//			        adminServiceTest.deleteCustomer();
			    


			//
////				@Autowired
////				public LoginManager lm;
			//
//				@Autowired
//				private AdminTest adminTest;
			//
//				@Autowired
//				private CompanyTest companyTest;
			//
//				@Autowired
//				private CustomerTest customerTest;
			//
//				@Autowired
//				private AdminController ac;
			//	
//				public void run() throws Exception {
			//
////					CouponExpirationDailyJob DailyTask = new CouponExpirationDailyJob();
////					Thread thread = new Thread(DailyTask);
////					thread.start();
			//
//					java.util.Date date = new java.util.Date("01/01/2020");
//					java.sql.Date startDate = new Date(date.getTime());
			//
//					java.util.Date date1 = new java.util.Date("2021/01/01");
//					java.sql.Date endDate1 = new Date(date1.getTime());
			//
//					java.util.Date date2 = new java.util.Date("2021/01/28");
//					java.sql.Date endDate2 = new Date(date2.getTime());
			//
//					java.util.Date date3 = new java.util.Date("2021/01/30");
//					java.sql.Date endDate3 = new Date(date3.getTime());
			//
//					java.util.Date date4 = new java.util.Date("2021/05/05");
//					java.sql.Date endDate4 = new Date(date4.getTime());
			//
//					java.util.Date date5 = new java.util.Date("2021/03/03");
//					java.sql.Date endDate5 = new Date(date5.getTime());
			//
//					Company company1 = new Company("Amdocs", "amdocs@com.co.il", "111");
//					Company company2 = new Company("Roy", "Roy@com.co.il", "222");
//					Company company3 = new Company("Docs", "Docs@com.co.il", "333");
//					Company company4 = new Company("Sclass", "Sclass@com.co.il", "444");
//					Company company5 = new Company("Soya", "Soya@com.co.il", "555");
			//
//					Customer customer1 = new Customer("Natheer", "Sharek", "Natheer@com.co.il", "111");
//					Customer customer2 = new Customer("Salim", "Masri", "Salim@com.co.il", "222");
//					Customer customer3 = new Customer("Zienb", "Garbou", "Zienb@com.co.il", "333");
//					Customer customer4 = new Customer("Dawod", "Kabha", "Dawod@com.co.il", "444");
//					Customer customer5 = new Customer("Mahmod", "Nono", "Mahmod@com.co.il", "555");
			//
//					System.out.println("Enter Type Client: Administrator Or Company Or Customer");
//					// Login By Administrator Client
//					AdminServiceIF CF = (AdminServiceIF) ac.login("admin@admin.com", "admin");
			//
//					// Login By Company Client
//					// ClientServiceIF CF = lm.login("Natheer@com.co.il", "111",
//					// ClientType.Customer);
			//
//					// Login By Customer Client
//					// ClientFacade CF=lm.login("Natheer@com.co.il","111", ClientType.Customer);
//					boolean flagStopSystem = true;
			//
//					while (flagStopSystem) {
//						if (CF instanceof AdminServiceIF) {
//							System.out.println("Welcome Admin Facade");
//							System.out.println("____________________");
			//
//							AdminServiceIF adminF = (AdminServiceIF) CF;
			//
//							System.out.println("Start Function addCompany(Company company) Add Companies");
			//
//							adminF.createCompany(company1);
//							adminF.createCompany(company2);
//							adminF.createCompany(company3);
//							adminF.createCompany(company4);
//							adminF.createCompany(company5);
			//
//						}
			//
//					}
//				}

