package br.com.vieiradev.controleestoque.ControleDeEstoque.service;

import br.com.vieiradev.controleestoque.ControleDeEstoque.model.Employee;
import br.com.vieiradev.controleestoque.ControleDeEstoque.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getById(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado.");
        }
        return employeeRepository.findById(id);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, Employee employee) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado.");
        }
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public void delete(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Funcionário não encontrado.");
        }
    }

}
