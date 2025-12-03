package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final  TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getallTodos();
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Todo>> createTodo(@RequestBody Todo todo){
            return todoService.createTodo(todo);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Todo>>  getTodoById(@PathVariable int id) {
        return todoService.getTodoById(id);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Todo>> updateTodo(@PathVariable int id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable int id) {
        boolean deleted = todoService.deleteTodo(id);
        return deleted ? "Todo deleted successfully." : "Todo not found.";
    }



}
