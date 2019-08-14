package com.zhiyou.foreground.service;

import com.zhiyou.model.Video;
import com.zhiyou.model.extension.VideoExtension;

public interface VideoService {
	VideoExtension selectById(Integer videoId);
	void update(Video video);
}
