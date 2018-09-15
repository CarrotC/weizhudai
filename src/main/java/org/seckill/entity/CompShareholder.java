package org.seckill.entity;

import java.sql.Date;

public class CompShareholder {
	private int s_id;
	private int comp_id;
	private String name;
	private double shareholding_ratio;
	private String type;
	private double subscribed_capital_contribution;
	private Date date_of_subscription;
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getComp_id() {
		return comp_id;
	}
	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getShareholding_ratio() {
		return shareholding_ratio;
	}
	public void setShareholding_ratio(double shareholding_ratio) {
		this.shareholding_ratio = shareholding_ratio;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getSubscribed_capital_contribution() {
		return subscribed_capital_contribution;
	}
	public void setSubscribed_capital_contribution(double subscribed_capital_contribution) {
		this.subscribed_capital_contribution = subscribed_capital_contribution;
	}
	public Date getDate_of_subscription() {
		return date_of_subscription;
	}
	public void setDate_of_subscription(Date date_of_subscription) {
		this.date_of_subscription = date_of_subscription;
	}
	
	
	
}
