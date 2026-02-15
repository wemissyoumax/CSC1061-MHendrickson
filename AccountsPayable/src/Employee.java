
public class Employee {

    private String firstName;
    private String lastName;
    private String social;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String social) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.social = social;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    public double getPaymentAmount() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + "\n"
                + "Last Name: " + lastName + "\n"
                + "SSN: " + social;
    }
}
