<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!-- 로그인 승인을 처리하는 로직 -> 화면디자인이(View가) 필요없다. -->


<%
	//filter를 적용하여 아래 코드 생략함
	//request.setCharacterEncoding("utf-8");	

	//사용자가 입력한 데이터 수신
	String userid = request.getParameter("userid");
	String password = request.getParameter("password");
	
	Map<String,String> loginInfo = new HashMap<String,String>();
	
	//DB에 조회요청


	if(true){//로그인 성공
	  response.sendRedirect("./list.jsp");
	}else{//로그인 실패
	  response.sendRedirect("./login.jsp");
	}
%>