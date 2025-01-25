package com.example.prueba;

import com.example.prueba.Model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final  TaskServiceImp taskServiceImp;

    @Autowired
    public TaskController(TaskServiceImp taskServiceImp) {
        this.taskServiceImp = taskServiceImp;
    }

    @PostMapping
    public Task craetedTask(@RequestBody Task task) {
        return taskServiceImp.saveTask(task);
    }

    @GetMapping()
    public List<Task> getAllTask() {
        return taskServiceImp.getAllTask();
    }

    @GetMapping("{id}")
    public Task getTasById(@PathVariable Long id) {
        return taskServiceImp.getById(id);
    }
}
