package be.heh.epm.application;

import be.heh.epm.domain.PayCheck;

import java.time.LocalDate;

public interface PaymentClassification {
    void CalculationSalary(PayCheck pc);

    default boolean PayPeriod(LocalDate date, PayCheck pc)
    {
        LocalDate payPeriodStart = pc.getPayPayPeriodStart();
        LocalDate payPeriodEnd = pc.getDate();
        return date.equals(payPeriodEnd) || date.equals(payPeriodStart) ||
                (date.isAfter(payPeriodStart) && date.isBefore(payPeriodEnd));
    }
}


