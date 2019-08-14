package com.zhiyou.controller.foreground;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.Admin;
import com.zhiyou.service.foreground.AdminService;
import com.zhiyou.utils.MD5Utils;

@Controller
public class LoginController {

	@Autowired
	private AdminService adminService;
	
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
}
