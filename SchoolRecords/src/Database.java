import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {

    public static final String FILE_NAME = "PersonDatabase.txt";

    public Database() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error creating database file: " + e.getMessage());
        }
    }

    public void writePerson(Person person) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true));

            writer.println("CLASS:" + person.getClass().getSimpleName());
            writer.println("Name:" + person.getName());
            writer.println("Address:" + person.getAddress());
            writer.println("Phone:" + person.getPhoneNumber());
            writer.println("Email:" + person.getEmail());

            if (person instanceof Student) {
                Student s = (Student) person;
                writer.println("Status:" + s.getStatus());
            } else if (person instanceof Faculty) {
                Faculty f = (Faculty) person;
                writer.println("Office:" + f.getOffice());
                writer.println("Salary:" + f.getSalary());
                writer.println("DateHired:" + f.getDateHired());
                writer.println("OfficeHours:" + f.getOfficeHours());
                writer.println("Rank:" + f.getRank());
            } else if (person instanceof Staff) {
                Staff st = (Staff) person;
                writer.println("Office:" + st.getOffice());
                writer.println("Salary:" + st.getSalary());
                writer.println("DateHired:" + st.getDateHired());
                writer.println("Title:" + st.getTitle());
            }

            writer.println("---");
            writer.close();

        } catch (IOException e) {
            System.out.println("Error writing to database: " + e.getMessage());
        }
    }

    public ArrayList<Person> readDatabase() {
        ArrayList<Person> persons = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(FILE_NAME));

            while (scanner.hasNextLine()) {
                String className = scanner.nextLine().substring(6); // Remove "CLASS:"
                String name      = scanner.nextLine().substring(5); // Remove "Name:"
                String address   = scanner.nextLine().substring(8); // Remove "Address:"
                String phone     = scanner.nextLine().substring(6); // Remove "Phone:"
                String email     = scanner.nextLine().substring(6); // Remove "Email:"

                if (className.equals("Student")) {
                    String status = scanner.nextLine().substring(7); // Remove "Status:"
                    persons.add(new Student(name, address, phone, email, status));

                } else if (className.equals("Faculty")) {
                    String office      = scanner.nextLine().substring(7);  // Remove "Office:"
                    double salary      = Double.parseDouble(scanner.nextLine().substring(7)); // Remove "Salary:"
                    String dateHired   = scanner.nextLine().substring(10); // Remove "DateHired:"
                    String officeHours = scanner.nextLine().substring(12); // Remove "OfficeHours:"
                    String rank        = scanner.nextLine().substring(5);  // Remove "Rank:"
                    persons.add(new Faculty(name, address, phone, email, office, salary, dateHired, officeHours, rank));

                } else if (className.equals("Staff")) {
                    String office    = scanner.nextLine().substring(7);  // Remove "Office:"
                    double salary    = Double.parseDouble(scanner.nextLine().substring(7)); // Remove "Salary:"
                    String dateHired = scanner.nextLine().substring(10); // Remove "DateHired:"
                    String title     = scanner.nextLine().substring(6);  // Remove "Title:"
                    persons.add(new Staff(name, address, phone, email, office, salary, dateHired, title));
                }

                scanner.nextLine(); 
            }

            scanner.close();

        } catch (IOException e) {
            System.out.println("Error reading database: " + e.getMessage());
        }

        return persons;
    }
}