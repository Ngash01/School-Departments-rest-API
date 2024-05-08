package com.ngash.springbootdailycb.controller;

import com.ngash.springbootdailycb.entity.DepartmentEntity;
import com.ngash.springbootdailycb.error.DepartmentNotFoundException;
import com.ngash.springbootdailycb.service.DepartmentService;
import com.ngash.springbootdailycb.service.DepartmentServiceImplementation;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public DepartmentEntity saveDepartment(@Valid @RequestBody DepartmentEntity departmentEntity){
        LOGGER.info("Inside save department of departmentController!");
        return departmentService.saveDepartment(departmentEntity);
    }

    @GetMapping("/departments")
    public List<DepartmentEntity> getDepartments(){
        return departmentService.fetchDepartments();
    }

    @GetMapping("/departments/{id}")
    public DepartmentEntity fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside fetchDepartment by ID of departmentController");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteMapping(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentId(departmentId);
        return "Department deleted Successfully!";
    }

    @PutMapping("/departments/{id}")
    public DepartmentEntity updateDepartment(@RequestBody DepartmentEntity departmentEntity, @PathVariable("id") Long id){
        return departmentService.updateDepartment(id, departmentEntity);
    }

    @GetMapping("departments/name/{name}")
    public DepartmentEntity fetchDepartmentByName(@PathVariable("name") String name){
        return departmentService.fetchDepartmentByName(name);
    }
}


