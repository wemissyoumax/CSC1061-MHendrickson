import java.util.ArrayList;

public class TestSchoolRecords {

    public static void main(String[] args) {

        // Create Database object (creates file if it doesn't exist)
        Database db = new Database();

        // Create 2 Student objects
        Student student1 = new Student();
        student1.setName("Alice Johnson");
        student1.setAddress("123 Maple St, Springfield");
        student1.setPhoneNumber("555-1234");
        student1.setEmail("alice.johnson@frcc.edu");
        student1.setStatus("freshman");

        Student student2 = new Student();
        student2.setName("Bob Smith");
        student2.setAddress("456 Oak Ave, Shelbyville");
        student2.setPhoneNumber("555-5678");
        student2.setEmail("bob.smith@frcc.edu");
        student2.setStatus("junior");

        // Create 2 Faculty objects
        Faculty faculty1 = new Faculty();
        faculty1.setName("Dr. Carol White");
        faculty1.setAddress("789 Elm Rd, Springfield");
        faculty1.setPhoneNumber("555-9101");
        faculty1.setEmail("carol.white@frcc.edu");
        faculty1.setOffice("Room 201");
        faculty1.setSalary(85000.00);
        faculty1.setDateHired("2015-08-15");
        faculty1.setOfficeHours("Mon/Wed 10am-12pm");
        faculty1.setRank("senior");

        Faculty faculty2 = new Faculty();
        faculty2.setName("Dr. David Brown");
        faculty2.setAddress("321 Pine St, Springfield");
        faculty2.setPhoneNumber("555-1121");
        faculty2.setEmail("david.brown@frcc.edu");
        faculty2.setOffice("Room 305");
        faculty2.setSalary(72000.00);
        faculty2.setDateHired("2020-01-10");
        faculty2.setOfficeHours("Tue/Thu 1pm-3pm");
        faculty2.setRank("junior");

        // Create 2 Staff objects
        Staff staff1 = new Staff();
        staff1.setName("Eve Davis");
        staff1.setAddress("654 Birch Blvd, Shelbyville");
        staff1.setPhoneNumber("555-3141");
        staff1.setEmail("eve.davis@psd.edu");
        staff1.setOffice("Admin Office");
        staff1.setSalary(45000.00);
        staff1.setDateHired("2018-03-22");
        staff1.setTitle("Administrative Coordinator");

        Staff staff2 = new Staff();
        staff2.setName("Frank Miller");
        staff2.setAddress("987 Cedar Ln, Springfield");
        staff2.setPhoneNumber("555-5161");
        staff2.setEmail("frank.miller@psd.edu");
        staff2.setOffice("IT Department");
        staff2.setSalary(52000.00);
        staff2.setDateHired("2019-07-01");
        staff2.setTitle("IT Support Specialist");

        // Write all 6 persons to the database file
        db.writePerson(student1);
        db.writePerson(student2);
        db.writePerson(faculty1);
        db.writePerson(faculty2);
        db.writePerson(staff1);
        db.writePerson(staff2);

        // Read all persons back from the database file
        ArrayList<Person> persons = db.readDatabase();

        // Print each person using toString() and an enhanced for loop
        for (Person p : persons) {
            System.out.println("[ " + p.getClass().getSimpleName() + " ]");
            System.out.println(p.toString());
            System.out.println();
        }
    }
}