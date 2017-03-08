package com.gurkan.repository;

import com.gurkan.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Created by gurkancakir on 08/03/2017.
 */
public interface TaskRepository extends CrudRepository<Task,Long> {

    public Optional<Task> findByName(@Param("name") String name);
}