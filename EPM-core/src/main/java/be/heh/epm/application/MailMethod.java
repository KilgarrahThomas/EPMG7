package be.heh.epm.application;

public class MailMethod implements PaymentMethod {
    // ATTRIBUTES
    private String mail;

    // CONSTRUCTOR

    public MailMethod(String mail) {
        this.mail = mail;
    }

    // GETTERS & SETTERS

    // METHODS

    @Override
    public String toString() {
        return super.toString();
    }
}
