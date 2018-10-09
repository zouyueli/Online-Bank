package com.cx.bank.manager;

import java.util.List;

import com.cx.bank.actionform.UserForm;
import com.cx.bank.resultbean.Detail;
import com.cx.bank.resultbean.Users;
/**
 * ҵ���ӿڣ�����ҵ�����
 * @author zouyueli
 * @version Bank3.0
 */
public interface Manager{

  /**
   * �û�ע�����
   */
  public void register(UserForm userForm);
  
  /**
   * �û���¼����
   */
  public Users login(UserForm userForm);
  
  /**
   * ��ȡ���
   * 
   */
  public double inquiry(int id);
  
  /**
   * ���
   */
  public void deposit(UserForm userForm,Users user);
  
  /**
   * ȡ��
   */
  public void withdrawal(UserForm userForm,Users user);
  
  /**
   * ת��
   */
  public void transfer(UserForm userForm,Users user);
  
  /**
   * ��ѯ������ϸ
   */
  public List<Detail> showTransDetail(int id);

}
