package com.hybrid.dev.jenny.sandbox;

import java.io.*;
import java.util.ArrayList;
/*Create a 10-row record file using delimiter "^"
Student First Name^Student Last Name^Student Grade(Numeric)
Read file
Parse file
Key: 0-64=F, 65-74=D, 75-79=C, 80-89=B, 90-100=A    
Output 1
             Basic output of all data in numbered list
             Group Title
             1. Full Name
Output 2
             Metrics of Categorize groups --A, B, C, D, F
             Total Rows in File:
             Students with A Grade: 3 */

public class GradesV3 {
	// categorize grade groups
	ArrayList<String> aList = new ArrayList<String>();
	ArrayList<String> bList = new ArrayList<String>();
	ArrayList<String> cList = new ArrayList<String>();
	ArrayList<String> dList = new ArrayList<String>();
	ArrayList<String> fList = new ArrayList<String>();

	public void processFile(){
		readFile();
		System.out.println("=================================================");
		displayStudentGroup();
		System.out.println("=================================================");
	}
	
	public void readFile() {
		String filePath = "C:\\Data\\Java\\CS\\Jenny\\Email\\Grades.txt";
		try {
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			int numStudents = 0;
			//row reads through each row of text file
			for (int row = 1; (line = br.readLine()) != null; row++) {
				numStudents++;
				parseFile(line);
			}
			br.close();
			System.out.println("Total number of Students: " + numStudents);
			
		} catch (Exception e) //using Exception rather than IOEcpetion 
		{ 
			System.out.println("Error check the file location");
			e.printStackTrace();
		} //finally {}  copied from template online; not necessary in code 
	}

	public void parseFile(String line) {
		String[] field = (line + "^^^^^^end").split("\\^"); 
		//no more replaceALL because we only have ^ in the text file
		final String fName = field[0];
		final String lName = field[1];
		final int numericGrade = Integer.parseInt(field[2]);
		final String fullName = fName + " " + lName;

		if (numericGrade >= 90 && numericGrade < 100) {
			aList.add(fullName);
		} else if (numericGrade >= 80 && numericGrade <= 89) {
			bList.add(fullName);
		} else if (numericGrade <= 79 && numericGrade >= 75) {
			cList.add(fullName);
		} else if (numericGrade >= 65 && numericGrade <= 74) {
			dList.add(fullName);
		} else if (numericGrade >= 00 && numericGrade <= 64) {
			fList.add(fullName);
		}
	}

	private static void countLetterGrade(ArrayList<String>gradeList) {
		int count = 0;
		//System.out.println("These are the " + gradeList.size() + " students with :" );
		for (String student : gradeList) {
			count++;
			System.out.println(" " + count + ".)  " + student);
		}		
	} 

	public void displayStudentGroup() {
		System.out.println("Students with A Grade: " + aList.size()  + "" );
		countLetterGrade(aList);
		System.out.println("-------------------------------------------------");
		System.out.println("Students with B Grade: " + bList.size()+ "" );
		countLetterGrade(bList);
		System.out.println("-------------------------------------------------");
		System.out.println("Students with C Grade: " + cList.size()+ "" );
		countLetterGrade(cList);
		System.out.println("-------------------------------------------------");
		System.out.println("Students with D Grade: " + dList.size()+ "" );
		countLetterGrade(dList);
		System.out.println("-------------------------------------------------");
		System.out.println("Students with F Grade: " + fList.size()+ "" );
		countLetterGrade(fList);
	}

	public static void main(String[] args) {
		GradesV3 obj = new GradesV3();
		obj.processFile();
	}

}
