package be.heh.epm.application.employee;

import be.heh.epm.application.Command;
import be.heh.epm.application.payMethod.MailMethod;
import be.heh.epm.application.classification.PaymentClassification;
import be.heh.epm.application.schedule.PaymentSchedule;

public abstract class AddEmployee implements Command {
    int id;
    private String name;
    private String address;
    private String mail;
    protected Employee employee;

    public AddEmployee(int id, String name, String address, String mail) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mail = mail;
        employee = new Employee(id, name, address, mail);
    }

    public abstract PaymentClassification makePayClassification();

    public abstract PaymentSchedule makePaySchedule();

    @Override
    public void execute() {
        employee.setPayClassification(makePayClassification());
        employee.setPaySchedule(makePaySchedule());
        employee.setPayMethod(new MailMethod(employee.getMail()));
        Context.emp.save(employee.getEmpID(), employee);
    }
}
