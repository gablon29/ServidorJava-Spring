package com.example.prueba;

import com.example.prueba.Model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImp implements TaskService{


    private final TaskRepository taskRepository;


    @Autowired
    public TaskServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTask(Long id) {

    }
}
