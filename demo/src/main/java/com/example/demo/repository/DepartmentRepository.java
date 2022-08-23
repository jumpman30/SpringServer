package com.example.demo.repository;

import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {


    public Department findBydepartmentName(String departmentName);

    //@Query(value = "", nativeQuery = true) you can use this if the query is to complex and pass nativeQuery=true if it's a native sql query. If you are using jpql you can ignore that
    public Department findBydepartmentNameIgnoreCase(String departmentName);

}
