package com.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.google.gson.Gson;

public class UpdateData {
public void Update(int eid,String ename,String edept,String eplace,String ejobtitle) {
		
	 Gson gson=new Gson();
		try {
			String url = "jdbc:mysql://localhost:3306/suma";
			String uname = "root";
			String pwd = "nanirani";
			String Query = "update employeedetails set emp_name=?,emp_dept=?,emp_place=?,emp_jobtitle=? where emp_id=?";
			//String Query2 = "select emp_age from employee where emp_id=?";
			// System.out.println("before calling the driver class");

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pwd);
			PreparedStatement st = con.prepareStatement(Query);
			
			
			// System.out.println("after the prepared stmt");
			// Scanner sc=new Scanner(System.in);
			st.setString(1, ename);
			st.setString(2, edept);
			st.setString(3, eplace);
			st.setString(4, ejobtitle);
			st.setInt(5, eid);
			
			int i = st.executeUpdate();
			
			// {
			// System.out.println("hi...hello");
			
			//System.out.println("The age of employee id " + emp_id + " is changed from " + oldage + " to " + emp_age);
			// HistoryComments(emp_id,emp_age);
			// }
			//updateHistoryComments(emp_id, oldage, emp_age);
		} catch (Exception e) {
			e.printStackTrace();
		}


}
}
