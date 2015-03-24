package com.summergroup.summerhospital.entity;

import java.io.Serializable;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;

import com.summergroup.summerhospital.util.AccountStatus;
import com.summergroup.summerhospital.util.BookingStatus;

@Entity(name = "appointment")
@Table(name = "APPOINTMENT")
public class Appointment implements Serializable{
	private static final long serialVersionUID = 1L;
	private long appointmentId;
	private Patient patient;
	private VisitingSlot visitingSlot;
	private Doctor doctor;
	private BookingStatus bookingStatus;
	private int versionId;
	private CommonDomainProperty commanDomainProperty;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "APPOINTMENT_ID")
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
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
	
	@OneToOne
	@JoinColumn(name = "VISITING_SLOT_ID")
	public VisitingSlot getVisitingSlot() {
		return visitingSlot;
	}
	public void setVisitingSlot(VisitingSlot visitingSlot) {
		this.visitingSlot = visitingSlot;
	}
	
	@ManyToOne
	@JoinColumn(name = "DOCTOR_ID")
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "BOOKING_STATUS")
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
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
