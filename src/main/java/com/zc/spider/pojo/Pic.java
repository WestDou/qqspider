package com.zc.spider.pojo;

public class Pic {
	
	private String pic_id;

	@Override
	public String toString() {
		return "Pic [pic_id=" + pic_id + "]";
	}

	public Pic(String pic_id) {
		super();
		this.pic_id = pic_id;
	}

	public Pic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPic_id() {
		return pic_id;
	}

	public void setPic_id(String pic_id) {
		this.pic_id = pic_id;
	}
	
	

}
