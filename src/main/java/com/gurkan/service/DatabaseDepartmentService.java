package com.gurkan.service;

import com.gurkan.entity.Department;
import com.gurkan.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by gurkan on 08.03.2017.
 */
@Service
public class DatabaseDepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> findByName(String name) {
        return departmentRepository.findByName(name);
    }

    public void delete(Department department) {
        departmentRepository.delete(department);
    }
}
