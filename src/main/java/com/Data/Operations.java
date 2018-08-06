package com.Data;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.google.gson.Gson;

public class Operations {
	public String AddEmployee(int eid,String ename,String edept,String eplace,String ejobtitle)
	{
		String exception="";
		 String toJSON="";
		   Gson gson=new Gson();
	try {
		Scanner sc= new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/suma";
		String uname = "root";
		String pwd = "nanirani";
		String Query = "insert into employeedetails values(?,?,?,?,?)";
        
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pwd);
		PreparedStatement st = con.prepareStatement(Query);
		
		
		st.setInt(1,eid);
		
		st.setString(2, ename);
		
		st.setString(3, edept);
		st.setString(4, eplace);
		st.setString(5, ejobtitle);
		int i = st.executeUpdate();
		
		int userinput=sc.nextInt();
		
		if(userinput==1)
		{}
		else
		{
			System.exit(0);
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Error Message is" +e);
		exception=e.toString();
		toJSON=gson.toJson(exception);
		System.out.println("errrr :" +exception);
		System.out.println("json conversion :" + toJSON);
		//return exception;
		//return exception;
		/*StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    e.printStackTrace(pw);
	    pw.flush();
	    String stackTrace = sw.toString();*/
	}
	System.out.println("....." +toJSON);
   return toJSON;
   
}


}
