package com.Sor.User;

import java.io.IOException;
import java.io.PrintWriter;

<<<<<<< HEAD
import javax.servlet.RequestDispatcher;
=======
<<<<<<< HEAD
import javax.servlet.RequestDispatcher;
=======
<<<<<<< HEAD
import javax.servlet.RequestDispatcher;
=======
<<<<<<< HEAD
import javax.servlet.RequestDispatcher;
=======
<<<<<<< HEAD
import javax.servlet.RequestDispatcher;
=======
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
>>>>>>> origin/master
import javax.servlet.http.HttpSession;

import com.Sor.Models.Hobby;
import com.Sor.Models.Job;
import com.Sor.Models.LoginResponse;
import com.Sor.Models.Person;
import com.Sor.Models.Skill;
import com.Sor.Models.Studied;
import com.Sor.Models.Worked;
<<<<<<< HEAD
import com.Sor.Utils.Constants;
=======
<<<<<<< HEAD
>>>>>>> origin/master
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
<<<<<<< HEAD

=======

=======
=======
<<<<<<< HEAD

import com.Sor.Models.LoginResponse;
import com.Sor.Models.Person;
>>>>>>> origin/master
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

<<<<<<< HEAD
=======
=======
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
>>>>>>> origin/master
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
<<<<<<< HEAD
import java.net.ProtocolException;
=======
>>>>>>> origin/master
import java.net.URL;
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master
/**
 * Servlet implementation class LoginServlet
 */
