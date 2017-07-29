package smn.action;

import java.util.Map;

import smn.dao.LoginDao;
import smn.vo.Login;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<Login> {
	private Login login = new Login();
	private String message;

	public Login getModel() {
		// TODO Auto-generated method stub
		return login;
	}

	public String execute() throws Exception {
		LoginDao loginDao = new LoginDao();
		Login l = loginDao.checkLogin(getModel());
		if (l != null) {
			Map session = ActionContext.getContext().getSession();
			session.put("login", l);
			if (l.getRole() == 1) {
				return "admin";// 管理员身份登录
			} else {
				return "student"; // 学生身份登录
			}
		} else {
			return ERROR;
		}
	}

	public void validate() {
		if (login.getName() == null || login.getName().equals("")) {
			this.addFieldError("name", "用户名不能为空！");
		} else if (login.getPassword() == null
				|| login.getPassword().equals("")) {
			this.addFieldError("password", "密码不能为空");
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
