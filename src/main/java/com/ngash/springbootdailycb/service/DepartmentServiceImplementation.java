package com.ngash.springbootdailycb.service;

import com.ngash.springbootdailycb.entity.DepartmentEntity;
import com.ngash.springbootdailycb.error.DepartmentNotFoundException;
import com.ngash.springbootdailycb.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImplementation implements DepartmentService{

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity){
        return departmentRepository.save(departmentEntity);
    }

    @Override
    public List<DepartmentEntity> fetchDepartments(){
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentEntity fetchDepartmentById( Long id) throws DepartmentNotFoundException {
        Optional<DepartmentEntity> depDB =  departmentRepository.findById(id);

            if(!depDB.isPresent()){
                throw new DepartmentNotFoundException("Department Not Found!");
            }

        return depDB.get();

    }

    @Override
    public DepartmentEntity updateDepartment( Long id, DepartmentEntity departmentEntity){  //new dptName
        DepartmentEntity ExistingDept = departmentRepository.findById(id).get();

        if(departmentEntity.getDepartmentName() != null && !departmentEntity.getDepartmentName().equals("")){
            ExistingDept.setDepartmentName(departmentEntity.getDepartmentName());
        }

        if(departmentEntity.getDepartmentAddress() != null && !departmentEntity.getDepartmentAddress().equals("")){
            ExistingDept.setDepartmentAddress(departmentEntity.getDepartmentAddress());
        }

        if(departmentEntity.getDepartmentCode() != null && !departmentEntity.getDepartmentCode().equals("")){
            ExistingDept.setDepartmentCode(departmentEntity.getDepartmentCode());
        }

        return departmentRepository.save(ExistingDept);
    }

    @Override
    public DepartmentEntity fetchDepartmentByName(String departmentName){
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

    @Override
    public String deleteDepartmentId(Long id){
        departmentRepository.deleteById(id);
        return "";
    }

}








