package com.zc.spider.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="pic")
public class Pic {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length=32)
	private String qq_num;
	
	@Column(length=1000)
	private String url1;
	
	@Column(length=1000)
	private String url2;
	
	@Column(length=1000)
	private String url3;
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQq_num() {
		return qq_num;
	}

	public void setQq_num(String qq_num) {
		this.qq_num = qq_num;
	}


	

	

	public Pic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUrl1() {
		return url1;
	}

	public void setUrl1(String url1) {
		this.url1 = url1;
	}

	public String getUrl2() {
		return url2;
	}

	public void setUrl2(String url2) {
		this.url2 = url2;
	}

	public String getUrl3() {
		return url3;
	}

	public void setUrl3(String url3) {
		this.url3 = url3;
	}

	@Override
	public String toString() {
		return "Pic [id=" + id + ", qq_num=" + qq_num + ", url1=" + url1 + ", url2=" + url2 + ", url3=" + url3 + "]";
	}

	public Pic(Long id, String qq_num, String url1, String url2, String url3) {
		super();
		this.id = id;
		this.qq_num = qq_num;
		this.url1 = url1;
		this.url2 = url2;
		this.url3 = url3;
	}

	
	
	

}
