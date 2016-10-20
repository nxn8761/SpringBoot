package com.hello.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class XMLResponse {

	private List<Cricket> cricketList;

	public List<Cricket> getCricketList() {
		return cricketList;
	}

	public void setCricketList(List<Cricket> cricketList) {
		this.cricketList = cricketList;
	}
}
