package com.relayr.productcomparisonservice.model;

import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel {
	
	private Date creationdate = new Date();
	
	private Date lastupdateddate =new Date();
	
	private String updatedBy;
	
	private String createdby;

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Date getLastupdateddate() {
		return lastupdateddate;
	}

	public void setLastupdateddate(Date lastupdateddate) {
		this.lastupdateddate = lastupdateddate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	
	
	
	
	
	

}
