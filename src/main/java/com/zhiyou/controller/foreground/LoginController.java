package com.zhiyou.controller.foreground;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.Admin;
import com.zhiyou.model.User;
import com.zhiyou.service.foreground.AdminService;
import com.zhiyou.service.foreground.UserService;
import com.zhiyou.utils.MD5Utils;

@Controller
public class LoginController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/adminLogin.do")
	public String adminLogin(String accounts, String accountsPassword,HttpServletRequest req) {
		Admin admin = adminService.SelectByAccounts(accounts);
		String md5 = MD5Utils.md5(accountsPassword);

		if(admin==null) {
			req.setAttribute("msg","’À∫≈¥ÌŒÛ");
		}else if(!(md5.equals(admin.getPassword()))) {
			req.setAttribute("msg","√‹¬Î¥ÌŒÛ");
		}else {
			req.getSession().setAttribute("admin", admin);
			return "forward:/course/list.do";
		}
		return "index";		
	}
	
	@RequestMapping("/loginOut.do")
	public String loginOut(HttpServletRequest req) {
		req.getSession().removeAttribute("admin");	
		req.getSession().removeAttribute("user");
		return "redirect:/";

	}
	
	@RequestMapping("/accountsCheck.do")
	protected void accountsCheck(String accounts, HttpServletResponse resp)  {

		boolean isExist;

		Admin selectByAccounts = adminService.SelectByAccounts(accounts);

		if(selectByAccounts ==null) {
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
	
	
	@RequestMapping("/userLogin.do")
	public void userLogin(String loginForm,HttpServletRequest req,HttpServletResponse resp) {
		String[] formParams = loginForm.split("&");
		String[] email = formParams[0].split("=");
		String[] passwords = formParams[1].split("=");
		String accounts = email[1];
		try {
			accounts=URLDecoder.decode(accounts,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
		String password = passwords[1];
		String md5 = MD5Utils.md5(password);
		User user = userService.SelectByAccounts(accounts);

		if(user==null) {
			//’À∫≈¥ÌŒÛ
			req.setAttribute("msg","’À∫≈¥ÌŒÛ");
		}else if(!(md5.equals(user.getPassword()))) {
			//√‹¬Î¥ÌŒÛ
			req.setAttribute("msg","√‹¬Î¥ÌŒÛ");
		}else {
			//µ«¬º≥…π¶

			req.getSession().setAttribute("user", user);
			
			
			try {
				resp.getWriter().write("success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	@RequestMapping("/validateEmail.do")
	public void validateEmail(String email,HttpServletResponse resp) {
		User user = userService.SelectByAccounts(email);
		if (user==null) {
			try {
				resp.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
//	@RequestMapping("/regUser.do")
//	public void regUser(String regForm,HttpServletResponse resp) {
//		System.out.println(regForm);
//		String[] formParams = regForm.split("&");
//		String[] emails = formParams[0].split("=");
//		String[] passwords = formParams[1].split("=");
//		
//
//		String email = emails[1];
//
//
//		String password = passwords[1];
//        String md5 = MD5Utils.md5(password);
//		try {
//			String accounts= URLDecoder.decode(email,"utf-8");
//            System.out.println(accounts);
//            System.out.println(md5);
//			User user = new User();
//			user.setAccounts(accounts);
//			user.setPassword(md5);
//			userService.add(user);
//		} catch (UnsupportedEncodingException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			resp.getWriter().write("success");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
