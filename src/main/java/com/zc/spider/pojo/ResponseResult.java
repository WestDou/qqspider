package com.zc.spider.pojo;

import java.util.ArrayList;

public class ResponseResult {
	
	
	
	private ArrayList<Msg> msglist;

	public ArrayList<Msg> getMsglist() {
		return msglist;
	}

	public void setMsglist(ArrayList<Msg> msglist) {
		this.msglist = msglist;
	}

	@Override
	public String toString() {
		return "ResponseResult [msglist=" + msglist + "]";
	}

	public ResponseResult(ArrayList<Msg> msglist) {
		super();
		this.msglist = msglist;
	}

	public ResponseResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
