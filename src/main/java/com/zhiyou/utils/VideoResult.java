package com.zhiyou.utils;

import lombok.Data;

@Data
public class VideoResult {
	 // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;
}
