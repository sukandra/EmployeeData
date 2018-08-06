package com.Data;

public class EmployeeData {

	private int emp_id;
	private String emp_name;
	private String emp_dept;
	private String emp_place;
	private String emp_jobtitle;
	
	
	public EmployeeData(int emp_id, String emp_name, String emp_dept, String emp_place, String emp_jobtitle) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_dept = emp_dept;
		this.emp_place = emp_place;
		this.emp_jobtitle = emp_jobtitle;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_dept() {
		return emp_dept;
	}
	public void setEmp_dept(String emp_dept) {
		this.emp_dept = emp_dept;
	}
	public String getEmp_place() {
		return emp_place;
	}
	public void setEmp_place(String emp_place) {
		this.emp_place = emp_place;
	}
	public String getEmp_jobtitle() {
		return emp_jobtitle;
	}
	public void setEmp_jobtitle(String emp_jobtitle) {
		this.emp_jobtitle = emp_jobtitle;
	}
}
