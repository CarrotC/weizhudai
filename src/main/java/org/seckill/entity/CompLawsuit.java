package org.seckill.entity;

import java.sql.Date;

public class CompLawsuit {

	
	private int l_id;
	private int comp_id;
	private String posting_comp;
	private Date posting_date;
	private String posting_type;
	private String posting_people;
	public int getL_id() {
		return l_id;
	}
	public void setL_id(int l_id) {
		this.l_id = l_id;
	}
	public int getComp_id() {
		return comp_id;
	}
	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}
	public String getPosting_comp() {
		return posting_comp;
	}
	public void setPosting_comp(String posting_comp) {
		this.posting_comp = posting_comp;
	}
	public Date getPosting_date() {
		return posting_date;
	}
	public void setPosting_date(Date posting_date) {
		this.posting_date = posting_date;
	}
	public String getPosting_type() {
		return posting_type;
	}
	public void setPosting_type(String posting_type) {
		this.posting_type = posting_type;
	}
	public String getPosting_people() {
		return posting_people;
	}
	public void setPosting_people(String posting_people) {
		this.posting_people = posting_people;
	}
	
	
}
