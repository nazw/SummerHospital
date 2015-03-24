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

import com.summergroup.summerhospital.util.BookingStatus;


@Entity(name = "visitingSlot")
@Table(name = "VISITING_SLOT")
public class VisitingSlot implements Serializable {
	private static final long serialVersionUID = 1L;
	private String visitingSlotId;
	private DoctorVisiting doctorVisiting;
	private BookingStatus bookingStatus;
	private Appointment appointment;
	private int versionId;
	private CommonDomainProperty commanDomainProperty;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VISITING_SLOT_ID")
	public String getVisitingSlotId() {
		return visitingSlotId;
	}

	public void setVisitingSlotId(String visitingSlotId) {
		this.visitingSlotId = visitingSlotId;
	}

	@ManyToOne
	@JoinColumn(name = "DOCTOR_VISITING_ID")
	public DoctorVisiting getDoctorVisiting() {
		return doctorVisiting;
	}

	public void setDoctorVisiting(DoctorVisiting doctorVisiting) {
		this.doctorVisiting = doctorVisiting;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "BOOKING_STATUS")
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@OneToOne(mappedBy = "visitingSlot")
	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
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

	public void setCommanDomainProperty(
			CommonDomainProperty commanDomainProperty) {
		this.commanDomainProperty = commanDomainProperty;
	}
}
