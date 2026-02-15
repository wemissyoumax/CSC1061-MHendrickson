public class HourlyEmployee extends Employee {

    private double hourlyWage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName,
                          String social,
                          double hourlyWage, double hours) {
        super(firstName, lastName, social);
        this.hourlyWage = hourlyWage;
        this.hours = hours;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public double getPaymentAmount() {
        return hourlyWage * hours;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nHourly Wage: " + hourlyWage
                + "\nHours Worked: " + hours
                + "\nPayment Amount: " + getPaymentAmount();
    }
}