@SuppressWarnings("unused")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
<<<<<<< HEAD
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession(true); 
		//response.setContentType("text/html");  
		PrintWriter out = response.getWriter();       
		String n=request.getParameter("usr");  
		String p=request.getParameter("pass");  
		System.out.println(n);     
		System.out.println(p); 
			
		if(validate(n,p)){  
			String url="/viewPerson.jsp";
			RequestDispatcher rd=request.getRequestDispatcher(url);  
		    rd.forward(request,response);  
			//HttpServletResponse.sendRedirect(url);
		}  
		else{  
			out.print("Sorry. Wrong username or password! ");  
		}  	         
		    out.close();  
	
	}
	
	private boolean validate(String username,String password) {
		boolean result=false;
		try{	//http://sorserver.eu-gb.mybluemix.net/
			//http://localhost:8080/SorServer/rest/user/login?userName=Examples&userPassword=09709
			String urlString="http://sorserver.eu-gb.mybluemix.net/rest/user/login?userName="+ username + "&userPassword=" + password;
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("userName", username);
			conn.setRequestProperty("userPassword", password);
			//System.out.println(conn.getURL());
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			
			String output;
			String id = null;
			String type = null;
			Boolean logged = false;
			
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				ObjectMapper mapper = new ObjectMapper();
				LoginResponse log = mapper.readValue(output, LoginResponse.class);
				id=log.getUserId();
				type=log.getUserType();
				logged=log.getLogedin();
				System.out.println(id);
				
				session.setAttribute("id", id);
				session.setAttribute("type", type);
				session.setAttribute("logged", logged);
				//System.out.println(actualObj.get);
		
			if (logged){	
				result=  true;	
			}else {
				result =false;
			}
			}
			conn.disconnect();
			
			getperson(id);
			
			} catch (MalformedURLException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			}
		return result;	  
		  }
	
	public void getperson(String userId) throws IOException
	{   //http://sorserver.eu-gb.mybluemix.net/rest/user/viewPerson?userId=
		String urlString=Constants.url+"user/viewPerson?userId="+ userId ;
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		System.out.println("Output from Server .... \n");
		
		while ((output = br.readLine()) != null) {
			ObjectMapper mapper = new ObjectMapper();
			
			Person pers = mapper.readValue(output, Person.class);
			String userName = pers.getUserName();
			String givenName = pers.getGivenName();
			String familyName = pers.getFamilyName();
			String userMail = pers.getUserMail() ;
			String userAddress = pers.getUserAddress() ;
			
			List<Worked> worked = pers.getWorked();
			String workedOrg= worked.get(0).getOrganizationId().toString();
			String careerLevel=worked.get(0).getJob().getJobCareerLevel().toString();
			//String workedOrg=worked.get(0).getOrganizationId().toString();
			//System.out.println(workedOrg);
			//String careerLevel=worked.get(0).getJob().getJobCareerLevel().toString();
			
			
			List<Skill> knowledge = pers.getKnowledge() ;	
			String knowledgeString ="";
			int countk=0;
			for(Skill s:knowledge){
				if (countk==0){
					knowledgeString=knowledgeString + s.getSkillName();
				}else{
					knowledgeString=knowledgeString+"," + s.getSkillName();
				}
				countk++;
				}
			System.out.println(knowledgeString);
			
			List<Person> friends = pers.getFriends() ;
			String friendsList="";
			int countf=0;
			for(Person p:friends){
				if (countf==0){
				friendsList=friendsList + p.getName();
			}else{
				friendsList=friendsList+"," + p.getName();
			}
				countf++;
			}
			
			String  nationality= pers.getNationality() ;
			String married = pers.getMarried() ;
			String age = pers.getAge() ;
			String driverLicense = pers.getDriverLicense();
			String homepage = pers.getHomepage();
			String phone = pers.getPhone();
			String salary = pers.getSalary();
			String title = pers.getTitle();
			List<Hobby> hobbies = pers.getHobbies();
			List<Job> jobsSearched = pers.getJobesSearched();
			List<Studied> studied= pers.getStudied();	
			String studiedString =studied.toString();
			String studiedAt=studied.get(0).getOrganizationId();
			System.out.println(studiedAt);
			session.setAttribute("userName", userName);
			session.setAttribute("givenName", givenName);
			session.setAttribute("familyName", familyName);
			session.setAttribute("userMail", userMail);
			session.setAttribute("userAddress", userAddress);
			session.setAttribute("workedOrg", workedOrg);
			session.setAttribute("careerLevel", careerLevel);
			session.setAttribute("knowledge", knowledgeString);
			session.setAttribute("friends", friendsList);
			session.setAttribute("nationality", nationality);
			session.setAttribute("married", married);
			session.setAttribute("age", age);
			session.setAttribute("driverLicense", driverLicense);
			session.setAttribute("homepage", homepage);
			session.setAttribute("phone", phone);
			session.setAttribute("salary", salary);
			session.setAttribute("title", title);
			session.setAttribute("hobbies", hobbies);
			session.setAttribute("jobsSearched", jobsSearched);
			session.setAttribute("studied", studiedAt);
			
			/*
			String Sgiven=(String) session.getAttribute("givenName");
			String Sfamily=(String) session.getAttribute("familyName");
			String SusrName=(String) session.getAttribute("userName");
			String SusrMail=(String) session.getAttribute("userMail");
			String SusrAddress=(String) session.getAttribute("userAddress");
			//List<Worked> Sworked=  (List<Worked>) session.getAttribute("worked");
			//List<Skill> Sknowledge=(List<Skill>) session.getAttribute("knowledge");
			String family=(String) session.getAttribute("familyName");
			//List<Person> Sfriends=(List<Person>) session.getAttribute("friends");
			String Snationality=(String) session.getAttribute("nationality");
			String Smarried=(String) session.getAttribute("married");
			String Sage=(String) session.getAttribute("age");
			String SdriverLicense=(String) session.getAttribute("driverLicense");
			String Shomepage=(String) session.getAttribute("homepage");
			String Sphone=(String) session.getAttribute("phone");
			String Ssalary=(String) session.getAttribute("salary");
			String Stitle=(String) session.getAttribute("title");
			//ArrayList<?> Shobbies=(ArrayList<?>) session.getAttribute("hobbies");
			//ArrayList<?> SjobsSearched=(ArrayList<?>) session.getAttribute("jobsSearched");
			String Sstudied=(String) session.getAttribute("studied");
			System.out.println(Sgiven);
			System.out.println(Sfamily);
			System.out.println(SusrName);
			System.out.println(SusrMail);
			System.out.println(SusrAddress);
			//System.out.println(Sworked);
			//System.out.println(Sknowledge);
			//System.out.println(Sfriends);
			//System.out.println(Sfriends);
			System.out.println(Snationality);
			System.out.println(Smarried);
			System.out.println(Sage);
			System.out.println(SdriverLicense);
			System.out.println(Shomepage);
			System.out.println(Sphone);
			System.out.println(Ssalary);
			System.out.println(Stitle);
			//System.out.println(Shobbies);
			//System.out.println(SjobsSearched);
			System.out.println(Sstudied);
			
			
			System.out.println(output);*/
		}
		conn.disconnect();
		} 
	}		

