package com.lti.app;

import java.util.Scanner;

public class CRSProfessorMenu {
	
	Scanner scan;
	
	public CRSProfessorMenu(Scanner scan) {
		this.scan = scan;
	}
	
	public void menu() {

		// menu
		while(true)
		{
			System.out.println("\nEnter selection: ");
			System.out.println("1. Add Grades");
			System.out.println("2. View Enrolled Students");
			System.out.println("3. Back (previous menu)");
			System.out.print("\n-> ");
			
			String professorSelection = scan.nextLine();
			if(professorSelection == "") {
				professorSelection = scan.nextLine();
			}
			
			Boolean professor_back = false;
			
			switch(professorSelection.toLowerCase()) {
				case "add grades":
					System.out.println("Adding grades...");
					break;
				case "view enrolled students":
					System.out.println("Viewing enrolled students...");
					break;
				case "back":
					professor_back = true;
					break;
				default:
					System.out.println("Incorrect input, try again");
					continue;
			}
			if(professor_back) break;		//   exit from professor menu while loop
		}
	}
}
