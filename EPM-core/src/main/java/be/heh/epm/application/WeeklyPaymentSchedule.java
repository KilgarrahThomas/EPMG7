package be.heh.epm.application;

import java.time.LocalDate;

public class WeeklyPaymentSchedule implements PaymentSchedule{
    // ATTRIBUTES

    // CONSTRUCTOR

    // GETTERS & SETTERS

    // METHODS

    @Override
    public boolean IsDatePay(LocalDate date) {
        // Renvoie vrai si le jour est un vendredi
        return (date.getDayOfWeek().getValue() == 5);
    }

    @Override
    public LocalDate GetStartPayPeriod(LocalDate dateEnd) {
        return dateEnd.minusDays(4); // Renvoie le lundi
    }
}
