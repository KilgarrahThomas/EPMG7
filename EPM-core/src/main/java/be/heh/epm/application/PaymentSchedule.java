package be.heh.epm.application;

import java.time.LocalDate;

public interface PaymentSchedule {

    public boolean IsDatePay(LocalDate date);
}
