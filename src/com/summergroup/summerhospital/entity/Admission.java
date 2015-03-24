package com.summergroup.summerhospital.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;

import com.summergroup.summerhospital.util.AdmissionStatus;


@Entity(name = "admission")
@Table(name = "ADMISSION")
public class Admission implements Serializable{
	private static final long serialVersionUID = 1L;
	private long admissionId;
	private Patient patient;
	private Date dateAdmitted;
	private Date dateDischarged;
	private AdmissionStatus admissionStatus;
	private Set<RoomAllocation> roomAllocations;
	private Set<DoctorAllocation> doctorAllocations;
	private int versionId;
	private CommonDomainProperty commanDomainProperty;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADMISSION_ID")
	public long getAdmissionId() {
		return admissionId;
	}
	public void setAdmissionId(long admissionId) {
		this.admissionId = admissionId;
	}
	@ManyToOne
	@JoinColumn(name = "PATIENT_ID")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ADMITTED")
	public Date getDateAdmitted() {
		return dateAdmitted;
	}
	public void setDateAdmitted(Date dateAdmitted) {
		this.dateAdmitted = dateAdmitted;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_DISCHARGED")
	public Date getDateDischarged() {
		return dateDischarged;
	}
	public void setDateDischarged(Date dateDischarged) {
		this.dateDischarged = dateDischarged;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ADMISSION_STATUS")
	public AdmissionStatus getAdmissionStatus() {
		return admissionStatus;
	}
	public void setAdmissionStatus(AdmissionStatus admissionStatus) {
		this.admissionStatus = admissionStatus;
	}
	
	@OneToMany(mappedBy = "admission", fetch = FetchType.LAZY)
	public Set<RoomAllocation> getRoomAllocations() {
		return roomAllocations;
	}
	public void setRoomAllocations(Set<RoomAllocation> roomAllocations) {
		this.roomAllocations = roomAllocations;
	}
	
	@OneToMany(mappedBy = "admission", fetch = FetchType.LAZY)
	public Set<DoctorAllocation> getDoctorAllocations() {
		return doctorAllocations;
	}
	public void setDoctorAllocations(Set<DoctorAllocation> doctorAllocations) {
		this.doctorAllocations = doctorAllocations;
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
