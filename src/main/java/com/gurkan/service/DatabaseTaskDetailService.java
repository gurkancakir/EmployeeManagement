package com.gurkan.service;

import com.gurkan.entity.TaskDetail;
import com.gurkan.repository.TaskDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by gurkancakir on 08/03/2017.
 */
@Service
public class DatabaseTaskDetailService {

    @Autowired
    private TaskDetailRepository taskDetailRepository;

    public TaskDetail save(TaskDetail department) {
        return taskDetailRepository.save(department);
    }

    public TaskDetail findOne(Long id) {
        return taskDetailRepository.findOne(id);
    }

    public void delete(TaskDetail department) {
        taskDetailRepository.delete(department);
    }
}
