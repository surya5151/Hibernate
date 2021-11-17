package com.xworkz.mobile.dao;

import com.xworkz.mobile.entity.MobileEntity;

public interface MobileDAO {

	void saveMobileEntity(MobileEntity mobileEntity);

	void getMobileEntity();

	void updateMobileEntity();

	void deletMobileEntity();

	void getAllMobileEntites();

	void getMobileBrandById(int mobileID);

	void getMobileColorByID(int mobileID);

	void getMobileEntityByID(int mobileID);

	void updateMobilePriceByID(int mobileID, double price);

	void deleteMobileEntityByID(int mobileID);

	void updateMobilePriceByMobileBrand(String mobileBrand, double mobilePrice);

	void getMobileEntityByMobileBrand(String mobileBrand);

	void deleteMobileEntityByMobileBrand(String mobileBrand);

	void countMobileEntityBrand(String brand);

	void minPriceInMobileEntity();

	void maxPriceInMobileEntity();

	void avgPriceInMobileEntity();

	void sumOfPriceInMobileEntity();

}
