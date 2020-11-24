package be.heh.epm.application;

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

    public Employee() {

    }

    public Employee(int idemp, String name, String address) {
    }

    // GETTERS & SETTERS
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

    public String getEmployeeName() {
        return this.name;
    }

    public String getEmployeeAddress() {
        return this.address;
    }

    public void setEmployeeId(int idemp) {
        this.EmpID = idemp;
    }

    public void setEmployeeName(String name) {
        this.name = name;
    }

    public void setEmployeeAddress(String address) {
        this.address = address;
    }

    public Object getEmployeeId() {
        return this.EmpID;
    }
}
