package com.devtech.services;

import exceptions.CouponException;

public interface ClientServiceIF {
	public abstract boolean login(String email,String password) throws CouponException;
}
