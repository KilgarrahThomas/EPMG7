package be.heh.epm.application;

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

    // METHODS
    public double CalculatePay() {
        // TO DO
        return 0.01;
    }
}
