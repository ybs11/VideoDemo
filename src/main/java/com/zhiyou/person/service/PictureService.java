package com.zhiyou.person.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

	Map uploadPicture(MultipartFile imageFile);
}