=======
<<<<<<< HEAD
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession(true); 
		//response.setContentType("text/html");  
		PrintWriter out = response.getWriter();       
		String n=request.getParameter("usr");  
		String p=request.getParameter("pass");  
		System.out.println(n);     
		System.out.println(p); 
			
		if(validate(n,p)){  
			String url="/viewPerson.jsp";
			RequestDispatcher rd=request.getRequestDispatcher(url);  
		    rd.forward(request,response);  
			//HttpServletResponse.sendRedirect(url);
		}  
		else{  
			out.print("Sorry. Wrong username or password! ");  
		}  	         
		    out.close();  
	
	}
	
	private boolean validate(String username,String password) {
		boolean result=false;
		try{	
			//http://localhost:8080/SorServer/rest/user/login?userName=Examples&userPassword=09709
			String urlString="http://localhost:8080/SorServer/rest/user/login?userName="+ username + "&userPassword=" + password;
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("userName", username);
			conn.setRequestProperty("userPassword", password);
			//System.out.println(conn.getURL());
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			
			String output;
			String id = null;
			String type = null;
			Boolean logged = false;
			
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				ObjectMapper mapper = new ObjectMapper();
				LoginResponse log = mapper.readValue(output, LoginResponse.class);
				id=log.getUserId();
				type=log.getUserType();
				logged=log.getLogedin();
				System.out.println(id);
				
				session.setAttribute("id", id);
				session.setAttribute("type", type);
				session.setAttribute("logged", logged);
				//System.out.println(actualObj.get);
		
			if (logged){	
				result=  true;	
			}else {
				result =false;
			}
			}
			conn.disconnect();
			
			getperson(id);
			
			} catch (MalformedURLException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			}
		return result;	  
		  }
	
	public void getperson(String userId) throws IOException
	{
		String urlString="http://localhost:8080/SorServer/rest/user/viewPerson?userId="+ userId ;
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			ObjectMapper mapper = new ObjectMapper();
			
			Person pers = mapper.readValue(output, Person.class);
			String userName = pers.getUserName();
			String givenName = pers.getGivenName();
			String familyName = pers.getFamilyName();
			String userMail = pers.getUserMail() ;
			String userAddress = pers.getUserAddress() ;
			
			List<Worked> worked = pers.getWorked();
			String workedOrg=worked.get(0).getOrganizationId().toString();
			System.out.println(workedOrg);
			String careerLevel=worked.get(0).getJob().getJobCareerLevel().toString();
			
			
			List<Skill> knowledge = pers.getKnowledge() ;	
			String knowledgeString ="";
			int countk=0;
			for(Skill s:knowledge){
				if (countk==0){
					knowledgeString=knowledgeString + s.getSkillName();
				}else{
					knowledgeString=knowledgeString+"," + s.getSkillName();
				}
				countk++;
				}
			//String knowledgeString =knowledge.toString();
			
			//String skill=knowledgeString.substring(knowledgeString.indexOf("skillName")+10, knowledgeString.indexOf("jobId"));
			
			//String experience=knowledgeString.substring(knowledgeString.indexOf("experience")+11,knowledgeString.indexOf("experience")+13)+"/5";
			
			System.out.println(knowledgeString);
			
			List<Person> friends = pers.getFriends() ;
			String friendsList="";
			int countf=0;
			for(Person p:friends){
				if (countf==0){
				friendsList=friendsList + p.getName();
			}else{
				friendsList=friendsList+"," + p.getName();
			}
				countf++;
			}
				
		//	String friendsList=friends.get(0).getFriends().get(0).getName().toString(); //  .get().getFamilyName();
			System.out.println(friendsList);
			
			String  nationality= pers.getNationality() ;
			String married = pers.getMarried() ;
			String age = pers.getAge() ;
			String driverLicense = pers.getDriverLicense();
			String homepage = pers.getHomepage();
			String phone = pers.getPhone().substring(pers.getPhone().indexOf(" "), pers.getPhone().length());
			String salary = pers.getSalary();
			String title = pers.getTitle();
			List<Hobby> hobbies = pers.getHobbies();
			List<Job> jobsSearched = pers.getJobesSearched();
			
			List<Studied> studied= pers.getStudied();	
			//studied.get(0).getOrganizationId().replace(" ", "&nbsp;");
			String studiedString =studied.toString();
			String studiedAt=studied.get(0).getOrganizationId();//studiedString.substring(studiedString.indexOf("organizationId")+16, studiedString.indexOf("homepage"));
			//studiedAt="\""+studiedAt+"\"";
			System.out.println(studiedAt);
			session.setAttribute("userName", userName);
			session.setAttribute("givenName", givenName);
			session.setAttribute("familyName", familyName);
			session.setAttribute("userMail", userMail);
			session.setAttribute("userAddress", userAddress);
			session.setAttribute("workedOrg", workedOrg);
			session.setAttribute("careerLevel", careerLevel);
			
			session.setAttribute("knowledge", knowledgeString);
			session.setAttribute("friends", friendsList);
			session.setAttribute("nationality", nationality);
			session.setAttribute("married", married);
			session.setAttribute("age", age);
			session.setAttribute("driverLicense", driverLicense);
			session.setAttribute("homepage", homepage);
			session.setAttribute("phone", phone);
			session.setAttribute("salary", salary);
			session.setAttribute("title", title);
			session.setAttribute("hobbies", hobbies);
			session.setAttribute("jobsSearched", jobsSearched);
			session.setAttribute("studied", studiedAt);
			
			
			String Sgiven=(String) session.getAttribute("givenName");
			String Sfamily=(String) session.getAttribute("familyName");
			String SusrName=(String) session.getAttribute("userName");
			String SusrMail=(String) session.getAttribute("userMail");
			String SusrAddress=(String) session.getAttribute("userAddress");
			//List<Worked> Sworked=  (List<Worked>) session.getAttribute("worked");
			//List<Skill> Sknowledge=(List<Skill>) session.getAttribute("knowledge");
			String family=(String) session.getAttribute("familyName");
			//List<Person> Sfriends=(List<Person>) session.getAttribute("friends");
			String Snationality=(String) session.getAttribute("nationality");
			String Smarried=(String) session.getAttribute("married");
			String Sage=(String) session.getAttribute("age");
			String SdriverLicense=(String) session.getAttribute("driverLicense");
			String Shomepage=(String) session.getAttribute("homepage");
			String Sphone=(String) session.getAttribute("phone");
			String Ssalary=(String) session.getAttribute("salary");
			String Stitle=(String) session.getAttribute("title");
			//ArrayList<?> Shobbies=(ArrayList<?>) session.getAttribute("hobbies");
			//ArrayList<?> SjobsSearched=(ArrayList<?>) session.getAttribute("jobsSearched");
			String Sstudied=(String) session.getAttribute("studied");
			System.out.println(Sgiven);
			System.out.println(Sfamily);
			System.out.println(SusrName);
			System.out.println(SusrMail);
			System.out.println(SusrAddress);
			//System.out.println(Sworked);
			//System.out.println(Sknowledge);
			//System.out.println(Sfriends);
			//System.out.println(Sfriends);
			System.out.println(Snationality);
			System.out.println(Smarried);
			System.out.println(Sage);
			System.out.println(SdriverLicense);
			System.out.println(Shomepage);
			System.out.println(Sphone);
			System.out.println(Ssalary);
			System.out.println(Stitle);
			//System.out.println(Shobbies);
			//System.out.println(SjobsSearched);
			System.out.println(Sstudied);
			
			
			System.out.println(output);
		}
		conn.disconnect();
		} 
	}		

