package be.heh.epm.application.employee;

import be.heh.epm.application.classification.PaymentClassification;
import be.heh.epm.application.payMethod.PaymentMethod;
import be.heh.epm.application.schedule.PaymentSchedule;
import be.heh.epm.domain.PayCheck;

import java.time.LocalDate;

public class Employee {

    // ATTRIBUTES
    private int EmpID;
    private String name;
    private String address;
    private String mail;
    private PaymentMethod transaction;
    private PaymentSchedule payDay;
    private PaymentClassification payClassification;

    // CONSTRUCTOR
    public Employee(int id, String name, String address, String mail) {
        this.EmpID = id;
        this.name = name;
        this.address = address;
        this.mail = mail;
    }

    // GETTERS & SETTERS
    public int getEmpID() {
        return EmpID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PaymentMethod getPayMethod() {
        return transaction;
    }

    public void setPayMethod(PaymentMethod transaction) {
        this.transaction = transaction;
    }

    public PaymentSchedule getPaySchedule() {
        return payDay;
    }

    public void setPaySchedule(PaymentSchedule payDay) {
        this.payDay = payDay;
    }

    public PaymentClassification getPayClassification() {
        return payClassification;
    }

    public void setPayClassification(PaymentClassification payClassification) {
        this.payClassification = payClassification;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    // METHODS
    public void payDay(PayCheck pc) {
        if(payDay.IsDatePay(pc.getDate())) {
            pc.setPayPayPeriodStart(payDay.GetStartPayPeriod(pc.getDate()));
            payClassification.CalculationSalary(pc);
        }
        return;
    }

    public boolean isDatePay(LocalDate date) {
        return payDay.IsDatePay(date);
    }
}
