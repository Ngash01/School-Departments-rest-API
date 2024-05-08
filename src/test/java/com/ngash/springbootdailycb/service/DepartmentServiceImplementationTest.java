package com.ngash.springbootdailycb.service;

import com.ngash.springbootdailycb.entity.DepartmentEntity;
import com.ngash.springbootdailycb.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceImplementationTest {

    @Autowired
   private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp(){
        DepartmentEntity departmentEntity = DepartmentEntity.builder()
                .departmentName("IT")
                .departmentCode("Times-12")
                .departmentAddress("123").build();
    }


    @Test
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "Chemistry";
        DepartmentEntity found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}




