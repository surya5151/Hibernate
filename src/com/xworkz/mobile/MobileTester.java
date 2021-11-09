package com.xworkz.mobile;

import com.xworkz.mobile.dao.MobileDAOImpl;

public class MobileTester {

	public static void main(String[] args) {

		MobileDAOImpl mobileDAOImpl = new MobileDAOImpl();

		 mobileDAOImpl.saveMobileEntity();

		 mobileDAOImpl.getMobileEntity();

		// mobileDAOImpl.updateMobileEntity();

		//mobileDAOImpl.deletMobileEntity();

	}

}
