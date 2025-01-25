package com.todo.todoapp.service;

import com.todo.todoapp.models.Task;
import com.todo.todoapp.repositry.TaskRepositry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepositry taskRepositry;

    public TaskService(TaskRepositry taskRepositry){
        this.taskRepositry=taskRepositry;
    }
    public List<Task> getAllTasks() {
     return taskRepositry.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepositry.save(task);
    }

    public void deleteTask(Long id) {
        taskRepositry.deleteById(id);
    }

    public void toggleTasks(Long id) {
        Task task = taskRepositry.findById(id)
                .orElseThrow(() ->  new IllegalArgumentException("Invalid Task I'd"));
        task.setCompleted(!task.isCompleted());
        taskRepositry.save(task);
    }
}
