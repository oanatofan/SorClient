<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import= "org.apache.jena.rdf.model.*"%>
<%@page import= "java.io.*"%>
<%@page import= "org.apache.jena.util.*"%> 
<%
	String n=request.getParameter("usr");  
	String p=request.getParameter("pass");  
	System.out.println(n);     
	System.out.println(p);
	String file="persons.rdf";
	Model model = ModelFactory.createDefaultModel();

	 // use the FileManager to find the input file
	 InputStream in = FileManager.get().open( "G:\\soft\\eclipse\\workspace\\SorClient\\WebContent\\persons.rdf ");
	if (in == null) {
	    throw new IllegalArgumentException(
	                                 "File: " + file + " not found");
	}

	// read the RDF/XML file
	model.read(in, null);
	//The second argument to the read() method call is the URI which 
	//will be used for resolving relative URI's. As there are no relative URI references 
	//in the test file, it is allowed to be empty. vc-db-1.rdf

	// write it to standard out
	model.write(System.out);    
%>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SOR Login</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>

	
</html>

	    