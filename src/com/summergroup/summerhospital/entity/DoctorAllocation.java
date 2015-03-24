package com.summergroup.summerhospital.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;


@Entity(name = "doctorAllocation")
@Table(name = "DOCTOR_ALLOCATION")
public class DoctorAllocation implements Serializable{
	private static final long serialVersionUID = 1L;
	private long doctorAllocationId;
	private Doctor doctor;
	private Admission admission;
	private Date allocationStartDate;
	private Date allocationEndDate;	
	private int versionId;
	private CommonDomainProperty commanDomainProperty;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DOCTOR_ALLOCATION_ID")
	public long getDoctorAllocationId() {
		return doctorAllocationId;
	}
	public void setDoctorAllocationId(long doctorAllocationId) {
		this.doctorAllocationId = doctorAllocationId;
	}
	
	@ManyToOne
	@JoinColumn(name = "DOCTOR_ID")
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	@ManyToOne
	@JoinColumn(name = "ADMISSION_ID")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	public Admission getAdmission() {
		return admission;
	}
	public void setAdmission(Admission admission) {
		this.admission = admission;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "ALLOCATION_START_DATE")	
	public Date getAllocationStartDate() {
		return allocationStartDate;
	}
	public void setAllocationStartDate(Date allocationStartDate) {
		this.allocationStartDate = allocationStartDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ALLOCATION_END_DATE")
	public Date getAllocationEndDate() {
		return allocationEndDate;
	}
	public void setAllocationEndDate(Date allocationEndDate) {
		this.allocationEndDate = allocationEndDate;
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
