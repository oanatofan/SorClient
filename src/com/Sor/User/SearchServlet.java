package com.Sor.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.Sor.Models.Hobby;
import com.Sor.Models.Job;
import com.Sor.Models.Person;
import com.Sor.Models.Skill;
import com.Sor.Models.Studied;
import com.Sor.Models.Worked;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	public class l{
		private String v1;
		private String v2;
		public String getV2(){return v2;}
		public String getV1(){return v1;}
		public void setV1(String v1){this.v1=v1;}
		public void setV2(String v2){this.v2=v2;}
	}
	private static final long serialVersionUID = 1L;
	private HttpSession session; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		session=request.getSession(false);
		String userId=(String) session.getAttribute("id");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String urlString="http://sorserver.eu-gb.mybluemix.net/rest/search/suggestPersons?userId="+ userId ;
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
			System.out.println(output);
			List<Person> myObjects = mapper.readValue(output, new TypeReference<List<Person>>(){});
			ArrayList<l> ar=new ArrayList<l>();
			
			for(Person p:myObjects){
				l str=new l();
				str.v1=p.getName()+" is "+p.getAge()+", works at "+p.getWorked().get(0).getOrganizationId()+
						   " on " + p.getKnowledge().get(0).getSkillName()+" and has "+p.getFriends().size()+" friends. ";
				str.v2=p.getUserId();
				ar.add(str);
			}
			session.setAttribute("list", ar);
			
			String atr="atr";
			int count=0;
			while(count<ar.size()){
			for (l st:ar){
				count++;
				System.out.println(count);
				String atrName=atr+count;
				System.out.println(atrName);
				System.out.println(st.v1);
				session.setAttribute(atrName,st);
				
			}}
			RequestDispatcher rd=request.getRequestDispatcher("/FriendsSuggest.jsp");  
		    rd.forward(request,response);  
		}
		conn.disconnect();
		} 
		
		

=======
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("x");
	}
>>>>>>> origin/master

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
