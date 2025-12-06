package com.example.service;

import com.example.bean.Task;
import com.example.repo.TaskRepository;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.*;

@Service
public class TaskServiceimpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    private final Set<String> validPriorities = Set.of("low", "medium", "high");
    private final Set<String> validStatuses = Set.of("pending", "in-progress", "completed");

    @Override
    public Task addTask(Task task) {
        validateTask(task, true);
        if (taskRepository.existsById(task.getId()))
            throw new RuntimeException("Conflict: Task ID exists");
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        validateTask(task, false);
        if (!taskRepository.existsById(task.getId()))
            throw new RuntimeException("Not Found: Task ID does not exist");
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Integer id) {
        if (!taskRepository.existsById(id))
            throw new RuntimeException("Not Found: Task ID does not exist");
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> searchByStatus(String status) {
        if (!StringUtils.hasText(status) || !validStatuses.contains(status.toLowerCase())) {
            throw new IllegalArgumentException("Invalid status");
        }
        return taskRepository.findByStatusIgnoreCase(status);
    }

    @Override
    public List<Task> filterByPriority(String priority) {
        if (!validPriorities.contains(priority.toLowerCase()))
            throw new IllegalArgumentException("Invalid priority");
        return taskRepository.findByPriorityIgnoreCase(priority);
    }

    @Override
    public List<Task> getOverdueTasks() {
        LocalDate today = LocalDate.now();
        return taskRepository.findByDueDateBeforeAndStatusNot(today, "completed");
    }

    private void validateTask(Task task, boolean requireNew) {
        if (!validPriorities.contains(task.getPriority().toLowerCase()) ||
            !validStatuses.contains(task.getStatus().toLowerCase()) ||
            task.getDueDate() == null) {
            throw new IllegalArgumentException("Invalid priority, status, or dueDate");
        }
        if (!StringUtils.hasText(task.getTitle())) {
            throw new IllegalArgumentException("Title is required");
        }
    }
}
