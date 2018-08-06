package com.webservicepgm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.Data.Operations;
import com.Data.EmployeeData;
import com.Data.UpdateData;;
@Path("/Service")
public class Service {
	   @GET 
	   @Path("/users123") 
	   @Produces(MediaType.TEXT_PLAIN)
	   
	   public String getUsers(){ 
	      
	      
	   	   return "hello....";

}
	   
	   @POST
	   @Path("/users")
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   public void createUser(@FormParam("empid") int id,
	      @FormParam("empname") String name,
	      @FormParam("empdept") String dept,
	      @FormParam("empplace") String place,
	      @FormParam("empjobtitle") String jobtitle,
	      @Context HttpServletResponse servletResponse)throws IOException{
		 // StudentData sd=new StudentData(id,name,dept,username,password);
		  Operations op=new Operations();
				String s= op.AddEmployee(id,name,dept,place,jobtitle);
				 /*PrintWriter pr= servletResponse.getWriter();
				 pr.append(s);*/
		   
	   }
	   @GET
	   @Path("/owner") 
	   @Produces(MediaType.TEXT_PLAIN) 
	  
	   public String Data()
	   {
		   
		   String toJSON="";
		   Gson gson=new Gson();
		   
		   try {
				String url = "jdbc:mysql://localhost:3306/suma";
				String uname = "root";
				String pwd = "nanirani";
	            
				String Query = "select * from employeedetails";
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, uname, pwd);
				PreparedStatement st = con.prepareStatement(Query);
				//PrintWriter pr= servletResponse.getWriter();
				 //pr.append("hiiii");
				ResultSet rs = st.executeQuery();
				List<EmployeeData> sd2= new ArrayList<EmployeeData>();

				while (rs.next()) {
					//System.out.println("Welcome");
					sd2.add(new EmployeeData(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
					
					toJSON = gson.toJson(sd2);
					
					
				}
				
				//System.out.println("Converted to json :" + toJSON);
			} catch (Exception e) {
				e.printStackTrace();
			}

		   return toJSON;
		  
	   }
	   
	   @POST
	   @Path("/usersupdate")
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   public void updateData(@FormParam("empid") int id,
			      @FormParam("empname") String name,
			      @FormParam("empdept") String dept,
			      @FormParam("empplace") String place,
			      @FormParam("empjobtitle") String jobtitle,
			      @Context HttpServletRequest request,
			      @Context HttpServletResponse servletResponse)throws IOException{
		   		   UpdateData updt=new UpdateData();
		   updt.Update(id, name, dept, place, jobtitle);
		   
		   
	   }
}
