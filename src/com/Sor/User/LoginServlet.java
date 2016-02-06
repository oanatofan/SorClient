package com.Sor.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Sor.Models.LoginResponse;
import com.Sor.Models.Person;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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


