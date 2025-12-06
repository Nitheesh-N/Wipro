package com.example.controller;

import com.example.bean.Task;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<?> addTask(@RequestBody Task task) {
    	try {
    	    Task updated = taskService.updateTask(task);
    	    return new ResponseEntity<>(updated, HttpStatus.OK);
    	} catch (IllegalArgumentException e) {
    	    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    	} catch (RuntimeException e) {
    	    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    	}

    }

    @PutMapping("/put")
    public ResponseEntity<?> updateTask(@RequestBody Task task) {
    	try {
    	    Task updated = taskService.updateTask(task);
    	    return new ResponseEntity<>(updated, HttpStatus.OK);
    	} catch (IllegalArgumentException e) {
    	    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    	} catch (RuntimeException e) {
    	    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    	}

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Integer id) {
        try {
            taskService.deleteTask(id);
            return new ResponseEntity<>("Task deleted", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchByStatus(@RequestParam(required = false) String status) {
        if (status == null || status.isBlank()) {
            return new ResponseEntity<>(List.of(), HttpStatus.BAD_REQUEST);
        }
        try {
            return new ResponseEntity<>(taskService.searchByStatus(status), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(List.of(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/priority/{priority}")
    public ResponseEntity<?> filterByPriority(@PathVariable String priority) {
        try {
            return new ResponseEntity<>(taskService.filterByPriority(priority), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(List.of(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/overdue")
    public ResponseEntity<List<Task>> getOverdueTasks() {
        return new ResponseEntity<>(taskService.getOverdueTasks(), HttpStatus.OK);
    }
}
