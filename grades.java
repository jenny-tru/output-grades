package javasandbox;

import java.io.*;
import java.util.ArrayList;

public class GradesV1 {
	//categorize grade groups
	ArrayList<String> aList = new ArrayList<String>();
	ArrayList<String> bList = new ArrayList<String>();
	ArrayList<String> cList = new ArrayList<String>();
	ArrayList<String> dList = new ArrayList<String>();
	ArrayList<String> fList = new ArrayList<String>();

	public void readMe() {
		// open the file
		String filePath = "C:\\Data\\Java\\CS\\Jenny\\Email\\Grades.txt";
		try {
			// read file
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			int rows = 0;
			//amount of rows in file
			for (int fileRow = 1; (line = br.readLine()) != null; fileRow++) {
				rows++;
				parseFile(line);
			}br.close();
			displayStudentGroup();

			System.out.println("Output 2");
			System.out.println("----------------------------------------");
			System.out.println("Students with A Grade: " + aList.size());
			System.out.println("Students with B Grade: " + bList.size());
			System.out.println("Students with C Grade: " + cList.size());
			System.out.println("Students with D Grade: " + dList.size());
			System.out.println("Students with F Grade: " + fList.size());
			System.out.println("----------------------------------------");
			System.out.println("Total rows in file: " + rows);
			System.out.println("----------------------------------------");
			System.out.println("----------------------------------------");
		} catch (IOException E) {
			System.out.println("Error check the file location");
			E.printStackTrace();
		} 
	}

	public void parseFile(String line) {
		String[] field = (line.replaceAll("\"", "") + "^^^^^^^^^^^^^^^^^^^end").split("\\^");
		// System.out.println(line);
		final String fName = field[0];
		final String lName = field[1];
		// System.out.println(fName);
		// System.out.println(lName);

		final int numericGrade = Integer.parseInt(field[2]);
		String fullName = fName + " " + lName;
		// System.out.println(fullName);

		if (numericGrade >= 90 && numericGrade < 100) {
			// System.out.println("A");
			aList.add(fullName);
		}
		if (numericGrade >= 80 && numericGrade <= 89) {
			// System.out.println("B");
			bList.add(fullName);
		}
		if (numericGrade <= 79 && numericGrade >= 75) {
			// System.out.println("C");
			cList.add(fullName);
		}
		if (numericGrade >= 65 && numericGrade <= 74) {
			// System.out.println("D");
			dList.add(fullName);
		}
		if (numericGrade >= 00 && numericGrade <= 64) {
			// System.out.println("F");
			fList.add(fullName);
		}
	}

	private void displayStudentGroup() {
		System.out.println("Output 1");
		System.out.println("----------------------------------------");
		// output full name from each list
		int countA = 0;
		System.out.println("These are the A Students:");
		for (String studentA : this.aList) {
			countA++;
			System.out.println(" " + countA + ".)  " + studentA);
		}
		System.out.println("----------------------------------------");

		int countB = 0;
		System.out.println("These are the B Students:");
		for (String studentB : this.bList) {
			countB++;
			System.out.println(" " + countB + ".)  " + studentB);
		}
		System.out.println("----------------------------------------");

		int countC = 0;
		System.out.println("These are the C Students:");
		for (String studentC : this.cList) {
			countC++;
			System.out.println(" " + countC + ".)  " + studentC);
		}
		System.out.println("----------------------------------------");

		int countD = 0;
		System.out.println("These are the D Students:");
		for (String studentD : this.dList) {
			countD++;
			System.out.println(" " + countD + ".)  " + studentD);
		}
		System.out.println("----------------------------------------");

		int countF = 0;
		System.out.println("These are the F Students:");
		for (String studentF : this.fList) {
			countF++;
			System.out.println(" " + countF + ".)  " + studentF);
		}
		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");
	}

	public static void main(String[] args) {
		GradesV1 obj = new GradesV1();
		obj.readMe();
	}

}

