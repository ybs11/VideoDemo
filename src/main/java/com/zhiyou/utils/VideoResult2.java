package com.zhiyou.utils;

public class VideoResult2 {
	private int status;
	private Object data;
	private String msg;
	
	//ok 200
	public static VideoResult2 ok() {
		VideoResult2 videoResult = new VideoResult2();
		videoResult.setStatus(200);
		return videoResult;
	}
	
	//success 200 data
	public static VideoResult2 success(Object obj) {
		return new VideoResult2(200,obj);
	}

	//error 201
	public static VideoResult2 error() {
		VideoResult2 videoResult = new VideoResult2();
		videoResult.setStatus(201);
		return videoResult;
	}
	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}



	public VideoResult2(int status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}



	public VideoResult2() {
		super();
	}
	
	
	
}
