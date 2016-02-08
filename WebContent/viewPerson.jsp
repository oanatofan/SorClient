<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<<<<<<< HEAD
<!DOCTYPE html >
=======
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
>>>>>>> origin/master
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
<<<<<<< HEAD
		<form action="SearchServlet"  method="get">
=======
>>>>>>> origin/master
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
<<<<<<< HEAD
			<input type="text" value="${sessionScope.userName}" placeholder="Username" readonly="readonly" required id="userName" />		
=======
			<input type="text" value=<c:out value="${sessionScope.userName}"/> placeholder="Username" readonly="readonly" required id="userName" />		
>>>>>>> origin/master
			</div>
			
			<div>
			<label>Given name</label> 
<<<<<<< HEAD
			<input type="text" value="${sessionScope.givenName}" placeholder="Given Name" readonly="readonly" required id="giveName" />  
=======
			<input type="text" value=<c:out value="${sessionScope.givenName}"/> placeholder="Given Name" readonly="readonly" required id="giveName" />  
>>>>>>> origin/master
			</div>
			
			<div>
			<label>Family name</label> 
<<<<<<< HEAD
			<input type="text" value="${sessionScope.familyName}" placeholder="Family Name" readonly="readonly" required id="familyName" />
=======
			<input type="text" value=<c:out value="${sessionScope.familyName}"/> placeholder="Family Name" readonly="readonly" required id="familyName" />
>>>>>>> origin/master
			</div>
			
			<div>
			<label>E-mail</label> 
<<<<<<< HEAD
			<input type="text" value="${sessionScope.userMail}" placeholder="Youre email address" readonly="readonly" required id="email" />
=======
			<input type="email" value=<c:out value="${sessionScope.userMail}"/> placeholder="Youre email address" readonly="readonly" required id="email" />
>>>>>>> origin/master
			</div>
			
			<div>
			<label>Homepage</label> 
<<<<<<< HEAD
			<input type="text" value="${sessionScope.homepage}" placeholder="Homepage" readonly="readonly" required id="homePage" />
=======
			<input type="text" value=<c:out value="${sessionScope.homepage}"/> placeholder="Homepage" readonly="readonly" required id="homePage" />
>>>>>>> origin/master
			</div>
			
			<div>
			<label>Phone</label> 
<<<<<<< HEAD
			<input type="text" value="${sessionScope.phone}" placeholder="Phone" readonly="readonly" required id="phone" /> 
=======
			<input type="text" value=<c:out value="${sessionScope.phone}"/> placeholder="Phone" readonly="readonly" required id="phone" /> 
>>>>>>> origin/master
			</div>

			<h2>Profesional </h2>
			
			<div>
			<label>Worked at</label> 
<<<<<<< HEAD
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
=======
			<input type="text" value=<c:out value="${sessionScope.worked}"/> placeholder="Worked at" readonly="readonly" required id="workedAt" /> 
			</div>
			<div>
			<label>Knowledge & Experience</label> 
			<input type="text" value=<c:out value="${sessionScope.knowledge}"/> placeholder="Knowledge & Experience" readonly="readonly" required id="knowledgeExperience" />  
			</div>
			<div>
			<label>Studied</label> 
			<input type="text" value=<c:out value="${sessionScope.studied}"/> placeholder="Studied" readonly="readonly" required id="studied" /> 
			</div>
			<div>
			<label>Salary</label> 
			<input type="text" value=<c:out value="${sessionScope.salary}"/> placeholder="Salary" readonly="readonly" required id="salary" /> 
>>>>>>> origin/master
			</div>
			<h2>Others</h2>
			<div>
			<label>Age</label> 
<<<<<<< HEAD
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
=======
			<input type="text" value=<c:out value="${sessionScope.age}"/> placeholder="Age" readonly="readonly" required id="age" />
			</div>
			<div>
			<label>Nationality</label> 
			<input type="text" value=<c:out value="${sessionScope.nationality}"/> placeholder="Nationality" readonly="readonly" required id="nationality" />
			</div>
			<div>
			<label>Marital status</label> 
			<input type="text" value=<c:out value="${sessionScope.married}"/> placeholder="Marital status" readonly="readonly" required id="maritalStatus" />
			</div>
			<div>
			<label>Drivers license</label> 
			<input type="text" value=<c:out value="${sessionScope.driverLicense}"/> placeholder="Drivers license" readonly="readonly" required id="driversLicense" /> 
>>>>>>> origin/master
			</div>
			<h2>Friends</h2>
			<div>
			<label>Friends</label> 
<<<<<<< HEAD
			<input type="text" value="${sessionScope.friends}" placeholder="Friends" readonly="readonly" required id="friends" />
			</div>
			<div>

				<input type="submit" value="SearchServlet" />
=======
			<input type="text" value=<c:out value="${sessionScope.friends}"/> placeholder="Friends" readonly="readonly" required id="friends" />
			</div>
			<div>

				<input type="submit" value="Update" />
>>>>>>> origin/master


			</div>


		</section>
		<!-- content -->
	</div>
	<!-- container -->
</body>
</html>