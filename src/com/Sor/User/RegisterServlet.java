package com.Sor.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
<<<<<<< HEAD
		
=======
<<<<<<< HEAD
		
=======
		response.setContentType("text/html");
		PrintWriter out = new PrintWriter(response.getWriter());
		out.println("<!DOCTYPE html>");
		out.println("<!--[if lt IE 7 ]> <html lang='en' class='ie6 ielt8'> <![endif]-->");
		out.println("<!--[if IE 7 ]>    <html lang='en' class='ie7 ielt8'> <![endif]-->");
		out.println("<!--[if IE 8 ]>    <html lang='en' class='ie8'> <![endif]-->");
		out.println("<!--[if (gte IE 9)|!(IE)]><!--> <html lang='en'> <!--<![endif]-->");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>ULink-Register</title>");
		out.println("<link rel='stylesheet' type='text/css' href='style.css' />");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		out.println("	<section id='content'>");
		out.println("		<form method=get action=''>");
		out.println("			<h1>Login</h1>");
		out.println("			<div>");
		out.println("				<input type='text' placeholder='Username' required id='username' />");
		out.println("			</div>");
		out.println("			<div>");
		out.println("				<input type='password' placeholder='Password' required id='password' />");
		out.println("			</div>");
		out.println("			<div>");
		out.println("				<input type='text' placeholder='Given Name' required id='giveName' />");
		out.println("			</div>");
		out.println("			<div>");
		out.println("				<input type='text' placeholder='Family Name' required id='familyName' />");
		out.println("			</div>");
		out.println("			<div>");
		out.println("				<input type='email' placeholder='Youre email address' required id='email' />");
		out.println("			</div>");
		out.println("			<div>");
		out.println("				<input type='radio' id='uo' name='userType' value='Organization' required />");
		out.println("				<label for = 'uo'>Organization</label>");
		out.println("                <input type='radio' id='up' name='userType' value='Person'  required  />");
		out.println("                <label for = 'up'>Person</label>");
		out.println("					</div>		");			
		out.println("			<div>");
		out.println("				<input type='submit' value='Register' />");
		out.println("				<a href='#'>Lost your password?</a>");
		out.println("				<a href='index.html'>Login</a>");
		out.println("			</div>");
		out.println("		</form><!-- form -->");	
	    out.println("	</section><!-- content -->");
	    out.println("</div><!-- container -->");
	    out.println("</body>");
	    out.println("</html>");
		out.close();		
>>>>>>> origin/master
>>>>>>> origin/master
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
