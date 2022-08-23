package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceImplTest {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        Department department = Department.builder().departmentName("Research")
                .departmentCode("TECH-01")
                .departmentAddress("Iceland")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findBydepartmentNameIgnoreCase("Research")).thenReturn(department);

    }

    @Test
    @DisplayName("Get Data Based on Valid Department Name")
    void fetchDepByName_WhenValid() {

        String depName = "Research";

        Department found =
                departmentService.fetchDepByName(depName);

        assertEquals(depName, found.getDepartmentName());
    }
}