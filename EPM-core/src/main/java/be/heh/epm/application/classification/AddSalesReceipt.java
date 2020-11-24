package be.heh.epm.application.classification;

import be.heh.epm.application.Command;
import be.heh.epm.application.employee.Context;
import be.heh.epm.application.employee.Employee;

import java.time.LocalDate;

public class AddSalesReceipt implements Command {
    int empId;
    LocalDate date;
    double saleAmount;
    TimeCard tc;

    public AddSalesReceipt(int empId, LocalDate date, double saleAmount) {
        this.empId = empId;
        this.date = date;
        this.saleAmount = saleAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    @Override
    public void execute() {
        Employee e = Context.emp.getEmployee(empId);
        if(e != null) {
            PaymentClassification pc = e.getPayClassification();
            if (pc instanceof CommissionClassification) {
                CommissionClassification cc = (CommissionClassification) pc;
                SaleReceipt sr = new SaleReceipt(date, saleAmount);
                cc.addSaleReceipt(sr);
                Context.emp.save(e.getEmpID(), e);
            }
            else {
                throw new IllegalStateException("L'employé n'est pas payé en commission.");
            }
        }
        else{
            throw new NullPointerException("Aucun employé correspondant au numéro entré");
        }
    }
}
