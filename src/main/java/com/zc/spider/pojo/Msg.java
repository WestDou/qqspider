package com.zc.spider.pojo;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="Msg")
public class Msg {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length=32)
	private String name;
	@Column(length=500)
	private String content;
	@Column(length=32)
	private String createTime;
	@Transient
	private ArrayList<Pic> pic;
	@Column(length=32)
	private String source_name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public ArrayList<Pic> getPic() {
		return pic;
	}
	public void setPic(ArrayList<Pic> pic) {
		this.pic = pic;
	}
	public String getSource_name() {
		return source_name;
	}
	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}
	public Msg(String name, String content, String createTime, ArrayList<Pic> pic, String source_name) {
		super();
		this.name = name;
		this.content = content;
		this.createTime = createTime;
		this.pic = pic;
		this.source_name = source_name;
	}
	public Msg() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Msg [name=" + name + ", content=" + content + ", createTime=" + createTime + ", pic=" + pic
				+ ", source_name=" + source_name + "]";
	}
	
	
	
}
