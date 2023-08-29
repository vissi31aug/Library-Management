package com.student.manag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartJava {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println("Welcomoe to Student Managaement App");
		BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
		//String str = sb.readLine();
		
		while(true) {
		
		System.out.println("Press 1 to insert student");
		System.out.println("Press 2 to delete student");
		System.out.println("Press 3 to display student");
		System.out.println("Press 4 to update student");
		System.out.println("Press 5 to exit");
		
		
		int input = Integer.parseInt(sb.readLine());
		
		if(input == 1) {
			
			System.out.println("Enter the name");
			String name=sb.readLine();
			
			System.out.println("Enter the phone number");
			String phone=sb.readLine();
			
			System.out.println("Enter the city");
			String city=sb.readLine(); 
		
			
			Student student= new Student(name,phone,city);
			boolean ans=StudentDAO.inserStudentToDB(student);
			
			if(ans) {
				System.out.println("Student added successfully..........");	
			}
			else {
				System.out.println("Something went wrong...");
			}
			System.out.println(student);
		}
		
		else if( input == 2) {
			
			System.out.println("Enter the student ID to delete");
			
			int studId = Integer.parseInt(sb.readLine());
			boolean ans=StudentDAO.deleteStudent(studId);
			if(ans) {
				System.out.println("Student deleted successfully..........");	
			}
			else {
				System.out.println("Something went wrong...");
			}
			
			
		}
		else if(input == 3) {
			
			StudentDAO.showAllStudent();
					
		}
		else if(input==4) {
			
            System.out.println("Enter the student ID to delete");
			
			int studId = Integer.parseInt(sb.readLine());
			boolean ans=StudentDAO.updateStudent(studId);
			if(ans) {
				System.out.println("Student updated successfully..........");	
			}
			else {
				System.out.println("Something went wrong...");
			}
		}
		else  if (input == 5){
			break;
			
		}
		
		else {
			
			
		}
		
		
		}
		
        System.out.println("Thank you for using my App");
	}

}
