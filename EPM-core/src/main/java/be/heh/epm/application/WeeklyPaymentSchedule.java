package be.heh.epm.application;

import java.time.LocalDate;

public class WeeklyPaymentSchedule implements PaymentSchedule{
    // ATTRIBUTES

    // CONSTRUCTOR

    // GETTERS & SETTERS

    // METHODS

    @Override
    public boolean IsDatePay(LocalDate date) {
        return (date.getDayOfWeek().getValue() == 5);
    }
}
