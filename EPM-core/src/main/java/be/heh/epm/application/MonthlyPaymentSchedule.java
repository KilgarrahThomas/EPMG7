package be.heh.epm.application;

import java.time.LocalDate;

public class MonthlyPaymentSchedule implements PaymentSchedule {
    // ATTRIBUTES

    // CONSTRUCTOR

    // GETTERS & SETTERS

    // METHODS

    @Override
    public boolean IsDatePay(LocalDate date) {
        boolean flag = false;
        if ((date.getDayOfMonth() == date.lengthOfMonth()) && (date.getDayOfWeek().getValue() < 6)) {
            flag = true;
        }
        else if((date.getDayOfMonth() == (date.lengthOfMonth()-1)) && (date.getDayOfWeek().getValue() < 6)) {
            flag = true;
        }
        else if((date.getDayOfMonth() == (date.lengthOfMonth()-2)) && (date.getDayOfWeek().getValue() < 6)) {
            flag = true;
        }

        return flag;
    }
}
