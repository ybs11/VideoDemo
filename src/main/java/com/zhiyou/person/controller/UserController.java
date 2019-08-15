package com.zhiyou.person.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.model.User;
import com.zhiyou.person.service.UserService;
import com.zhiyou.utils.MD5Utils;

@Controller
public class UserController {

	@Autowired
	UserService userService;	
	/**
	 * 
	 * @param req
	 * @return
	 * 28)进入修改资料
	 */
	
	@RequestMapping("/userUpadteShow.do")
	public String userUpadteShow(HttpServletRequest req) {
		/*
		 * User user =(User) req.getSession().getAttribute("user"); String address =
		 * user.getAddress(); String[] split = address.split("-"); String prov =
		 * split[0]; String city = split[1]; req.setAttribute("prov", prov);
		 * req.setAttribute("city", city);
		 */
		return "/foreground/UserUpdate";
		
	}
	
	/**
	 * 
	 * @param user
	 * @param req
	 * @return 29)提交修改资料
	 * 
	 */
	@RequestMapping("/userUpadte.do")
	public String userUpadte(User user,HttpServletRequest req) {
		//System.out.println(user);
		User userOriginal =(User) req.getSession().getAttribute("user");
		String phone = userOriginal.getPhone();
		String password = userOriginal.getPassword();
		String imgurl = userOriginal.getImgurl();
		Timestamp createtime = (Timestamp) userOriginal.getCreatetime();
		user.setPhone(phone);
		user.setPassword(password);
		user.setImgurl(imgurl);
		user.setCreatetime(createtime);
		userService.update(user);
		req.getSession().setAttribute("user", user);
		return "/foreground/PersonalCenter";
		
	}
	
	/**
	 * 
	 * @param imageFile
	 * @param req
	 * @return
	 * 
	 * 30)提交修改头像
	 */
	@RequestMapping("/uploadAvatar.do")
	public String uploadAvatar(MultipartFile imageFile, HttpServletRequest req) {
//		System.out.println(imageFile);
		System.out.println(imageFile.getContentType());
		if (imageFile.getContentType().equals("image/jpeg")||imageFile.getContentType().equals("image/png") ) {
			System.out.println("格式符合");
		
		String imageName = System.currentTimeMillis()+imageFile.getOriginalFilename();
		String realPath = req.getSession().getServletContext().getRealPath("static/z/");
		String name = realPath +imageName;
		String imgUrl ="/VideoSSM/static/z/"+imageName;
		User user =(User) req.getSession().getAttribute("user");
		user.setImgurl(imgUrl);
		userService.update(user);
		req.getSession().setAttribute("user", user);

		try {
			imageFile.transferTo(new File(name));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "/foreground/AvatarUpload";
		}
		req.setAttribute("msg", "头像格式不符");
		return "/foreground/AvatarUpload";
		
	}
	/**
	 * 
	 * @param originalPassword
	 * @param req
	 * @param resp
	 * 
	 * 验证原密码是否正确
	 */
	@RequestMapping("/originalPasswordCheck.do")
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
	@RequestMapping("/rePasswordCheck.do")
	public void rePasswordCheck(String newPassword,String rePassword, HttpServletRequest req,HttpServletResponse resp) {
//		System.out.println("newPassword:"+newPassword);
//		System.out.println("rePassword:"+rePassword);
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
	@RequestMapping("/passwordUpdate.do")
	public String passwordUpdate(String newPassword,HttpServletRequest req) {
		User user =(User) req.getSession().getAttribute("user");
		String md5 = MD5Utils.md5(newPassword);
		user.setPassword(md5);
		userService.update(user);
		req.getSession().setAttribute("user", user);
		return "/foreground/PersonalCenter";
		
	}
	
	
}


