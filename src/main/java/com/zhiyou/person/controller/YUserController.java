package com.zhiyou.person.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.model.User;
import com.zhiyou.person.service.PictureService;
import com.zhiyou.person.service.YUserService;
import com.zhiyou.utils.MD5Utils;

import com.zhiyou.utils.JsonUtils;

@Controller
@RequestMapping("/personal")
public class YUserController {

	@Autowired
	YUserService userService;	
	@Autowired
	PictureService pictureService;
	/**
	 * 
	 * @param req
	 * @return
	 * 28)进入修改资料
	 */

	@RequestMapping("/userUpadteShow")
	public String userUpadteShow(HttpServletRequest req) {

		return "/personalCenter/UserUpdate";

	}
	//进入更改头像
	@RequestMapping("/AvatarUpload")
	public String AvatarUpload(HttpServletRequest req) {
		return "/personalCenter/AvatarUpload";

	}
	//密码安全
	@RequestMapping("/PasswordUpdate")
	public String PasswordUpdate(HttpServletRequest req) {
		return "/personalCenter/PasswordUpdate";
	}

	/**
	 * 
	 * @param user
	 * @param req
	 * @return 29)提交修改资料
	 * 
	 */
	@RequestMapping("/userUpadte")
	public String userUpadte(User user,HttpServletRequest req) {
		User userOriginal =(User) req.getSession().getAttribute("user");
		String phone = userOriginal.getPhone();
		String password = userOriginal.getPassword();
		String imgurl = userOriginal.getImgurl();
		Date createtime = userOriginal.getCreatetime();
		user.setPhone(phone);
		user.setPassword(password);
		user.setImgurl(imgurl);
		user.setCreatetime(createtime);
		userService.update(user);
		req.getSession().setAttribute("user", user);
		return "personalCenter/PersonalCenter";

	}

	/**
	 * 
	 * @param imageFile
	 * @param req
	 * @return
	 * 
	 * 30)提交修改头像
	 */
	@RequestMapping("/uploadAvatar")
	//@ResponseBody
	public String uploadAvatar(MultipartFile imageFile, HttpServletRequest req) {
		
		if(imageFile==null) {
			return "/personalCenter/AvatarUpload";
		}
		else if (imageFile.getContentType().equals("image/jpeg")||imageFile.getContentType().equals("image/png") ) {
			try{

				Map result = pictureService.uploadPicture(imageFile);
				
				String imgUrl =(String) result.get("url");
				System.out.println(imgUrl);
				User user =(User) req.getSession().getAttribute("user");
				System.out.println(user);
				user.setImgurl(imgUrl);
				userService.update(user);
				req.getSession().setAttribute("user", user);

			}catch (Exception e) {
				// TODO: handle exception
			}

			return "/personalCenter/AvatarUpload";

		}else {
			req.setAttribute("msg", "头像格式不符");
			return "/personalCenter/AvatarUpload";}

	}
	/**
	 * 
	 * @param originalPassword
	 * @param req
	 * @param resp
	 * 
	 * 验证原密码是否正确
	 */
	@RequestMapping("/originalPasswordCheck")
	public void originalPasswordCheck(String originalPassword, HttpServletRequest req,HttpServletResponse resp) {
		User user =(User) req.getSession().getAttribute("user");
		String md5 = MD5Utils.md5(originalPassword);
		boolean isExist;
		if (!md5.equals(user.getPassword())) {
			//旧密码错误
			isExist=false;
		}else {
			isExist=true;
		}
		try {
			resp.getWriter().append("{\"isSuccess\":"+isExist+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@RequestMapping("/rePasswordCheck")
	public void rePasswordCheck(String newPassword,String rePassword, HttpServletRequest req,HttpServletResponse resp) {
		boolean isExist;
		if(rePassword.equals(newPassword)&& newPassword != "" ) {
			isExist=true;
		}else {
			isExist=false;
		}

		try {
			resp.getWriter().append("{\"isSuccess\":"+isExist+"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param newPassword
	 * @param req
	 * @return
	 * 31)修改密码
	 */
	@RequestMapping("/passwordUpdate")
	public String passwordUpdate(String newPassword,HttpServletRequest req) {
		User user =(User) req.getSession().getAttribute("user");
		String md5 = MD5Utils.md5(newPassword);
		user.setPassword(md5);
		userService.update(user);
		req.getSession().setAttribute("user", user);
		HttpSession session = req.getSession();
		session.removeAttribute("user");

		return "redirect:/index";

	}


}


