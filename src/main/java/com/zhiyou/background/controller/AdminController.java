package com.zhiyou.background.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.background.service.AdminService;
import com.zhiyou.model.Admin;
import com.zhiyou.utils.MD5Utils;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/show.do")
	public String show(Model model){
		List<Admin> list = adminService.selectAll();
		model.addAttribute("list", list);
		return "background/BackgroundAdminShow";
	}
	
	@RequestMapping("/addAdminShow.do")
	public String addSpeakerShow() {
		return "background/BackgroundAdminAdd";
	}
	
	@RequestMapping("/addAdmin.do")
	public String addSpeaker(HttpServletRequest request,Admin admin) {
		String password = request.getParameter("password");
		admin.setPassword(MD5Utils.md5(password));
		adminService.insert(admin);
		return "forward:show.do";
	}
	
	@RequestMapping("/delAdminById.do")
	@ResponseBody
	public String delSpeakerById(Integer id) {
		String msg = "fail";
		try {
			adminService.deleteByPrimaryKey(id);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	/*批量删除*/
	@RequestMapping(value="/deleteAll.do",method=RequestMethod.POST)
	@ResponseBody
	public String deleteAll(String ids) {
		String[] ss = ids.split(",");
		Integer[] id = new Integer[ss.length];
		for (int i = 0; i < ss.length; i++) {
			id[i] = Integer.valueOf(ss[i]);
		}
		adminService.deleteAll(id);
		return "true";
	}
	
	@RequestMapping("/edit.do")
	public String edit(Model model,Integer id) {
		Admin admin = adminService.selectByPrimaryKey(id);
		model.addAttribute("Admin", admin);
		return "background/BackgroundAdminUpdate";
	}
	
	@RequestMapping("/update.do")
	public String update(Admin admin) {
		adminService.updateByPrimaryKey(admin);
		return "forward:show.do";
	}
	/**
	 * 退出
	 * @param req
	 * @return
	 */
	@RequestMapping("/loginOut.do")
	public String loginOut(HttpServletRequest req) {
		req.getSession().removeAttribute("admin");	
		return "index";

	}
}
