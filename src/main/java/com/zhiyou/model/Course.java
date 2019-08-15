package com.zhiyou.model;

import lombok.Data;

@Data
public class Course {
    private Integer id;

    private String courseTitle;

    private String courseDesc;

    private Integer subjectId;
    
    // 当前页码数
 	private Integer page = 1;
 	// 数据库从哪一条数据开始查
 	private Integer start;
 	// 每页显示数据条数
 	private Integer rows = 10;
}