=======
<<<<<<< HEAD
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession(true); 
		//response.setContentType("text/html");  
		PrintWriter out = response.getWriter();       
		String n=request.getParameter("usr");  
		String p=request.getParameter("pass");  
		System.out.println(n);     
		System.out.println(p); 
			
		if(validate(n,p)){  
			String url="/viewPerson.jsp";
			RequestDispatcher rd=request.getRequestDispatcher(url);  
		    rd.forward(request,response);  
			//HttpServletResponse.sendRedirect(url);
		}  
		else{  
			out.print("Sorry. Wrong username or password! ");  
		}  	         
		    out.close();  
	
	}
	
	private boolean validate(String username,String password) {
		boolean result=false;
		try{	
			//http://localhost:8080/SorServer/rest/user/login?userName=Examples&userPassword=09709
			String urlString="http://localhost:8080/SorServer/rest/user/login?userName="+ username + "&userPassword=" + password;
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("userName", username);
			conn.setRequestProperty("userPassword", password);
			//System.out.println(conn.getURL());
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			
			String output;
			String id = null;
			String type = null;
			Boolean logged = false;
			
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				ObjectMapper mapper = new ObjectMapper();
				LoginResponse log = mapper.readValue(output, LoginResponse.class);
				id=log.getUserId();
				type=log.getUserType();
				logged=log.getLogedin();
				System.out.println(id);
				
				session.setAttribute("id", id);
				session.setAttribute("type", type);
				session.setAttribute("logged", logged);
				//System.out.println(actualObj.get);
		
			if (logged){	
				result=  true;	
			}else {
				result =false;
			}
			}
			conn.disconnect();
			
			getperson(id);
			
			} catch (MalformedURLException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			}
		return result;	  
		  }
	
	public void getperson(String userId) throws IOException
	{
		String urlString="http://localhost:8080/SorServer/rest/user/viewPerson?userId="+ userId ;
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			ObjectMapper mapper = new ObjectMapper();
			
			Person pers = mapper.readValue(output, Person.class);
			String userName = pers.getUserName();
			String givenName = pers.getGivenName();
			String familyName = pers.getFamilyName();
			String userMail = pers.getUserMail() ;
			String userAddress = pers.getUserAddress() ;
			List<Worked> worked = pers.getWorked();
			List<Skill> knowledge = pers.getKnowledge() ;	
			String knowledgeString =knowledge.toString();
			String skill=knowledgeString.substring(knowledgeString.indexOf("skillName")+10, knowledgeString.indexOf("jobId"));
			String experience=knowledgeString.substring(knowledgeString.indexOf("experience")+11,knowledgeString.indexOf("experience")+13)+"/5";
			
			List<Person> friends = pers.getFriends() ;
			String  nationality= pers.getNationality() ;
			String married = pers.getMarried() ;
			String age = pers.getAge() ;
			String driverLicense = pers.getDriverLicense();
			String homepage = pers.getHomepage();
			String phone = pers.getPhone();
			String salary = pers.getSalary();
			String title = pers.getTitle();
			List<Hobby> hobbies = pers.getHobbies();
			List<Job> jobsSearched = pers.getJobesSearched();
			
			List<Studied> studied= pers.getStudied();	
			String studiedString =studied.toString();
			String studiedAt=studiedString.substring(studiedString.indexOf("organizationId")+16, studiedString.indexOf("homepage"));

			
			session.setAttribute("userName", userName);
			session.setAttribute("givenName", givenName);
			session.setAttribute("familyName", familyName);
			session.setAttribute("userMail", userMail);
			session.setAttribute("userAddress", userAddress);
			session.setAttribute("worked", worked);
			session.setAttribute("knowledge", skill+" "+experience);
			session.setAttribute("friends", friends);
			session.setAttribute("nationality", nationality);
			session.setAttribute("married", married);
			session.setAttribute("age", age);
			session.setAttribute("driverLicense", driverLicense);
			session.setAttribute("homepage", homepage);
			session.setAttribute("phone", phone);
			session.setAttribute("salary", salary);
			session.setAttribute("title", title);
			session.setAttribute("hobbies", hobbies);
			session.setAttribute("jobsSearched", jobsSearched);
			session.setAttribute("studied", studiedAt);
			
			
			String Sgiven=(String) session.getAttribute("givenName");
			String Sfamily=(String) session.getAttribute("familyName");
			String SusrName=(String) session.getAttribute("userName");
			String SusrMail=(String) session.getAttribute("userMail");
			String SusrAddress=(String) session.getAttribute("userAddress");
			//List<Worked> Sworked=  (List<Worked>) session.getAttribute("worked");
			//List<Skill> Sknowledge=(List<Skill>) session.getAttribute("knowledge");
			String family=(String) session.getAttribute("familyName");
			//List<Person> Sfriends=(List<Person>) session.getAttribute("friends");
			String Snationality=(String) session.getAttribute("nationality");
			String Smarried=(String) session.getAttribute("married");
			String Sage=(String) session.getAttribute("age");
			String SdriverLicense=(String) session.getAttribute("driverLicense");
			String Shomepage=(String) session.getAttribute("homepage");
			String Sphone=(String) session.getAttribute("phone");
			String Ssalary=(String) session.getAttribute("salary");
			String Stitle=(String) session.getAttribute("title");
			//ArrayList<?> Shobbies=(ArrayList<?>) session.getAttribute("hobbies");
			//ArrayList<?> SjobsSearched=(ArrayList<?>) session.getAttribute("jobsSearched");
			String Sstudied=(String) session.getAttribute("studied");
			System.out.println(Sgiven);
			System.out.println(Sfamily);
			System.out.println(SusrName);
			System.out.println(SusrMail);
			System.out.println(SusrAddress);
			//System.out.println(Sworked);
			//System.out.println(Sknowledge);
			//System.out.println(Sfriends);
			//System.out.println(Sfriends);
			System.out.println(Snationality);
			System.out.println(Smarried);
			System.out.println(Sage);
			System.out.println(SdriverLicense);
			System.out.println(Shomepage);
			System.out.println(Sphone);
			System.out.println(Ssalary);
			System.out.println(Stitle);
			//System.out.println(Shobbies);
			//System.out.println(SjobsSearched);
			System.out.println(Sstudied);
			
			
			System.out.println(output);
		}
		conn.disconnect();
		} 
	}		

