package com.example.prueba;

import com.example.prueba.Model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
