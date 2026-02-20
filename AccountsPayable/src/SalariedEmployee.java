public class SalariedEmployee extends Employee {

    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName,
                            String social, double weeklySalary) {
        super(firstName, lastName, social);
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double getPaymentAmount() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nWeekly Salary: " + weeklySalary +
                "\nPayment Amount: " + getPaymentAmount();
    }
}

