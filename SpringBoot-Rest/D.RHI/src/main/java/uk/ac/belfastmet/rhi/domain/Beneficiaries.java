package uk.ac.belfastmet.rhi.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Beneficiaries {

	@Id
	@GeneratedValue
	private Integer beneficiariesId;
	private String name;
	private Date applicationDate;
	private String bussinessOrInstallationLocation;
	private String technologyTypeInstallation;
	private Integer capacity;
	private Float amountOfPaymentsMadeTo28Feb;
	
	public Beneficiaries(Integer beneficiariesId, String name, Date applicationDate,
			String bussinessOrInstallationLocation, String technologyTypeInstallation, Integer capacity,
			Float amountOfPaymentsMadeTo28Feb) {
		super();
		this.beneficiariesId = beneficiariesId;
		this.name = name;
		this.applicationDate = applicationDate;
		this.bussinessOrInstallationLocation = bussinessOrInstallationLocation;
		this.technologyTypeInstallation = technologyTypeInstallation;
		this.capacity = capacity;
		this.amountOfPaymentsMadeTo28Feb = amountOfPaymentsMadeTo28Feb;
	}

	public Beneficiaries() {
		super();
	}

	public Integer getBeneficiariesId() {
		return beneficiariesId;
	}

	public void setBeneficiariesId(Integer beneficiariesId) {
		this.beneficiariesId = beneficiariesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getBussinessOrInstallationLocation() {
		return bussinessOrInstallationLocation;
	}

	public void setBussinessOrInstallationLocation(String bussinessOrInstallationLocation) {
		this.bussinessOrInstallationLocation = bussinessOrInstallationLocation;
	}

	public String getTechnologyTypeInstallation() {
		return technologyTypeInstallation;
	}

	public void setTechnologyTypeInstallation(String technologyTypeInstallation) {
		this.technologyTypeInstallation = technologyTypeInstallation;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Float getAmountOfPaymentsMadeTo28Feb() {
		return amountOfPaymentsMadeTo28Feb;
	}

	public void setAmountOfPaymentsMadeTo28Feb(Float amountOfPaymentsMadeTo28Feb) {
		this.amountOfPaymentsMadeTo28Feb = amountOfPaymentsMadeTo28Feb;
	}
	
	
	
	
}
