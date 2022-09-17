package com.lti.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.bean.Professor;
import com.lti.bean.Student;

public class CRSProfessorMenu {
	
	private Scanner scan;
	private String username;
	
	// default data - initial in-memory data
	private Professor rubin = new Professor(100, "Rubin", "Biology");
	private Professor axel = new Professor(200, "Axel", "Psychology");
	private Professor nelson = new Professor(300, "Nelson", "Economics");
	private int professorMaxId = 300;
	private List<Professor> professors = new ArrayList<Professor>();
	private Professor professor;
	
	public CRSProfessorMenu(Scanner scan, String username) {
		
		this.scan = scan;
		this.username = username;
		
		professor = new Professor();
		
		professors.add(rubin);
		professors.add(axel);
		professors.add(nelson);
	}
	
	public void menu() {
		
		// use existing professor or create new 
		switch(username) {
			case "thomas": 
				professor = rubin;
				break;
			case "abigail":
				professor = axel;
				break;
			case "tej":
				professor = nelson;
			default:
				professor = new Professor(professorMaxId + 1, username, "undefined");				
		}
		
		professors.add(professor);

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
