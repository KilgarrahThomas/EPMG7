package be.heh.epm.application.employee;

import be.heh.epm.application.classification.HourlyClassification;
import be.heh.epm.application.classification.PaymentClassification;
import be.heh.epm.application.classification.SalariedClassification;
import be.heh.epm.application.schedule.MonthlyPaymentSchedule;
import be.heh.epm.application.schedule.PaymentSchedule;
import be.heh.epm.application.schedule.WeeklyPaymentSchedule;

public class AddHourlyEmployee extends AddEmployee{
    double salary;

    public AddHourlyEmployee(int id, String name, String address, String mail, double salary) {
        super(id, name, address, mail);
        this.salary = salary;
    }

    @Override
    public PaymentClassification makePayClassification() {
        return new HourlyClassification(salary);
    }

    @Override
    public PaymentSchedule makePaySchedule() {
        return new WeeklyPaymentSchedule();
    }
}
