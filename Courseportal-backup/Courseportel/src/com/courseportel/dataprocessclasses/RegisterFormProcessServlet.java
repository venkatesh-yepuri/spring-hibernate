package com.courseportel.dataprocessclasses;

import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.courseportel.dtoclasses.UserRegistrationFormBean;
import com.courseportel.daoclasses.RegisterUserDataCrud;

public class RegisterFormProcessServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() {
		System.out.println("from init method");
	}

	public RegisterFormProcessServlet() {
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		
			response.setContentType("text/html;charset=UTF-8");
			UserRegistrationFormBean urfbObject = new UserRegistrationFormBean();
			Date convertedDate = null;
			long mobileno=0;
			int faxno=0;
			boolean val=false;
			
			/*
			 * converting String form field values into long and int values(regarding phone number and fax number)
			 * and coverting string date field into java.util.Date type
			 * */
			mobileno=Long.parseLong(request.getParameter("mobileno"));
			faxno=Integer.parseInt(request.getParameter("faxno"));
			String dateString = request.getParameter("date");
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		    try{
		          convertedDate = dateFormat.parse(dateString);
		      }catch(Exception e)
		      {
		    	  e.printStackTrace();
		      }
           /*
            * binding form data into UserRegistrationFormBean class object   
            */ 
		    
			urfbObject.setFirstname(request.getParameter("firstname"));
			urfbObject.setLastname(request.getParameter("lastname"));
			urfbObject.setEmail(request.getParameter("email"));
			urfbObject.setDesiredusername(request.getParameter("desiredusername"));
			urfbObject.setPassword(request.getParameter("password"));
			urfbObject.setConformpassword(request.getParameter("password"));
			urfbObject.setAddress(request.getParameter("address"));
			urfbObject.setCountry(request.getParameter("country"));
			urfbObject.setState(request.getParameter("state"));
			urfbObject.setDateofbirth(convertedDate);
			urfbObject.setMobileno(mobileno);
			urfbObject.setFaxno(faxno);
			urfbObject.setQualification(request.getParameter("qualification"));
			urfbObject.setRole(request.getParameter("role"));
			urfbObject.setSkill(request.getParameter("skillsummary"));
			
			/*
			 * send the UserRegistrationFormBean class object to save into database
			 * */
			
			try{
			val = RegisterUserDataCrud.save(urfbObject);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if(val == true)
			{
				System.out.println("recordis inserted");
			}
			else
			{
				System.out.println("---------select-----------");
			}
	}
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	public String getServletInfo() {
		return "Short description";
	}
}
