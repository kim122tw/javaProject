<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">會員註冊</h1>
<form action="../addMemberController" align="center">
<font size="4">帳號:<input type="text" name="username"></font><br>
<font size="4">密碼:<input type="password" name="password"></font><br>
<font size="4">名字:<input type="text" name="name"></font><br>
<font size="4">地址:<input type="text" name="address"></font><br>
<font size="4">家電:<input type="text" name="phone"></font><br>
<font size="4">手機:<input type="text" name="mobile"></font><br><br>
<input type="submit" name="ok">
</form>
</body>
</html>