import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Files {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String fileName, employeeName;
		double employeeSalary;
		final double TAX = .15;
		System.out.println("What is the name of the file");
		fileName = in.nextLine();
		File file = new File(fileName);
		if (file.exists()) {
			System.out.println("The file " + fileName + " already exists.");
			System.exit(0);
		}
		System.out.println("How many people are working? ");
		int numPeople = in.nextInt();
		in.nextLine();
		try {
			// writing on a file
			PrintWriter outputFile = new PrintWriter(file);
			for (int i = 0; i < numPeople; i++) {
				System.out.println("Enter the name of the employee: ");
				employeeName = in.nextLine();
				System.out.println("Enter the salary of: " + employeeName);
				employeeSalary = in.nextDouble();
				in.nextLine();
				outputFile.println(employeeName + " \n");
				outputFile.println(employeeSalary);
				// System.out.println(employeeName + " \n" + employeeSalary);
			}
			outputFile.close();
			// reading from a file

			System.out.print("Enter the name of a file: ");
			fileName = in.nextLine();
			Scanner inputFile = new Scanner(file);
			while (inputFile.hasNextLine()) {
				String name = inputFile.nextLine();
				double salary = inputFile.nextDouble();
				inputFile.nextLine();
				// calculations
				double biweeklyPay = (salary / 26);
				double taxP = (biweeklyPay * TAX);
				// println to the user
				System.out.printf("Bi-weekly pay of %s is: $%4.2f ", name, biweeklyPay);
				System.out.printf("\nTax of %s is: $%4.2f", name, (biweeklyPay * TAX));
				System.out.printf("\nNet of %s is: $%4.2f ", name, (biweeklyPay - taxP));
				System.out.println("");
			}
			inputFile.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
