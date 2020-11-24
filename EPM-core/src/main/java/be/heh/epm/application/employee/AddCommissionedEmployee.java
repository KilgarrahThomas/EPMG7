package be.heh.epm.application.employee;

import be.heh.epm.application.classification.CommissionClassification;
import be.heh.epm.application.classification.PaymentClassification;
import be.heh.epm.application.classification.SalariedClassification;
import be.heh.epm.application.schedule.MonthlyPaymentSchedule;
import be.heh.epm.application.schedule.PaymentSchedule;
import be.heh.epm.application.schedule.TwoWeeksPayementSchedule;

public class AddCommissionedEmployee extends AddEmployee{
    double salary;
    double commission;

    public AddCommissionedEmployee(int id, String name, String address, String mail, double salary, double commission) {
        super(id, name, address, mail);
        this.salary = salary;
        this.commission = commission;
    }

    @Override
    public PaymentClassification makePayClassification() {
        return new CommissionClassification(salary, commission);
    }

    @Override
    public PaymentSchedule makePaySchedule() {
        return new TwoWeeksPayementSchedule();
    }
}
