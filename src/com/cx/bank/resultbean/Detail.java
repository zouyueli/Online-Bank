package com.cx.bank.resultbean;

import java.util.Date;

/**
 * ������ϸ��
 * ���Detail��Ӧ�Ľ��bean
 * @author zouyueli
 * @version Bank4.0
 */
public class Detail {
	private int id;  // ����
    private String reason;  // ��ϸԭ��
    private double money;  // ���׽��
    private Date date;   // ��������
    private Users user;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}
