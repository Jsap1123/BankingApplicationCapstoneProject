package com.learning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="staff")
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long staffId;
	private String staffFullName;
	private String staffUserName;
	private String staffPassword;
    private boolean status;
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	public String getStaffFullName() {
		return staffFullName;
	}
	public void setStaffFullName(String staffFullName) {
		this.staffFullName = staffFullName;
	}
	public String getStaffUserName() {
		return staffUserName;
	}
	public void setStaffUserName(String staffUserName) {
		this.staffUserName = staffUserName;
	}
	public String getStaffPassword() {
		return staffPassword;
	}
	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Staff(long staffId, String staffFullName, String staffUserName, String staffPassword, boolean status) {
		super();
		this.staffId = staffId;
		this.staffFullName = staffFullName;
		this.staffUserName = staffUserName;
		this.staffPassword = staffPassword;
		this.status = status;
	}
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
