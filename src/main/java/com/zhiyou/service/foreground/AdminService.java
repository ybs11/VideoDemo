package com.zhiyou.service.foreground;

import com.zhiyou.model.Admin;

public interface AdminService {
	Admin SelectByAccounts(String accounts);
	Admin SelectByAdminId(int adminId);
}
