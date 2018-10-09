package com.cx.bank.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cx.bank.actionform.MoneyBean;
import com.cx.bank.actionform.UserForm;
import com.cx.bank.manager.Manager;
import com.cx.bank.resultbean.Detail;
import com.cx.bank.resultbean.Users;

@Controller
public class UserController {
	
	@Resource(name="manager")
	private Manager manager;
	
	@Resource(name="moneyBean")
	private MoneyBean moneyBean;
	
	/**
	 * ���ʻ�ģ��
	 */
	@RequestMapping("/chinese.do")
	public ModelAndView chinese(HttpServletRequest request){
		return new ModelAndView("views/index");  // �����ض���ʽ��תҳ��
	}
	@RequestMapping("/english.do")
	public ModelAndView english(HttpServletRequest request){
		return new ModelAndView("views/index");  // �����ض���ʽ��תҳ��
	}
	
	/**
	 * ��תҳ��
	 */
	@RequestMapping("/toLogin.do")
	public ModelAndView toLogin(HttpServletRequest request){
		return new ModelAndView("views/login");  // �����ض���ʽ��תҳ��
	}
	@RequestMapping("/toRegister.do")
	public ModelAndView register(HttpServletRequest request){
		return new ModelAndView("views/register");  // �����ض���ʽ��תҳ��
	}
	
    /**
     *��¼ע��ģ��
     */
	@RequestMapping("/register.do")
	public ModelAndView register(UserForm userForm){  //���Զ�����UserForm���󣬰ѱ���Ĳ�����װ��userForm��
		manager.register(userForm);
		return new ModelAndView(new RedirectView("./login.jsp"));
	}
	@RequestMapping("/login.do")
	public String login(UserForm userForm,HttpServletRequest request){
		Users user = manager.login(userForm);
	    request.getSession().setAttribute("user", user);
	    moneyBean.setMoney(user.getMoney());
	    return "mainpage";
	}
	
	
	/**
	 * ҵ�����ģ��
	 */
	@RequestMapping("/inquiry.do")
	public String inquiry(HttpServletRequest request){
		int id= ((Users)request.getSession().getAttribute("user")).getId();
		double money = manager.inquiry(id);
		request.setAttribute("money", money);
		return "balance";
	}
	
	@RequestMapping("/deposit.do")
	public String deposit(UserForm userForm, HttpServletRequest request){
		Users user = (Users)request.getSession().getAttribute("user");
		manager.deposit(userForm, user);
		return "success";
	}
	
	@RequestMapping("/withdrawal.do")
	public String withdrawal(UserForm userForm, HttpServletRequest request){
		Users user = (Users)request.getSession().getAttribute("user");
		manager.withdrawal(userForm, user);
		return "success";
	}
	
	@RequestMapping("/transfer.do")
	public String transfer(UserForm userForm, HttpServletRequest request){
		Users user = (Users)request.getSession().getAttribute("user");
		System.out.println(",,,"+userForm.getOtherUserName());
		manager.transfer(userForm, user);
		return "success";
	}
	
	@RequestMapping("/getAllDetails.do")
	public String getAllDetails(HttpServletRequest request){
		int id = ((Users)request.getSession().getAttribute("user")).getId();
		List<Detail> list = manager.showTransDetail(id);
		request.setAttribute("detaillist", list);
		return "transDetails";
	}
	
    @RequestMapping("/toTransferForm.do")
	public String toTransferForm(HttpServletRequest request){
		
		return "transferForm";
	}
}
