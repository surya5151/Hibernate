package com.xworkz.mobile;

import java.util.Scanner;

import com.xworkz.mobile.dao.MobileDAOImpl;
import com.xworkz.mobile.entity.MobileEntity;

public class MobileTester {

	public static void main(String[] args) {

		MobileDAOImpl mobileDAOImpl = new MobileDAOImpl();

		MobileEntity mobileEntity = new MobileEntity("Sony3", 25000.0, "500GB", "cream", 20, true, "Andriod");
		// mobileDAOImpl.saveMobileEntity(mobileEntity);

		// mobileDAOImpl.getMobileEntity();

		// mobileDAOImpl.updateMobileEntity();

		// mobileDAOImpl.deletMobileEntity();

		// mobileDAOImpl.getAllMobileEntites();

		// mobileDAOImpl.getMobileBrandById(1);

		// mobileDAOImpl.getMobileColorByID(1);

//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter_ID");
//		int mobileID = scanner.nextInt();

		// mobileDAOImpl.getMobileEntityByID(2);

		// mobileDAOImpl.updateMobilePriceByID(2);

		// mobileDAOImpl.deleteMobileEntityByID(10);

		// mobileDAOImpl.updateMobilePriceByMobileBrand("Apple");

		// mobileDAOImpl.getMobileEntityByMobileBrand("Samsung");

		// mobileDAOImpl.deleteMobileEntityByMobileBrand("Sony2");

		// mobileDAOImpl.countMobileEntityBrand("nokia");

		// mobileDAOImpl.minPriceInMobileEntity();

		// mobileDAOImpl.maxPriceInMobileEntity();

		// mobileDAOImpl.avgPriceInMobileEntity();

		mobileDAOImpl.sumOfPriceInMobileEntity();

	}

}
