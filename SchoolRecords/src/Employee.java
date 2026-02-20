/**
 * Represents an Employee, which is a type of Person.
 * An employee has an office location, salary, and hire date.
 *
 * @author Student
 * @version 1.0
 */
public class Employee extends Person {

    private String office;
    private double salary;
    private String dateHired;
    
    public Employee() {}

    public Employee(String name, String address, String phoneNumber, 
    		String email, String office, double salary, 
    		String dateHired) {
        super(name, address, phoneNumber, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public String getOffice() { 
    	return office; 
    	}

    public void setOffice(String office) { 
    	this.office = office; 
    	}

    public double getSalary() { 
    	return salary; 
    	}

    public void setSalary(double salary) { 
    	this.salary = salary; 
    	}

    public String getDateHired() { 
    	return dateHired; 
    	}

    public void setDateHired(String dateHired) { 
    	this.dateHired = dateHired; 
    	}

    @Override
    public String toString() {
        return super.toString() +
               "\nOffice: " + office +
               "\nSalary: $" + salary +
               "\nDate Hired: " + dateHired;
    }
}