package com.zc.spider.pojo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import com.zc.spider.enumeration.TaskLevel;



public class UrlPojo {
	private Map<String, Object> parasMap;

	public Map<String, Object> getParasMap() {
		return parasMap;
	}

	public void setParasMap(Map<String, Object> parasMap) {
		this.parasMap = parasMap;
	}

	// ��ַ
	private String url;
	// ���ȼ�
	private TaskLevel taskLevel = TaskLevel.MIDDLE;

	@Override
	public String toString() {
		return "UrlPojo [url=" + url + ", taskLevel=" + taskLevel + "]";
	}

	public UrlPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UrlPojo(String url, Map<String, Object> parasMap) {
		this.url = url;
		this.parasMap = parasMap;
	}

	public UrlPojo(String url) {
		super();
		this.url = url;
	}

	public UrlPojo(String url, TaskLevel taskLevel) {
		super();
		this.url = url;
		this.taskLevel = taskLevel;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TaskLevel getTaskLevel() {
		return taskLevel;
	}

	public void setTaskLevel(TaskLevel taskLevel) {
		this.taskLevel = taskLevel;
	}

	// Ϊ��httpurlconnerction��ʽ��ȡ����
	public HttpURLConnection getHttpUrlConnection() {
		URL bigUrl;
		try {
			bigUrl = new URL(this.url);
			URLConnection openConnection = bigUrl.openConnection();
			if (openConnection instanceof HttpURLConnection) {
				HttpURLConnection httpUrlConnection = (HttpURLConnection) openConnection;
				return httpUrlConnection;
			} else {
				throw new Exception("����ʧ��");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// Ϊ�˸�socket��ʽ��ȡ�˿�Ҫ�õ�
	public String getHost() {
		try {
			URL BigUrl = new URL(this.url);
			return BigUrl.getHost();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}

