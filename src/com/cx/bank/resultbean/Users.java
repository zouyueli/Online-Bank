package com.cx.bank.resultbean;

/**
 * 
 * ���Users��Ӧ�Ľ��bean
 * @author zouyueli
 * @version Bank-ssm
 */
public class Users {
	
	private int id;
    private String username;  //�û���
    private String password;  //����
    private double money;  //���
    private int isFreeze;
    
	public int getIsFreeze() {
		return isFreeze;
	}
	public void setIsFreeze(int isFreeze) {
		this.isFreeze = isFreeze;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
}
