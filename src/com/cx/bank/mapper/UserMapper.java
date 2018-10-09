package com.cx.bank.mapper;

import java.util.List;

import com.cx.bank.resultbean.Detail;
import com.cx.bank.resultbean.Users;

public interface UserMapper {
	
	 /**
	  * ��ѯһ����¼
	  * @return
	  */
	 public Users selectUserByUsernameAndPassword(Users user);
	 
	 
	 /**
	  * ��users��ֻ����һ����¼
	  */
	 public void insertUserByUsernameAndPassword(Users user);
	 
	 
    /**
     * ����moneyֵ
     */
    public void updateMoney(Users user);

    
    /**
     * ͨ���û�����User
     * @param username
     * @return
     */
    public Users selectUserByUsername(String username);
    
    /**
     * ��ѯ������ϸ
     * @param id
     * @return
     */
    public List<Detail> selectDetailByUserId(int id);
    
    /**
     * ���뽻����ϸ
     * @param detail
     * @return
     */
    public void insertTransDetail(Detail detail);
    
   /* 
    *//**
     * ͨ���û����õ�isFreeze�ֶ�ֵ
     * @param username
     * @return
     *//*
    public int selectIsFreeze(String username);*/

}
