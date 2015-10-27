package com.example.chetrobot;

public class ListData {

	private String content;
	private final static int CLIENT = 1;
	private final static int SERVER = 2;
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
