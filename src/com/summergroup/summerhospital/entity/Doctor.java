package com.summergroup.summerhospital.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;

import com.summergroup.summerhospital.util.AccountStatus;

@Entity(name = "doctor")
@Table(name = "DOCTOR")
public class Doctor implements Serializable{
	private static final long serialVersionUID = 1L;
	private long doctorId;
	private String licenceNo;
	private String description;
	private SystemUser systemUser;
	private Specialization specialization;		
	private AccountStatus accountStatus;
	private int versionId;
	private CommonDomainProperty commanDomainProperty;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DOCTOR_ID")
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	
	@Column(name = "LICENCE_NO")
	public String getLicenceNo() {
		return licenceNo;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToOne
	@JoinColumn(name = "SYSTEM_USER_ID")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	public SystemUser getSystemUser() {
		return systemUser;
	}
	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}
	
	@ManyToOne
	@JoinColumn(name = "SPECIALIZATION_ID")
	public Specialization getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ACCOUNT_STATUS")
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	@Version
	@Column(name = "VERSION_ID")
	public int getVersionId() {
		return versionId;
	}
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "creationDate", column = @Column(name = "CREATION_DATE")),
			@AttributeOverride(name = "lastModifiedUser", column = @Column(name = "LAST_MODIFIED_USER")),
			@AttributeOverride(name = "lastModifiedDate", column = @Column(name = "LAST_MODIFIED_DATE")),
			@AttributeOverride(name = "createdUser", column = @Column(name = "CREATED_USER")) })
	public CommonDomainProperty getCommanDomainProperty() {
		return commanDomainProperty;
	}
	public void setCommanDomainProperty(CommonDomainProperty commanDomainProperty) {
		this.commanDomainProperty = commanDomainProperty;
	}
}
