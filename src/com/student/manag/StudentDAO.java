package com.student.manag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
	
	
	public static boolean inserStudentToDB(Student student) {
		
		boolean f= false;
		
		try {
			
			Connection con = CP.createC();
			
			String q = "insert into students(sname,sphone,scity) values(?,?,?)";
			
			PreparedStatement preparedStatement=con.prepareStatement(q);
			
			preparedStatement.setString(1, student.getStudentName());
			preparedStatement.setString(2, student.getStudentPhone());
			preparedStatement.setString(3, student.getStudentCity());
			
			preparedStatement.executeUpdate();
			
			f=true;
			
		}
		catch(Exception e) {
			
			e.getStackTrace();
			
		}
		return f;
		
	}

	public static boolean deleteStudent(int studId) {
		// TODO Auto-generated method stub
		

		boolean f= false;
		
		try {
			
			Connection con = CP.createC();
			
			String q = "delete from students where sid=?";
			
			PreparedStatement preparedStatement=con.prepareStatement(q);
			
			preparedStatement.setInt(1, studId);
			
			
			preparedStatement.executeUpdate();
			
			f=true;
			
		}
		catch(Exception e) {
			
			e.getStackTrace();
			
		}
		return f;
		
	}

	public static void showAllStudent() {



		
		try {
			
			Connection con = CP.createC();
			
			String q = "select * from students";
			
			Statement statement=con.createStatement();
			
			ResultSet set = statement.executeQuery(q);
			
			while(set.next()) {
				
				int id=set.getInt(1);
				String name=set.getString(2);
				String phone=set.getString(3);
				String city=set.getString(4);
				
				System.out.println("Id: " + id);
				System.out.println("Name: " + name);
				System.out.println("Phone: " + phone);
				System.out.println("City: " + city);
				
				System.out.println("+++++++++++++++++++++++++++++++++++++++");
			}
			
			
			
		}
		catch(Exception e) {
			
			e.getStackTrace();
			
		}
		
	}

	public static boolean updateStudent(int studId) {
		
		boolean f= false;
		
		try {
			
			Connection con = CP.createC();
			
			
			String q = "update students set sname=?, sphone=?, scity=? where sid=?";
			
			BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter student new name");
			String name=sb.readLine();
			System.out.println("Enter student new phone");
			String phone=sb.readLine();
			System.out.println("Enter student new city");
			String city=sb.readLine();
			
			PreparedStatement preparedStatement=con.prepareStatement(q);
			
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, phone);
			preparedStatement.setString(3, city);
			preparedStatement.setInt(4, studId);
			
			preparedStatement.executeUpdate();
			
			f=true;
			
		}
		catch(Exception e) {
			
			e.getStackTrace();
			
		}
		return f;
	}

}
