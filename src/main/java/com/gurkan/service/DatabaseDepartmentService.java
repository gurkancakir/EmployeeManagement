package com.gurkan.service;

import com.gurkan.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by gurkan on 08.03.2017.
 */
public class DatabaseDepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DatabaseDepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public DepartmentRepository getDepartmentRepository() {
        return departmentRepository;
    }
}
