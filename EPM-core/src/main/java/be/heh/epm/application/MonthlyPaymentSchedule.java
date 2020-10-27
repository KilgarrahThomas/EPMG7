package be.heh.epm.application;

import java.time.LocalDate;

public class MonthlyPaymentSchedule implements PaymentSchedule {
    // ATTRIBUTES

    // CONSTRUCTOR

    // GETTERS & SETTERS

    // METHODS

    @Override
    public boolean IsDatePay(LocalDate date) {
        return (date.getDayOfMonth() == date.lengthOfMonth());
    }
}
