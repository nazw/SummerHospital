package com.summergroup.summerhospital.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;

import com.summergroup.summerhospital.util.BloodGroup;





@Entity(name = "patient")
@Table(name = "PATIENT")
public class Patient implements Serializable{
	private static final long serialVersionUID = 1L;
	private long patientId;	
	private SystemUser systemUser;
	private BloodGroup bloodGroup;
	private int versionId;
	private CommonDomainProperty commanDomainProperty;	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PATIENT_ID")
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
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
	
	@Enumerated(EnumType.STRING)
	@Column(name = "BLOOD_GROUP")
	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
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
