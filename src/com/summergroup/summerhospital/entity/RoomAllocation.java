package com.summergroup.summerhospital.entity;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
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
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;

import com.summergroup.summerhospital.util.RoomStatus;


@Entity(name = "roomAllocation")
@Table(name = "ROOM_ALLOCATION")
public class RoomAllocation implements Serializable{
	private static final long serialVersionUID = 1L;
	private long roomAllocationId;
	private Room room;
	private Admission admission;
	private RoomStatus roomStatus;
	private int versionId;
	private CommonDomainProperty commanDomainProperty;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROOM_ALLOCATION_ID")
	public long getRoomAllocationId() {
		return roomAllocationId;
	}
	public void setRoomAllocationId(long roomAllocationId) {
		this.roomAllocationId = roomAllocationId;
	}
	
	@ManyToOne
	@JoinColumn(name = "ROOM_ID")
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADMISSION_ID")	
	public Admission getAdmission() {
		return admission;
	}
	public void setAdmission(Admission admission) {
		this.admission = admission;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ROOM_STATUS")
	public RoomStatus getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(RoomStatus roomStatus) {
		this.roomStatus = roomStatus;
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
