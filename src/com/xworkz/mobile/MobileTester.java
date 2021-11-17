package com.xworkz.mobile;

import java.util.Scanner;

import com.xworkz.mobile.dao.MobileDAOImpl;
import com.xworkz.mobile.entity.MobileEntity;

public class MobileTester {

	public static void main(String[] args) {

		MobileDAOImpl mobileDAOImpl = new MobileDAOImpl();

		MobileEntity mobileEntity = new MobileEntity("Nokia", 18000.0, "500GB", "cream", 20, true, "Andriod");

		// mobileDAOImpl.saveMobileEntity(mobileEntity);

		// mobileDAOImpl.getMobileEntity();

		// mobileDAOImpl.updateMobileEntity();

		// mobileDAOImpl.deletMobileEntity();

		// mobileDAOImpl.getAllMobileEntites();

		// mobileDAOImpl.getMobileBrandById(5);

		// mobileDAOImpl.getMobileColorByID(5);

//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter_ID");
//		int ID = scanner.nextInt();
//
		// mobileDAOImpl.getMobileEntityByID(1);

		// mobileDAOImpl.updateMobilePriceByID(1,25000);

		// mobileDAOImpl.deleteMobileEntityByID(6);
//
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Mobile_BRAND");	 
//		System.out.println("Mobile_Price");
//		String  brand = scanner.next();
//		double price= scanner.nextDouble();

		// mobileDAOImpl.updateMobilePriceByMobileBrand("apple", 48000);

		 mobileDAOImpl.getMobileEntityByMobileBrand("sony");

		// mobileDAOImpl.deleteMobileEntityByMobileBrand("Nokia");

		// mobileDAOImpl.countMobileEntityBrand("apple");

		// mobileDAOImpl.minPriceInMobileEntity();

		// mobileDAOImpl.maxPriceInMobileEntity();

		// mobileDAOImpl.avgPriceInMobileEntity();

		// mobileDAOImpl.sumOfPriceInMobileEntity();

	}

}
