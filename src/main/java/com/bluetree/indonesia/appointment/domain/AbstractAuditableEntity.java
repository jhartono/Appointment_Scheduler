package com.bluetree.indonesia.appointment.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
public abstract class AbstractAuditableEntity extends AbstractEntity {

	private static final long serialVersionUID = 7839509017490377322L;

	@LastModifiedDate
	@Column(name = "last_modified_date")
	private Date lastUpdated;
	
	@LastModifiedBy
	@Column(name="last_modified_by")
    private String lastUpdateUser;
    
	@CreatedDate
    @Column(name = "created_date", nullable = false)
    private Date created;
    
	@CreatedBy
	@Column(name="created_by", nullable = false)
    private String createUser;

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public Date getCreated() {
		return created;
	}

	public String getCreateUser() {
		return createUser;
	}
}
