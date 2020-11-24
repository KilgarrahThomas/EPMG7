package be.heh.epm.application.classification;

import be.heh.epm.application.payDay.PayCheck;

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
