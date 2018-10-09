package com.cx.bank.manager;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.cx.bank.actionform.MoneyBean;
import com.cx.bank.actionform.UserForm;
import com.cx.bank.mapper.UserMapper;
import com.cx.bank.resultbean.Detail;
import com.cx.bank.resultbean.Users;
import com.cx.bank.util.MD5;
import com.cx.bank.util.MyException;

public class ManagerImpl implements Manager{
	
    @Resource(name="mapper")
    private UserMapper mapper;
    
    @Resource(name="moneyBean")
    private MoneyBean moneyBean;
    /**
     * �û�ע��
     */
	@Override
	public void register(UserForm userForm) {
	
		Users user = new Users();
		user.setUsername(userForm.getUsername());
		user.setPassword((new MD5()).encode(userForm.getPassword().getBytes()));
	
		try{
			mapper.insertUserByUsernameAndPassword(user);
		}catch(Exception e){
		    throw new MyException("ע��ʧ��");
		}
		
		
	}
    
	/**
	 * �û���¼
	 */
	@Override
	public Users login(UserForm userForm) {
		
		Users user = new Users();
		user.setUsername(userForm.getUsername());
		System.out.println(userForm.getUsername());
		user.setPassword((new MD5()).encode(userForm.getPassword().getBytes()));

		Users u = mapper.selectUserByUsernameAndPassword(user);
		if(u != null){
			return u;
		}else{
			throw new MyException("��¼ʧ��");
		}
	}
	
	/**
	 * ��ѯ���
	 */
	@Override
	public double inquiry(int id){
		return moneyBean.getMoney();
	}
	
	/**
	 * ���
	 */
	@Override
	public void deposit(UserForm userForm,Users user) {
		
	    double money = userForm.getMoney();
	    user.setMoney(moneyBean.getMoney()+money);

	    mapper.updateMoney(user);	
	   
	    moneyBean.setMoney(moneyBean.getMoney()+money);
	    	
	    Detail detail = new Detail();
	    detail.setReason("deposit");
	    detail.setMoney(+money);
	    detail.setDate(new Date());
	    detail.setUser(user);
	    mapper.insertTransDetail(detail);
	 	    
	}
	
	/**
	 * ȡ��
	 */
	@Override
	public void withdrawal(UserForm userForm, Users user) {
		double money = userForm.getMoney();
	    user.setMoney(moneyBean.getMoney()-money);
	    	
	    if(money > moneyBean.getMoney()){
	    	throw new MyException("����");  //����
	    }else{
	    	mapper.updateMoney(user);
	    	
	    	//ʵʱ�����ڴ��е����
	    	moneyBean.setMoney(moneyBean.getMoney()-money);
	    	
	    	//��װ������ϸ����,�������ݿ��detail��
	    	Detail detail = new Detail();
	    	detail.setReason("withdrawal");
	    	detail.setMoney(-money);
	    	detail.setDate(new Date());
	    	detail.setUser(user);
	 	    mapper.insertTransDetail(detail);
		} 
	}
	
	/**
	 * ת�� 
	 */
	@Override
	public void transfer(UserForm userForm, Users user) {
        String otherUsername = userForm.getOtherUserName();
        double money = userForm.getMoney();
        user.setMoney(moneyBean.getMoney()-money);
        System.out.println(otherUsername);
        
        Users otherUser = mapper.selectUserByUsername(otherUsername);
        System.out.println(otherUser);
                
        if(otherUser == null){
            throw new MyException("�����ڸ��û�");  //�����ڸ��û�
        }else if(money > moneyBean.getMoney()){
        	throw new MyException("����");  //����
        }else{
        	otherUser.setMoney(otherUser.getMoney()+money);
        	
        	mapper.updateMoney(otherUser);
        	mapper.updateMoney(user);
        	
    		moneyBean.setMoney(moneyBean.getMoney()-money);
        	
        	Detail detail = new Detail();
        	detail.setReason("transfer");
        	detail.setMoney(-money);
        	detail.setDate(new Date());
        	detail.setUser(user);
		    mapper.insertTransDetail(detail);
		    
		    //��Ǯ��
		    Detail detail1 = new Detail();
        	detail1.setReason("income");
        	detail1.setMoney(money);
        	detail1.setDate(new Date());
        	detail1.setUser(otherUser);
		    mapper.insertTransDetail(detail1);
        }
	}
	
	/** 
	 * ��ѯ������ϸ
	 */
	@Override
	public List<Detail> showTransDetail(int id) {

		 List<Detail> list = mapper.selectDetailByUserId(id);
		 return list;
	}
}
