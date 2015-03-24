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
import javax.persistence.Table;
import javax.persistence.Version;

import com.summergroup.summerhospital.util.RoomStatus;
import com.summergroup.summerhospital.util.RoomType;

@Entity(name = "room")
@Table(name = "ROOM")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;
	private long roomId;
	private RoomType roomType;
	private RoomStatus roomStatus;
	private int versionId;
	private CommonDomainProperty commanDomainProperty;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROOM_ID")
	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ROOM_TYPE")
	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
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

	public void setCommanDomainProperty(
			CommonDomainProperty commanDomainProperty) {
		this.commanDomainProperty = commanDomainProperty;
	}
}
