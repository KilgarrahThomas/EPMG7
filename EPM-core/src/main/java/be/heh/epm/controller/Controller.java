package be.heh.epm.controller;

import be.heh.epm.application.Employee;
import be.heh.epm.database.DataBaseHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController //Défini la classe comme controleur
@CrossOrigin(origins = "http://localhost:3000") //Lie le backend au frontend via le lien du frontend

public class Controller {
    DataBaseHelper db = new DataBaseHelper();

    @GetMapping("/api/helloworld")
    public ResponseEntity helloworld() {
        return ResponseEntity.ok("Hello World Rest");
    }

    @GetMapping("/api/employee/{id}")
    public Employee findByid(@PathVariable int id) {    //PathVariable = lien qui change
        Employee emp = db.getEmployee(id);
        if(emp==null)
            throw new UserNotFoundException("id-" + id + " not found !");
        return emp;
    }

    @GetMapping("/api/employee")
    public ArrayList<Employee> getAllEmployees() {    //PathVariable = lien qui change
        return db.getEmployees();
    }

    @GetMapping("/api/employee/delete")
    public ResponseEntity deleteClient(@RequestParam(name = "id") int id) {    //RequestParam = paramètre envoyé mais pas visible dans le lien
        db.deleteEmployee(id);
        return ResponseEntity.ok("DELETE");

    }

    @PostMapping("/api/create")
    public ResponseEntity parametrage(@RequestParam(name = "id") int id,@RequestParam(name = "name") String name, @RequestParam(name = "address") String address) {
        Employee emp = new Employee(id,name, address);
        db.addEmployee(emp);
        return ResponseEntity.ok(emp.getEmployeeId());
    }

}