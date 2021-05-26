package com.devtech.LoginManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.devtech.entity.ClientType;
import com.devtech.services.AdminServiceIF;
import com.devtech.services.ClientServiceIF;
import com.devtech.services.CompanyServiceIF;
import com.devtech.services.CustomerServiceIF;
import exceptions.CouponException;

@Component
@Scope("singleton")
public class LoginManager {

	private LoginManager() {}

	@Autowired
	private AdminServiceIF adminServiceif;
	@Autowired
	private CompanyServiceIF CompanyServiceif;
	@Autowired
	private CustomerServiceIF CustomerServiceif;

	public ClientServiceIF login(String email, String password, ClientType clientType) throws CouponException {
		ClientServiceIF clientToReturn = null;
		switch (clientType) {
		case Administrator:
			clientToReturn = adminServiceif;
			break;
		case Company:
			clientToReturn = CompanyServiceif;
			break;
		case Customer:
			clientToReturn = CustomerServiceif;
			break;
		}
		try {
			if (clientToReturn != null) {
				try {
					if (clientToReturn.login(email, password)) {
						System.out.println("Login Successed!");
						return clientToReturn;
					}
				} catch (Exception e) {
					System.err.println("STOP! Login Falied! Invalid User or Password!");
					return null;
				}
			}
		} catch (Exception e) {
			System.err.println("STOP! Login Falied! Invalid User Type!");
			return null;
		}
		return null;
	}
}