=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String n=request.getParameter("usr");  
		    String p=request.getParameter("pass");  
		    System.out.println(n);     
		    System.out.println(p); 
			
			
			
		   if(validate(n,p)){  
		        RequestDispatcher rd=request.getRequestDispatcher("ViewPerson.html");  
		        rd.forward(request,response);  
		    }  
		    else{  
		        out.print("Sorry username or password error");  
		      //  RequestDispatcher rd=request.getRequestDispatcher("LoginServlet");  
		     //   rd.include(request,response);  
		    }  
		         
		    out.close();  
	
=======
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = new PrintWriter(response.getWriter());
		out.println("<DOCTYPE html>");
		out.println("<!--[if lt IE 7 ]> <html lang='en' class='ie6 ielt8'> <![endif]-->");
		out.println("<!--[if IE 7 ]>    <html lang='en' class='ie7 ielt8'> <![endif]-->");
		out.println("<!--[if IE 8 ]>    <html lang='en' class='ie8'> <![endif]-->");
		out.println("<!--[if (gte IE 9)|!(IE)]><!--> <html lang='en'> <!--<![endif]-->");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>ULink</title>");
		out.println("<link rel='stylesheet' type='text/css' href='style.css' />");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		out.println("	<section id='content'>");
		out.println("		<form method='GET' action='RegisterServlet'>");
		out.println("			<h1>Login</h1>");
		out.println("			<div>");
		out.println("				<input type='text' placeholder='Username' required id='username' />");
		out.println("			</div>");
		out.println("			<div>");
		out.println("				<input type='password' placeholder='Password' required id='password' />");
		out.println("			</div>");
		out.println("			<div>");
		out.println("				<input type='submit' name='login' value='Log in' />");
		out.println("				<input type='submit' name='register' value='New user' />");
		out.println("				<a href='#'>Lost your password?</a>");
		//out.println("				<a href='register.html'>Register</a>");
		out.println("			</div>");
		out.println("		</form><!-- form -->");
		out.println("	</section><!-- content -->");
		out.println("</div><!-- container -->");
		out.println("</body>");
		out.println("</html>");
		out.close();
