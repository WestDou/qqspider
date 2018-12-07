package com.zc.spider.pojo;

import java.util.ArrayList;

public class ResponseResult {
	
	
	
	private ArrayList<Msg> msglist;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<Msg> getMsglist() {
		return msglist;
	}

	public void setMsglist(ArrayList<Msg> msglist) {
		this.msglist = msglist;
	}

	
	@Override
	public String toString() {
		return "ResponseResult [msglist=" + msglist + ", message=" + message + "]";
	}

	

	public ResponseResult(ArrayList<Msg> msglist, String message) {
		super();
		this.msglist = msglist;
		this.message = message;
	}

	public ResponseResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
