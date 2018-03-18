import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * This class reads numbers from a file, calculates the mean and standard
 * deviation, and writes the results to a file.
 */
public class StatsDemo {
	public static void main(String[] args) throws IOException {
		double sum = 0; // The sum of the numbers
		int count = 0; // The number of numbers added
		double mean = 0; // The average of the numbers
		double stdDev = 0; // The standard deviation
		String line; // To hold a line from the file
		double difference; // The value and mean difference

		// Create an object of type Scanner
		Scanner keyboard = new Scanner(System.in);
		String filename; // The user input file name
		// Prompt the user and read in the file name

		System.out.println("This program calculates " + "statistics on a file " + "containing a series of numbers");
		System.out.print("Enter the file name: ");
		filename = keyboard.nextLine();

		// Create a FileReader object passing it the filename
		FileReader fReader = new FileReader(filename);
		// Create a BufferedReader object passing FileReader object
		BufferedReader bReader = new BufferedReader(fReader);
		// Perform a priming read to read the first line of the file
		line = bReader.readLine();
		// Loop until you are at the end of the file
		while (line != null) {
			// Convert the line to a double value and add the value to sumvalue to sum
			sum += Double.parseDouble(line);
			// Increment the counter
			count++;
			// Read a new line from the file
			line = bReader.readLine();
		}
		// Close the input file
		bReader.close();
		// Store the calculated mean
		mean = (sum / count);

		// Reconnect FileReader object passing it the filename
		fReader = new FileReader(filename);
		// Reconnect BufferedReader object passing FileReader object
		bReader = new BufferedReader(fReader);
		// Reinitialize the sum of the numbers
		sum = 0;
		// Reinitialize the number of numbers added
		count = 0;
		// Perform a priming read to read the first line of the file
		line = bReader.readLine();
		// Loop until you are at the end of the file
		while (line != null) {
			// Convert the line into a double value and subtract the mean
			difference = (Double.parseDouble(line) - mean);
			// Add the square of the difference to the sum
			sum = Math.pow(difference, 2);
			// Increment the counter
			count++;
			// Read a new line from the file
			line = bReader.readLine();
		}
		// Close the input file
		bReader.close();
		// Store the calculated standard deviation
		stdDev = Math.sqrt((sum / count));

		DecimalFormat threeDecimal = new DecimalFormat("0.000");
		// Create a FileWriter object using "Results.txt"
		FileWriter file = new FileWriter("Results.txt");
		// Create a PrintWriter object passing the FileWriter object
		PrintWriter printFile = new PrintWriter(file);
		// Print the results to the output file
		printFile.println(
				"mean = " + threeDecimal.format(mean) + ", standard deviation = " + threeDecimal.format(stdDev) + ".");
		// Close the output file
		printFile.close();
	}
}