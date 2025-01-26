package com.example.prueba.service;

import com.example.prueba.Model.Task;
import com.example.prueba.exception.DataBaseException;
import com.example.prueba.exception.InvalidInputException;
import com.example.prueba.exception.TaskNotFoundException;
import com.example.prueba.repository.TaskRepository;
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
        if (task.getTitle() == null || task.getTitle().isEmpty()) {
            throw new InvalidInputException("El nombre no puede estar vacio");
        }
        try {
            return taskRepository.save(task);
        } catch (Exception exception) {
            throw new DataBaseException("Error al guardar en la base de datos");
        }
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            throw new TaskNotFoundException("Tarea con id: " + id + "no encontrada");
        }
        return task;
    }

    @Override
    public void deleteTask(Long id) {
        if(!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("tarea con Id: " + id + " no encontrada");
        }
        taskRepository.deleteById(id);
    }
}
