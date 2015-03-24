package com.summergroup.summerhospital.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Component
@Embeddable
public class CommonDomainProperty implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long createdUser;
	private Date creationDate;
	private Date lastModifiedDate;
	private long lastModifiedUser;
	
	@Temporal(TemporalType.DATE)
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	@Temporal(TemporalType.DATE)
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public long getLastModifiedUser() {
		return lastModifiedUser;
	}
	public void setLastModifiedUser(long lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}
	public long getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(long createdUser) {
		this.createdUser = createdUser;
	}
	

}
