package com.zhiyou.foreground.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.dao.UserMapper;
import com.zhiyou.foreground.service.AdminService;
import com.zhiyou.foreground.service.UserService;
import com.zhiyou.model.Admin;
import com.zhiyou.model.User;
import com.zhiyou.utils.MD5Utils;
import com.zhiyou.utils.MailUtil;

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
			req.setAttribute("msg","用户名错误");
		}else if(!(md5.equals(admin.getPassword()))) {
			req.setAttribute("msg","密码错误");
		}else {
			req.getSession().setAttribute("admin", admin);
			return "redirect:/course/list.do";
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
	
	@RequestMapping("/userCheck.do")
	protected void usersCheck(String user, HttpServletResponse resp)  {

		boolean isExist;
        System.out.println(user);
		User selectByAccounts = userService.SelectByAccounts(user);

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
		
			req.setAttribute("msg","用户名错误");
		}else if(!(md5.equals(user.getPassword()))) {
		
			req.setAttribute("msg","密码错误");
		}else {
		

			req.getSession().setAttribute("user", user);
			req.getSession().setMaxInactiveInterval(1000*60*60*24*10);
			
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
	
	@RequestMapping("/regUser.do")
	public void regUser(String regForm,HttpServletResponse resp) {
		System.out.println(regForm);
		String[] formParams = regForm.split("&");
		String[] emails = formParams[0].split("=");
		String[] passwords = formParams[1].split("=");
		

		String email = emails[1];


		String password = passwords[1];
        String md5 = MD5Utils.md5(password);
		try {
			String accounts= URLDecoder.decode(email,"utf-8");
            System.out.println(accounts);
            System.out.println(md5);
			User user = new User();
			user.setAccounts(accounts);
			user.setPassword(md5);
			userService.add(user);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			resp.getWriter().write("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/MailCheck.do")
	protected void MailCheck(HttpServletRequest req, HttpServletResponse resp)  {
		
		
		String receivermail = req.getParameter("mail");
		System.out.println(receivermail);
		String sendEmail = userService.sendEmail(receivermail);
	
		try {
			resp.getWriter().write(sendEmail);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/foreground/updatePassword.do")
	public String foregroundUpdatePassword(HttpServletRequest req) {
	try {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User user = userService.SelectByAccounts(email);
		String md5 = MD5Utils.md5(password);
		user.setPassword(md5);
		userService.update(user);
		req.setAttribute("msg", "修改成功");
	    return "index";
	}catch (Exception e) {
		// TODO: handle exception
	}
	   req.setAttribute("msg", "修改失败");
	    return "index";
	}
}
