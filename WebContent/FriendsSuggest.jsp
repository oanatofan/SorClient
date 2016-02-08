<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import= "java.util.List"%>
<%@page import= "com.Sor.User.SearchServlet.l"%>
<html>
<head>
<meta charset="UTF-8">
<title>Suggestion</title>
</head>
<body>
<%System.out.println(session.getAttribute("atr1")) ;%>
<a href="index.html">Logout</a>
			<a href="ViewPerson.html/ sau ViewOrganization.html">View</a>	
<h2>Sugested Friends</h2>
<div>

<% List<l> list = (List<l>)session.getAttribute("list");%>

<c:forEach items="${list}" var="person">
    <div>
    <form action="ShowUserServlet"  method="get">
    <input type="hidden" value="${person.v2}"  name="id1" />
    	<c:out value="${person.v1}"/>    <input type="submit" value="Add friend" />         
    </form>
    </div>
</c:forEach>

</div>

</body>
</html>