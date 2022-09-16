package com.lti.app;

import java.util.Scanner;

public class CRSStudentMenu {
	
	Scanner scan;
	
	public CRSStudentMenu(Scanner scan) {
		this.scan = scan;
	}
	
	public void menu() {
		
		// menu
		while(true)
		{
			System.out.println("\nEnter selection: ");
			System.out.println("1. Register for courses");
			System.out.println("2. Add course");
			System.out.println("3. Drop course");
			System.out.println("4. View grades");
			System.out.println("5. Pay fee");
			System.out.println("6. Back (previous menu)");
			System.out.print("\n-> ");
			
			String studentSelection = scan.nextLine();
			if(studentSelection == "") {
				studentSelection = scan.nextLine();
			}
			
			Boolean student_back = false;
			
			switch(studentSelection.toLowerCase()) {
				case "register for courses":
					System.out.println("Registering for courses...");
					break;
				case "add course":
					System.out.println("Adding course...");
					break;
				case "drop course":
					System.out.println("Dropping course");
					break;
				case "view grades":
					System.out.println("Viewing grades...");
					break;
				case "pay fee":
					System.out.println("Paying fee...");
					break;
				case "back":
					student_back = true;
					break;
				default:
					System.out.println("Incorrect input, try again");
					continue;
			}
			
			if(student_back) break;		//   exit from student menu while loop
		}
	}

}
