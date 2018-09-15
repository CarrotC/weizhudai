package org.seckill.entity;

import java.sql.Date;

public class CompShareholder {
	private int sId;
	private int compId;
	private String name;
	private double shareholdingRatio;
	private String type;
	private double subscribedCapitalContribution;
	private Date dateOfSubscription;


	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getShareholdingRatio() {
		return shareholdingRatio;
	}

	public void setShareholdingRatio(double shareholdingRatio) {
		this.shareholdingRatio = shareholdingRatio;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getSubscribedCapitalContribution() {
		return subscribedCapitalContribution;
	}

	public void setSubscribedCapitalContribution(double subscribedCapitalContribution) {
		this.subscribedCapitalContribution = subscribedCapitalContribution;
	}

	public Date getDateOfSubscription() {
		return dateOfSubscription;
	}

	public void setDateOfSubscription(Date dateOfSubscription) {
		this.dateOfSubscription = dateOfSubscription;
	}
}
