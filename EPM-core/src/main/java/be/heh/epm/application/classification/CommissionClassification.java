package be.heh.epm.application.classification;

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

    public SaleReceipt geSaleReceipt(LocalDate date) {
        return listSaleReceipt.get(date);
    }

    // METHODS

    private double CalculCommission(SaleReceipt SR){

        return (this.commission * SR.getSaleAmount())/100;
    }

    @Override
    public void CalculationSalary(PayCheck pc) {
        double totalpay = this.salary;
        for(SaleReceipt saleReceipt : listSaleReceipt.values()){
            if(PayPeriod(saleReceipt.getDate(), pc)){
                totalpay += CalculCommission(saleReceipt);
            }
        }
        pc.setPay(totalpay);
        return;
    }
}
