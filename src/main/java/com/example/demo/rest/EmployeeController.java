package com.example.demo.rest;


import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAll() {
        return employeeService.getAll();
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> add(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO employeeDTO1 = employeeService.add(employeeDTO);
        return ResponseEntity.ok(employeeDTO1);
    }

    @PutMapping
    public ResponseEntity<EmployeeDTO> update(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO employeeDTO1 = employeeService.update(employeeDTO);
        return ResponseEntity.ok(employeeDTO1);
    }

    @DeleteMapping("/{employee_id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "employee_id") long employeeId) {
        try {
            employeeService.deleteEmployeeById(employeeId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{employee_id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(value = "employee_id") long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeId(employeeId));
    }

    @GetMapping("/{employee_name}")
    public ResponseEntity<EmployeeDTO> getEmployeeByname(@PathVariable(value = "employee_name") String employeeName) {
        return ResponseEntity.ok(employeeService.getByEmployeeName(employeeName));
    }
}
