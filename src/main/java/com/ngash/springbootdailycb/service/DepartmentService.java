package com.ngash.springbootdailycb.service;

import com.ngash.springbootdailycb.entity.DepartmentEntity;
import com.ngash.springbootdailycb.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity);

    public List<DepartmentEntity> fetchDepartments();


    public String deleteDepartmentId(Long id);

    public DepartmentEntity fetchDepartmentById(Long id) throws DepartmentNotFoundException;

    public DepartmentEntity updateDepartment(Long id, DepartmentEntity departmentEntity);

    public DepartmentEntity fetchDepartmentByName(String name);
}



