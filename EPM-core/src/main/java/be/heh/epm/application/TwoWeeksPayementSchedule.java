package be.heh.epm.application;

import java.time.LocalDate;
import java.time.temporal.*;
import java.util.Locale;

public class TwoWeeksPayementSchedule implements PaymentSchedule{
    // ATTRIBUTES

    // CONSTRUCTOR

    // GETTERS & SETTERS

    // METHODS
    private int Weeknumber(LocalDate date){
        TemporalField wf = WeekFields.of(Locale.getDefault()).weekOfMonth();
        return date.get(wf);
    }

    @Override
    public boolean IsDatePay(LocalDate date) {
        int weekNumber = Weeknumber(date);
        return (weekNumber == 2 || weekNumber == 4) && (date.getDayOfWeek().getValue() == 5);
    }

    @Override
    public LocalDate GetStartPayPeriod(LocalDate dateEnd) {
        LocalDate tmp = dateEnd.minusDays(14);
        if (!IsDatePay(tmp)){
            tmp = tmp.minusDays(7);
        }
        return tmp.plusDays(3);
    }
}
