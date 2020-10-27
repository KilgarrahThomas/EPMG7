package be.heh.epm.application;

public class SalariedClassification implements PaymentClassification {
    // ATTRIBUTES
    private double salary;

    // CONSTRUCTOR

    public SalariedClassification(double salary) {
        this.salary = salary;
    }

    // GETTERS & SETTERS

    // METHODS

    @Override
    public double CalculationSalary() {
        return this.salary;
    }
}
