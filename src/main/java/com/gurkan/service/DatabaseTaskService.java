package com.gurkan.service;

import com.gurkan.entity.Task;
import com.gurkan.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by gurkancakir on 08/03/2017.
 */
    @Service
    public class DatabaseTaskService {

        @Autowired
        private TaskRepository taskRepository;

        public Task save(Task task) {
            return taskRepository.save(task);
        }

        public Optional<Task> findByName(String name) {
            return taskRepository.findByName(name);
        }

        public void delete(Task task) {
            taskRepository.delete(task);
        }
    }
