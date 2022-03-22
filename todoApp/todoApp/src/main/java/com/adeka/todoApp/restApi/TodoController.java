package com.adeka.todoApp.restApi;


import com.adeka.todoApp.Business.ITodoService;
import com.adeka.todoApp.Entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    private ITodoService service;

    @Autowired
    public TodoController(ITodoService service) {
        this.service = service;
    }

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return this.service.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Todo todo) {
        service.Add(todo);
    }

    @PostMapping("/update")
    public void update(@RequestBody Todo todo) {
        service.Update(todo);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Todo todo) {
        service.Delete(todo);
    }

    @GetMapping("/todos/{id}")
    public Todo getById(@PathVariable int id) {
        return service.getById(id);
    }


}
