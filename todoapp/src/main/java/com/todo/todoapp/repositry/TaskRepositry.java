package com.todo.todoapp.repositry;

import com.todo.todoapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepositry extends JpaRepository<Task,Long> {

}
