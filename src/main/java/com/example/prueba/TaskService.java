package com.example.prueba;

import com.example.prueba.Model.Task;

import java.util.List;

public interface TaskService {
    Task saveTask(Task task);
    List<Task> getAllTask();
    Task getById(Long id);
    void deleteTask(Long id);
}
