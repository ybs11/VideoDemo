package com.zhiyou.model;

public class VideoExtends extends Video{
	
	private Course course;
    
    private Speaker speaker;
   
    // 当前页码数
 	private Integer page = 1;
 	// 数据库从哪一条数据开始查
 	private Integer start;
 	// 每页显示数据条数
 	private Integer rows = 10;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}  
 	
 	
}
