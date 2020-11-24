package be.heh.epm.application.employee;

import be.heh.epm.application.classification.PaymentClassification;
import be.heh.epm.application.classification.SalariedClassification;
import be.heh.epm.application.schedule.MonthlyPaymentSchedule;
import be.heh.epm.application.schedule.PaymentSchedule;

public class AddSalariedEmployee extends AddEmployee{
    double salary;

    public AddSalariedEmployee(int id, String name, String address, String mail, double salary) {
        super(id, name, address, mail);
        this.salary = salary;
    }

    @Override
    public PaymentClassification makePayClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    public PaymentSchedule makePaySchedule() {
        return new MonthlyPaymentSchedule();
    }
}