>>>>>>> origin/master
	}
	private boolean validate(String username,String password) {
		  

				System.out.println("validate");
			  
		  return true;
		  }
	
	}			  
			  
		/*	  URL url = new URL("http://localhost:8080/SorServer/rest/user/login");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("username", username);
				conn.setRequestProperty("password", password);

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
			}

				BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}
				conn.disconnect();

			  } catch (MalformedURLException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();

			  }
		  return false;

	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 
>>>>>>> origin/master
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();       
		    String n=request.getParameter("usr");  
		    String p=request.getParameter("pass");  
		    System.out.println(n);     
		    System.out.println(p); 
			
		    if(validate(n,p)){  
		        RequestDispatcher rd=request.getRequestDispatcher("ViewPerson.html");  
		        rd.forward(request,response);  
		    }  
		    else{  
		        out.print("Sorry. Wrong username or password! ");  
		    }  	         
		    out.close();  
	
	}
<<<<<<< HEAD
	
	private boolean validate(String username,String password) {
		boolean result=false;
		try{	
			//http://localhost:8080/SorServer/rest/user/login?userName=Examples&userPassword=09709
			String urlString="http://localhost:8080/SorServer/rest/user/login?userName="+ username + "&userPassword=" + password;
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
		//	conn.setRequestProperty("userName", username);
			//conn.setRequestProperty("userPassword", password);
			//System.out.println(conn.getURL());
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				ObjectMapper mapper = new ObjectMapper();
				//JsonNode actualObj = mapper.readTree(output);
				LoginResponse staff1 = mapper.readValue(output, LoginResponse.class);
				System.out.println(staff1.getLogedin());
				//System.out.println(actualObj.get);
			String outputOK = "\"logedin\":true";
			if (output.toLowerCase().contains(outputOK.toLowerCase())){	
				result=  true;	
			}else {
				result =false;
			}
			}
			conn.disconnect();
			
			getperson("1");
			
			} catch (MalformedURLException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			}
		return result;	  
		  }
	
	public void getperson(String userId) throws IOException
	{
		String urlString="http://localhost:8080/SorServer/rest/user/viewPerson?userId="+ userId ;
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
		//ObjectMapper mapper = new ObjectMapper();
	//	Person user = mapper.readValue("{\"userId\": \"3\"}", Person.class);

		//System.out.println(user.getName());
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
		conn.disconnect();
		} 
	}		

=======
*/
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master
>>>>>>> origin/master

