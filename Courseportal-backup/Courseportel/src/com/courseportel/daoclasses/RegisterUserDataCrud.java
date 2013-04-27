package com.courseportel.daoclasses;

import com.courseportel.dbconnection.DBConnection;
import com.courseportel.dtoclasses.UserRegistrationFormBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterUserDataCrud {

	static Connection conn = null;
	static PreparedStatement pstmt = null;

	public RegisterUserDataCrud() {

	}

	/*
	 * method to save the UserRegistrationFormBean class object data into
	 * database
	 */
	public static boolean save(UserRegistrationFormBean obj) throws Exception {

		/*
		 * prpoerties of UserRegistrationFormBean class
		 */

		String firstname = null;
		String lastname = null;
		String desiredusername = null;
		String email = null;
		String password = null;
		String conformpassword = null;
		String address = null;
		String country = null;
		String state = null;
		java.util.Date dateofbirth = null;
		long mobileno = 0;
		long faxno = 0;
		String qualification = null;
		String role = null;
		String skill = null;
		String status = null;

		/*
		 * fetch all the properties values from UserRegistrationFormBean class
		 * by useing that class object
		 */

		firstname = obj.getFirstname();
		lastname = obj.getLastname();
		desiredusername = obj.getDesiredusername();
		email = obj.getEmail();
		password = obj.getPassword();
		conformpassword = obj.getConformpassword();
		address = obj.getAddress();
		country = obj.getCountry();
		state = obj.getState();
		dateofbirth = obj.getDateofbirth();
		
		/* convert the java.util.Date into java.sql.Date this is why because if want to insert Date 
		 * column in oracle database then we need to convert util.Date into sql.Date other we will get 
		 *    runtime exception */
		
		java.sql.Date sqlDate = new java.sql.Date(dateofbirth.getTime());

		mobileno = obj.getMobileno();
		faxno = obj.getFaxno();
		qualification = obj.getQualification();
		role = obj.getRole();
		skill = obj.getSkill();
		status = obj.getStatus();
		if ((status == null) && (status == ""))
			status = "pending";
		/*
		 * fetch Database connection by useing DBConnection class
		 */

		conn = DBConnection.getDbConnection();
		String insertquery = "insert into userregistration"
				+ "(firstname,lastname,desiredusername,email,password,conformpassword,address,country,state,dateofbirth,mobileno,faxno,qualification,role,skill,status)values"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
               System.out.println("query-----:"+insertquery);
		
		/*
		 * add the UserRegistrationFormBean class properties to
		 * PreparedStatement place holders
		 */

		pstmt = conn.prepareStatement(insertquery);
		pstmt.setString(1, firstname);
		pstmt.setString(2, lastname);
		pstmt.setString(3, email);
		pstmt.setString(4, desiredusername);
		pstmt.setString(5, password);
		pstmt.setString(6, conformpassword);
		pstmt.setString(7, address);
		pstmt.setString(8, country);
		pstmt.setString(9, state);
		pstmt.setDate(10, sqlDate);
		pstmt.setLong(11, mobileno);
		pstmt.setLong(12, faxno);
		pstmt.setString(13, qualification);
		pstmt.setString(14, role);
		pstmt.setString(15, skill);
		pstmt.setString(16, status);

		boolean foo = pstmt.execute();
		if (foo == true) {
			ResultSet rs = pstmt.getResultSet();
			return false;
		} else {
			int i = pstmt.getUpdateCount();
			return true;
		}
	}
}
