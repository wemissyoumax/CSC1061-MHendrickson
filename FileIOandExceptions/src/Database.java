import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Database {
	// csv = comma separated values
	private File outFile = new File("Database.csv");
	PrintWriter printer;
	Scanner reader;

	public Database() {

		try {
			if (!outFile.exists()) {
				outFile.createNewFile();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Could not create database.");
			System.exit(-1);
		}
		try {
			printer = new PrintWriter(outFile.getName());
			reader = new Scanner(outFile);
		}

		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("Database could not be found.");
			System.exit(-1);
		}
	}

	public void write(GeometricObject shape) {
		printer.print(shape.getClass().getName());
		printer.print("," + shape.getColor());
		printer.print("," + shape.isFilled());
		if (shape instanceof Circle) {
			printer.print("," + ((Circle) shape).getRadius());
		}
		if (shape instanceof Rectangle) {
			Rectangle rect = (Rectangle) shape;
			printer.print("," + rect.getHeight() + rect.getWidth());
		}
		printer.println();
		printer.flush();
	}
	public GeometricObject readObject() {
		String line;
		if(reader.hasNextLine()) {
			line = reader.nextLine();
		}
		else {
			return null;
		}
		
		String[] tokens = line.split(",");
		GeometricObject obj = null;
		if(tokens[0].equals("Cirlce")) {
			obj = new Circle(tokens[1].trim(),
					Boolean.parseBoolean(tokens[2]),
					Double.parseDouble(tokens[3]));
		}
	}

}
