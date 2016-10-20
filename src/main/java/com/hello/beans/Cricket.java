package com.hello.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Cricket {

	private String bat;
	
	private String ball;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-DD",timezone="EST")
	private Date dob;

	public String getBat() {
		return bat;
	}

	public void setBat(String bat) {
		this.bat = bat;
	}

	public String getBall() {
		return ball;
	}

	public void setBall(String ball) {
		this.ball = ball;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
}
