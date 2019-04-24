package com.ycnet.dbank.domain;

import javax.persistence.Entity;

import com.ycnet.mirage.domain.DomainImpl;

@Entity
public class Student extends DomainImpl {

	private static final long serialVersionUID = -2188407432741814023L;
	private String name;
	private String sex;
	private String major;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
}
