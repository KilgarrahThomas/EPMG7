package be.heh.epm.application.classification;

import be.heh.epm.application.Command;
import be.heh.epm.application.employee.Context;
import be.heh.epm.application.employee.Employee;

import java.time.LocalDate;

public class AddTimeCard implements Command {
    int empId;
    LocalDate date;
    double hours;
    TimeCard tc;

    public AddTimeCard(int empId, LocalDate date, double hours) {
        this.empId = empId;
        this.date = date;
        this.hours = hours;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getHours() {
        return hours;
    }

    @Override
    public void execute() {
        Employee e = Context.emp.getEmployee(empId);
        if(e != null) {
            PaymentClassification pc = e.getPayClassification();
            if (pc instanceof HourlyClassification) {
                HourlyClassification hc = (HourlyClassification) pc;
                tc = new TimeCard(date, hours);
                hc.addTimeCard(tc);
                Context.emp.save(e.getEmpID(), e);
            }
            else {
                throw new IllegalStateException("L'employé n'est pas payé à l'heure");
            }
        }
        else{
            throw new NullPointerException("Aucun employé correspondant au numéro entré");
        }
    }
}
