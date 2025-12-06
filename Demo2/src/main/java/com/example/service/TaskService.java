package com.example.service;

import com.example.bean.Task;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task addTask(Task task);
    Task updateTask(Task task);
    void deleteTask(Integer id);
    List<Task> getAllTasks();
    Optional<Task> getTaskById(Integer id);
    List<Task> searchByStatus(String status);
    List<Task> filterByPriority(String priority);
    List<Task> getOverdueTasks();
}
