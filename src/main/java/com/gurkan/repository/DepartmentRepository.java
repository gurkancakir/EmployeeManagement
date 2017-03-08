package com.gurkan.repository;

import com.gurkan.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Created by gurkan on 08.03.2017.
 */
public interface DepartmentRepository extends CrudRepository<Department,Long> {

    public Optional<Department> findByName(@Param("name") String name);
}
