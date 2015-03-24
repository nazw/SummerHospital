package com.summergroup.summerhospital.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity(name = "doctorVisiting")
@Table(name = "DOCTOR_VISITING")
public class DoctorVisiting implements Serializable {
	private static final long serialVersionUID = 1L;
	private long doctorVisitingId;
	private Date fromdate;
	private Date todate;
	private Date startTime;
	private Date endTime;
	private int avgPerPatient;
	private Double charges;
	private Set<VisitingSlot> visitingSlots;
	private int versionId;
	private CommonDomainProperty commanDomainProperty;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DOCTOR_VISITING_ID")
	public long getDoctorVisitingId() {
		return doctorVisitingId;
	}

	public void setDoctorVisitingId(long doctorVisitingId) {
		this.doctorVisitingId = doctorVisitingId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FROM_DATE")
	public Date getFromdate() {
		return fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TO_DATE")
	public Date getTodate() {
		return todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "START_TIME")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "END_TIME")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "AVG_PER_PATIENT")
	public int getAvgPerPatient() {
		return avgPerPatient;
	}

	public void setAvgPerPatient(int avgPerPatient) {
		this.avgPerPatient = avgPerPatient;
	}

	@Column(name = "CHARGES")
	public Double getCharges() {
		return charges;
	}

	public void setCharges(Double charges) {
		this.charges = charges;
	}

	@OneToMany(mappedBy = "doctorVisiting", fetch = FetchType.LAZY)
	public Set<VisitingSlot> getVisitingSlots() {
		return visitingSlots;
	}

	public void setVisitingSlots(Set<VisitingSlot> visitingSlots) {
		this.visitingSlots = visitingSlots;
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
