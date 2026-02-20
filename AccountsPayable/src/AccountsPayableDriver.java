import java.util.Scanner;

public class AccountsPayableDriver {

    public static void printEmployee(Employee emp) {
        System.out.println(emp.toString());
    }

    public static void printEmployeeWithoutToString(Employee emp) {
        System.out.println("First Name: " + emp.getFirstName());
        System.out.println("Last Name: " + emp.getLastName());
        System.out.println("SSN: " + emp.getSocial());
        System.out.println("Payment Amount: " + emp.getPaymentAmount());
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Employee[] payableEmployees = new Employee[6];

        for (int i = 0; i < 6; i++) {

            System.out.println("Enter employee type:");
            System.out.println("1 - Salaried");
            System.out.println("2 - Commission");
            System.out.println("3 - Hourly");
            System.out.println("4 - Base Plus Commission");

            int choice = input.nextInt();
            input.nextLine();

            System.out.print("First Name: ");
            String firstName = input.nextLine();

            System.out.print("Last Name: ");
            String lastName = input.nextLine();

            System.out.print("SSN: ");
            String ssn = input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Weekly Salary: ");
                    double salary = input.nextDouble();
                    payableEmployees[i] =
                            new SalariedEmployee(firstName, lastName, ssn, salary);
                    break;

                case 2:
                    System.out.print("Gross Sales: ");
                    double sales = input.nextDouble();
                    System.out.print("Commission Rate: ");
                    double rate = input.nextDouble();
                    payableEmployees[i] =
                            new CommissionEmployee(firstName, lastName, ssn, sales, rate);
                    break;

                case 3:
                    System.out.print("Hourly Wage: ");
                    double wage = input.nextDouble();
                    System.out.print("Hours Worked: ");
                    double hours = input.nextDouble();
                    payableEmployees[i] =
                            new HourlyEmployee(firstName, lastName, ssn, wage, hours);
                    break;

                case 4:
                    System.out.print("Gross Sales: ");
                    double bsales = input.nextDouble();
                    System.out.print("Commission Rate: ");
                    double brate = input.nextDouble();
                    System.out.print("Base Salary: ");
                    double base = input.nextDouble();
                    payableEmployees[i] =
                            new BasePlusCommissionEmployee(firstName, lastName, ssn,
                                    bsales, brate, base);
                    break;

                default:
                    System.out.println("Invalid choice.");
                    i--;
            }
        }

        // First traversal
        System.out.println("\nEmployee Payments:");
        for (Employee emp : payableEmployees) {
            System.out.println(emp.getFirstName() + " "
                    + emp.getLastName() + " - Payment: "
                    + emp.getPaymentAmount());
        }

        // Increase base salary by 10%
        for (Employee emp : payableEmployees) {
            if (emp instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee baseEmp =
                        (BasePlusCommissionEmployee) emp;
                baseEmp.setBaseSalary(baseEmp.getBaseSalary() * 1.10);
            }
        }

        // Second traversal
        System.out.println("\nAfter 10% Base Salary Increase:");
        for (Employee emp : payableEmployees) {
            System.out.println(emp.getFirstName() + " "
                    + emp.getLastName() + " - Payment: "
                    + emp.getPaymentAmount());
        }

        input.close();
    }
}

