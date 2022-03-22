package com.adeka.todoApp.DataAccess;

import com.adeka.todoApp.Entities.Todo;

import java.util.List;

public interface ITodoDal {

    List<Todo> getAll();
    void Add (Todo city);
    void Delete (Todo city);
    void Update (Todo city);
    Todo getById(int id);
}
