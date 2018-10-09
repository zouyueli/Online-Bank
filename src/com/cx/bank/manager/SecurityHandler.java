package com.cx.bank.manager;

import java.util.Date;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.cx.bank.actionform.UserForm;
import com.cx.bank.mapper.UserMapper;
import com.cx.bank.resultbean.Detail;
import com.cx.bank.resultbean.Users;
import com.cx.bank.util.MyException;

/**
 * ע�ⷽʽ���AOP
 * @author zouyueli
 */

@Aspect
public class SecurityHandler{
	
	@Resource(name="mapper")
	private UserMapper mapper;
	
	
	@Pointcut("execution(* com.cx.bank.manager.ManagerImpl.login(..))")
	private void loginMethod(){};
	
	@Pointcut("execution(* com.cx.bank.manager.ManagerImpl.*(..))")
	private void allMethod(){};
	/**
	 * Ȩ����֤
	 * @throws RuntimeException
	 */
	@Before("loginMethod()")
	public void checkSecurity(JoinPoint joinPoint) {
		
		Object[] o = joinPoint.getArgs();
		UserForm u = (UserForm)o[0];
		Users user = mapper.selectUserByUsername(u.getUsername());
		int flag = user.getIsFreeze();
	    if(flag==0){
	    	//û������
	    	Manager manager = (Manager)joinPoint.getTarget();
	    	manager.login(u);
	    }else{
	    	throw new MyException("�˺ű�����");
	    }
	}
}
