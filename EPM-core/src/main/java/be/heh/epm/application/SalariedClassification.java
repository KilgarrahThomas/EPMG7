package be.heh.epm.application;

import be.heh.epm.domain.PayCheck;

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
    public void CalculationSalary(PayCheck pc) {
        pc.setPay(this.salary);
        return;
    }
}
