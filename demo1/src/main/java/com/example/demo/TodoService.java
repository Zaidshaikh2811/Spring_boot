package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TodoService {

    private final List<Todo> todos = new ArrayList<>();
    private int currentId = 1;


    public List<Todo> getallTodos(){
        return todos;
    }

    public ResponseEntity<ApiResponse<Todo>> createTodo(Todo todo){
        System.out.println(todo);
        todo.setId(currentId++);
        todos.add(todo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Todo created successfully", todo));
    }

    public  ResponseEntity<ApiResponse<Todo>> getTodoById(int id){

        Optional<Todo>  todo= todos.stream().filter(t -> t.getId() == id).findFirst();

        if (todo.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ApiResponse<>(true, "Todo successfully found", todo.get())
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ApiResponse<>(false, "Todo not found", null)
            );
        }
    }

    public ResponseEntity<ApiResponse<Todo>> updateTodo(int id, Todo updatedTodo) {
        Optional<Todo> existingTodo = todos.stream()
                .filter(t -> t.getId() == id)
                .findFirst();

        if (existingTodo.isPresent()) {
            Todo todo = existingTodo.get();
            todo.setTitle(updatedTodo.getTitle());
            todo.setCompleted(updatedTodo.isCompleted());

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(true, "Todo updated successfully", todo));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, "Todo not found", null));
        }
    }

    public boolean deleteTodo(int id) {
        return todos.removeIf(todo -> todo.getId() == id);
    }


}
