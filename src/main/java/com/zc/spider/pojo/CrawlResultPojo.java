package com.zc.spider.pojo;

//ץȡ����ķ�ס
public class CrawlResultPojo {
	//�Ƿ�ץȡ�ɹ�
	private boolean isSuccess;
	//���ص�ץȡ����
	private String pageContent;
	//���ص�״̬��
	private int httpStatuCode;
	public CrawlResultPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CrawlResultPojo(boolean isSuccess, String pageContent, int httpStatuCode) {
		super();
		this.isSuccess = isSuccess;
		this.pageContent = pageContent;
		this.httpStatuCode = httpStatuCode;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getPageContent() {
		return pageContent;
	}
	public void setPageContent(String pageContent) {
		this.pageContent = pageContent;
	}
	public int getHttpStatuCode() {
		return httpStatuCode;
	}
	public void setHttpStatuCode(int httpStatuCode) {
		this.httpStatuCode = httpStatuCode;
	}
	@Override
	public String toString() {
		return "CrawlResultPojo [isSuccess=" + isSuccess + ", pageContent=" + pageContent + ", httpStatuCode="
				+ httpStatuCode + "]";
	}
	
	
	
	
	
	
}
