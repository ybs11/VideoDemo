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
import com.zhiyou.person.service.YUserService;
import com.zhiyou.utils.MD5Utils;

@Controller
public class YUserController {

	@Autowired
	YUserService userService;	
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
		int id=userOriginal.getId();
		String nickname=userOriginal.getNickname();
		String sex=userOriginal.getSex();
		String birthday=userOriginal.getBirthday();
		String address=userOriginal.getAddress();
		Timestamp createtime = (Timestamp) userOriginal.getCreatetime();
		user.setNickname(nickname);
		user.setSex(sex);
		user.setBirthday(birthday);
		user.setAddress(address);
		user.setCreatetime(createtime);
		userService.add(user);;
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
	@RequestMapping("/uploadAvatar")
	public String uploadAvatar(MultipartFile imageFile, HttpServletRequest req) {
//		System.out.println(imageFile);
		System.out.println(imageFile.getContentType());
		if (imageFile.getContentType().equals("image/jpeg")||imageFile.getContentType().equals("image/png") ) {
			System.out.println("格式符合");
		
		String imageName = System.currentTimeMillis()+imageFile.getOriginalFilename();
		String realPath = req.getSession().getServletContext().getRealPath("static/z/");
		String name = realPath +imageName;
		String imgUrl ="${pageContext.request.contextPath}/static/z/"+imageName;
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
		
		return "/personalCenter/AvatarUpload";
		}
		req.setAttribute("msg", "头像格式不符");
		return "/personalCenter/AvatarUpload";
		
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
		return "/foreground/PersonalCenter";
		
	}
	
	
}


