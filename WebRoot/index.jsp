<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body style="background:#f4f4f4">
<center>
    
    
    <h1><spring:message code="bank.page.title"/></h1>
    <h2><spring:message code="bank.page.choose"/></h2>
    
    
    <h3><a href="chinese.do?locale=zh_CN"><button><spring:message code="bank.page.chinese"/></button></a></h3>
    <h3><a href="english.do?locale=en_US"><button>English</button></a></h3>
    
    
    <a href="<%=path%>/toLogin.do"><spring:message code="bank.user.login"/> </a>
    <a href="<%=path%>/toRegister.do"><spring:message code="bank.user.register"/></a>
    
</center>    
</body>
</html>