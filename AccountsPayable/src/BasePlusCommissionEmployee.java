public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName,
                                      String social,
                                      double grossSales, double commissionRate,
                                      double baseSalary) {
        super(firstName, lastName, social, grossSales, commissionRate);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double getPaymentAmount() {
        return baseSalary + super.getPaymentAmount();
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nBase Salary: " + baseSalary
                + "\nTotal Payment: " + getPaymentAmount();
    }
}

