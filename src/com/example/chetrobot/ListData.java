package com.example.chetrobot;

import java.security.PublicKey;

public class ListData {

	private String content;
	public final static int SEND = 1;
	public final static int RECEIVER = 2;
	private int flag;
	
	public ListData(String content,int flag){
		this.content = content;
		this.flag = flag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
