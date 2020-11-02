package be.heh.epm.domain;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PayCheck {

    private LocalDate date;
    private double salary;
    private Map<String, String> fields = new HashMap<String, String>();

    public PayCheck(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getSalary() {
        return salary;
    }

    public void setPay(double salary) {
        this.salary = salary;
    }

    public void setField(String field, String value) {
        fields.put(field, value);
    }

    public String getField(String field) {
        return fields.get(field);
    }

}
