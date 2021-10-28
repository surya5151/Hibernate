package com.xworkz.mobile.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "mobile_details")
@Entity
public class MobileEntity {

	@Id
	@Column(name = "mobile_ID")
	private int mobileID;

	@Column(name = "mobile_Brand")
	private String mobileBrand;

	@Column(name = "mobile_Price")
	private double mobilePrice;

	@Column(name = "mobile_Rom")
	private String mobileRom;

	@Column(name = "mobile_Color")
	private String mobileColor;

	@Column(name = "camera_Size")
	private int cameraSize;

	@Column(name = "isFinger_PrintSupport")
	private boolean isFingerPrintSupport;

	@Column(name = "os_Type")
	private String osType;

	public MobileEntity(int mobileID, String mobileBrand, double mobilePrice, String mobileRom, String mobileColor,
			int cameraSize, boolean isFingerPrintSupport, String osType) {
		super();
		this.mobileID = mobileID;
		this.mobileBrand = mobileBrand;
		this.mobilePrice = mobilePrice;
		this.mobileRom = mobileRom;
		this.mobileColor = mobileColor;
		this.cameraSize = cameraSize;
		this.isFingerPrintSupport = isFingerPrintSupport;
		this.osType = osType;
	}

	public int getMobileID() {
		return mobileID;
	}

	public void setMobileID(int mobileID) {
		this.mobileID = mobileID;
	}

	public String getMobileBrand() {
		return mobileBrand;
	}

	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}

	public double getMobilePrice() {
		return mobilePrice;
	}

	public void setMobilePrice(double mobilePrice) {
		this.mobilePrice = mobilePrice;
	}

	public String getMobileRom() {
		return mobileRom;
	}

	public void setMobileRom(String mobileRom) {
		this.mobileRom = mobileRom;
	}

	public String getMobileColor() {
		return mobileColor;
	}

	public void setMobileColor(String mobileColor) {
		this.mobileColor = mobileColor;
	}

	public int getCameraSize() {
		return cameraSize;
	}

	public void setCameraSize(int cameraSize) {
		this.cameraSize = cameraSize;
	}

	public boolean isFingerPrintSupport() {
		return isFingerPrintSupport;
	}

	public void setFingerPrintSupport(boolean isFingerPrintSupport) {
		this.isFingerPrintSupport = isFingerPrintSupport;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

}
