<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import= "java.io.*"%>
<%
String attrib=null;
session.getAttribute("givenName");
System.out.println(session.getAttribute("givenName"));
 %>

<html>
<head>
<meta charset="UTF-8">
<title>View Person</title>
<link rel="stylesheet" type="text/css" href="style2.css" />
</head>
<body>
	<div class="container">
		<section id="content">
		<form action="SearchServlet"  method="get">
			<a href="index.html">Logout</a>
			<a href="EditPerson.html">Edit Person</a>
			<a href="FriendList.html">Suggest Friends</a> 
			<a href="OrganizationList.html">Suggest jobs</a> 
			<a href="Search.html">Search Friends</a>
			<a href="Messages.html">Inbox</a>
			<h1>View Profile</h1>
			<h2><c:out value="${sessionScope.givenName}"/>  <c:out value="${sessionScope.familyName}"/></h2>
			
			
			<div>
			<label>Username</label> 
			<input type="text" value="${sessionScope.userName}" placeholder="Username" readonly="readonly" required id="userName" />		
			</div>
			
			<div>
			<label>Given name</label> 
			<input type="text" value="${sessionScope.givenName}" placeholder="Given Name" readonly="readonly" required id="giveName" />  
			</div>
			
			<div>
			<label>Family name</label> 
			<input type="text" value="${sessionScope.familyName}" placeholder="Family Name" readonly="readonly" required id="familyName" />
			</div>
			
			<div>
			<label>E-mail</label> 
			<input type="text" value="${sessionScope.userMail}" placeholder="Youre email address" readonly="readonly" required id="email" />
			</div>
			
			<div>
			<label>Homepage</label> 
			<input type="text" value="${sessionScope.homepage}" placeholder="Homepage" readonly="readonly" required id="homePage" />
			</div>
			
			<div>
			<label>Phone</label> 
			<input type="text" value="${sessionScope.phone}" placeholder="Phone" readonly="readonly" required id="phone" /> 
			</div>

			<h2>Profesional </h2>
			
			<div>
			<label>Worked at</label> 
			<input type="text" value="${sessionScope.workedOrg}" placeholder="Worked at" readonly="readonly" required id="workedAt" /> 
			</div>
			<label>Career level</label> 
			<input type="text" value="${sessionScope.careerLevel}" placeholder="Career Level" readonly="readonly" required id="CareerLevel" /> 
			</div>
			<div>
			<label>Knowledge</label> 
			<input type="text" value="${sessionScope.knowledge}" placeholder="Knowledge & Experience" readonly="readonly" required id="knowledgeExperience" />  
			</div>
			<div>
			<label>Studied at</label>
			<input type="text" value="${sessionScope.studied}"  placeholder="Studied" readonly="readonly" required id="studied" /> 

			</div>
			<div>
			<label>Salary</label> 
			<input type="text" value="${sessionScope.salary}" placeholder="Salary" readonly="readonly" required id="salary" /> 
			</div>
			<h2>Others</h2>
			<div>
			<label>Age</label> 
			<input type="text" value="${sessionScope.age}" placeholder="Age" readonly="readonly" required id="age" />
			</div>
			<div>
			<label>Nationality</label> 
			<input type="text" value="${sessionScope.nationality}" placeholder="Nationality" readonly="readonly" required id="nationality" />
			</div>
			<div>
			<label>Marital status</label> 
			<input type="text" value="${sessionScope.married}" placeholder="Marital status" readonly="readonly" required id="maritalStatus" />
			</div>
			<div>
			<label>Drivers license</label> 
			<input type="text" value="${sessionScope.driverLicense}" placeholder="Drivers license" readonly="readonly" required id="driversLicense" /> 
			</div>
			<h2>Friends</h2>
			<div>
			<label>Friends</label> 
			<input type="text" value="${sessionScope.friends}" placeholder="Friends" readonly="readonly" required id="friends" />
			</div>
			<div>

				<input type="submit" value="SearchServlet" />


			</div>


		</section>
		<!-- content -->
	</div>
	<!-- container -->
</body>
</html>