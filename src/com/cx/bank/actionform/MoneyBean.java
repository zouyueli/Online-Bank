package com.cx.bank.actionform;

/**
 * ����ʵʱ��ʾ���ݿ�������
 * @author zouyueli
 * @version Bank3.0
 */
public class MoneyBean {
	
	private double money;
	
	private static MoneyBean instance = new MoneyBean();
	private MoneyBean(){}
	public static MoneyBean getInstance(){
		return instance;
	}
	
	public double getMoney(){
		return this.money;
	}
	
	public void setMoney(double money){
		this.money = money;
	}
}
