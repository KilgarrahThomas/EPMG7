package be.heh.epm.application.classification;

import java.time.LocalDate;
import java.util.HashMap;
import be.heh.epm.application.payDay.PayCheck;

public class HourlyClassification implements PaymentClassification {
    // ATTRIBUTES
    private double hoursSalary;
    private HashMap<LocalDate, TimeCard> listTimeCards;

    // CONSTRUCTOR
    public HourlyClassification(double hoursSalary) {
        this.hoursSalary = hoursSalary;
        listTimeCards = new HashMap<LocalDate, TimeCard>();
    }

    // GETTERS & SETTERS
    public void addTimeCard(TimeCard TC) {
        listTimeCards.put(TC.getDate(), TC);
    }

    public TimeCard getTimeCard(LocalDate date) {
        return listTimeCards.get(date);
    }

    // METHODS
    private double CalculSalaryTimeCard(TimeCard TC) {
        double hours = TC.getHours();
        double overtime = Math.max(0.0, hours-8.0);
        double straightTime = hours - overtime;
        return (straightTime + overtime * 1.5) * this.hoursSalary;
    }

    @Override
    public void CalculationSalary(PayCheck pc) {
        double totalpay = 0.0;
        for(TimeCard timeCard :listTimeCards.values()){
            if(PayPeriod(timeCard.getDate(),pc)){
                totalpay += CalculSalaryTimeCard(timeCard);
            }
        }
        pc.setPay(totalpay);
        return;
    }
}
