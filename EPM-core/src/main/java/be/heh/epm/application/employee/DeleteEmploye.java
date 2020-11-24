package be.heh.epm.application.employee;

import be.heh.epm.application.Command;

public class DeleteEmploye implements Command {
    int id;

    public DeleteEmploye(int id) {
        this.id = id;
    }

    @Override
    public void execute() {
        Context.emp.deleteEmployed(id);
    }
}
