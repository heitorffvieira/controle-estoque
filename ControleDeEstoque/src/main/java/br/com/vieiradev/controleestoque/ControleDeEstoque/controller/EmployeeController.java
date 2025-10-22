package br.com.vieiradev.controleestoque.ControleDeEstoque.controller;

import br.com.vieiradev.controleestoque.ControleDeEstoque.model.Employee;
import br.com.vieiradev.controleestoque.ControleDeEstoque.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getById(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }

}
