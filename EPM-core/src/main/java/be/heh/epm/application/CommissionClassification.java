package be.heh.epm.application;

import be.heh.epm.domain.PayCheck;

import java.time.LocalDate;
import java.util.HashMap;

public class CommissionClassification implements PaymentClassification {
    // ATTRIBUTES
    private double salary;
    private double commission;
    private HashMap<LocalDate, SaleReceipt> listSaleReceipt = new HashMap<LocalDate, SaleReceipt>();

    // CONSTRUCTOR
    public CommissionClassification(double salary, double commission) {
        this.salary = salary;
        this.commission = commission;
    }

    // GETTERS & SETTERS
    public void addSaleReceipt(SaleReceipt salesReceipt)
    {
        this.listSaleReceipt.put(salesReceipt.getDate(), salesReceipt);
    }

    // METHODS

    @Override
    public void CalculationSalary(PayCheck pc) {
        double totalpay = this.salary;

        pc.setPay(totalpay);
        return;
    }
}
