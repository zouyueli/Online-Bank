package com.cx.bank.actionform;

public class UserForm {
	
	private String username;
	private String password;
	
	private double money;  //��ȡ���ת�˽��
	private String otherUserName; //��Ǯ�˵��û���
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getOtherUserName() {
		return otherUserName;
	}
	public void setOtherUserName(String otherUserName) {
		this.otherUserName = otherUserName;
	}
}
