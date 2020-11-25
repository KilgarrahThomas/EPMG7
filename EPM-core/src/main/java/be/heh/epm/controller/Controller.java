package be.heh.epm.controller;

import be.heh.epm.application.employee.Employee;
import be.heh.epm.database.DataBaseHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController //Defini cette classe comme un controlleur
@CrossOrigin(origins = "http://localhost:3000") //Permet de lier le backend et le frontend

public class Controller {
    DataBaseHelper db = new DataBaseHelper();

    @GetMapping("/api/helloworld")      //API de test, retourne un Hello World
    public ResponseEntity helloworld() {
        return ResponseEntity.ok("Hello World :P");
    }

    @GetMapping("/api/employee")        //API all Employee
    public ArrayList<Employee> getAllEmployees() {
        return db.getEmployees();
    }

    @GetMapping("/api/employee/{id}")   //API ID Employee
    public Employee findByid(@PathVariable int id) {
        Employee emp = db.getEmployee(id);
        if(emp==null)
            throw new UserNotFoundException("id-" + id + " not found !");
        return emp;
    }
/*
    @PostMapping("/api/create")         //API Create Employee
    public ResponseEntity parametrage(@RequestParam(name = "id") int id,@RequestParam(name = "name") String name, @RequestParam(name = "address") String address) {
        Employee emp = new Employee(id,name, address);
        db.addEmployee(emp);
        return ResponseEntity.ok(emp.getEmployeeId());
    }

    @GetMapping("/api/employee/delete") //API Delete Employee
    public ResponseEntity deleteClient(@RequestParam(name = "id") int id) { //RequestParam sera envoyé mais invisible dans le lien
        db.deleteEmployee(id);
        return ResponseEntity.ok("DELETE");
    }*/
}