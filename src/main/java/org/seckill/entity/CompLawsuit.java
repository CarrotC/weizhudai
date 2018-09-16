package org.seckill.entity;

import java.sql.Date;

public class CompLawsuit {

	
	private int lId;
	private String compId;
	private String postingComp;
	private Date postingDate;
	private String postingType;
	private String postingPeople;


	public int getlId() {
		return lId;
	}

	public void setlId(int lId) {
		this.lId = lId;
	}

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public String getPostingComp() {
		return postingComp;
	}

	public void setPostingComp(String postingComp) {
		this.postingComp = postingComp;
	}

	public Date getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}

	public String getPostingType() {
		return postingType;
	}

	public void setPostingType(String postingType) {
		this.postingType = postingType;
	}

	public String getPostingPeople() {
		return postingPeople;
	}

	public void setPostingPeople(String postingPeople) {
		this.postingPeople = postingPeople;
	}
}
