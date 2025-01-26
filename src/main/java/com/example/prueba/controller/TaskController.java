package com.example.prueba.controller;

import com.example.prueba.Model.Task;
import com.example.prueba.service.TaskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskServiceImp taskServiceImp;

    @Autowired
    public TaskController(TaskServiceImp taskServiceImp) {
        this.taskServiceImp = taskServiceImp;
    }

    @PostMapping
    public ResponseEntity<?> craetedTask(@RequestBody Task task) {
            Task createTask = taskServiceImp.saveTask(task);
            return ResponseEntity.status(HttpStatus.CREATED).body(createTask);
    }

    @GetMapping()
    public List<Task> getAllTask() {
        return taskServiceImp.getAllTask();
    }

    @GetMapping("/{id}")
    public Task getTasById(@PathVariable Long id) {
        return taskServiceImp.getById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskServiceImp.deleteTask(id);
        return "Eliminada con exito";
    }
}
