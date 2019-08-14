package com.zhiyou.model.extension;

import com.zhiyou.model.Speaker;
import com.zhiyou.model.Video;

import lombok.Data;
@Data
public class VideoExtension extends Video{

	private Speaker speaker;
}
