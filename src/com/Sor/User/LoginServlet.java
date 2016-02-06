package com.Sor.User;

import java.io.IOException;
import java.io.PrintWriter;

<<<<<<< HEAD
import javax.servlet.RequestDispatcher;
=======
>>>>>>> origin/master
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
*/

