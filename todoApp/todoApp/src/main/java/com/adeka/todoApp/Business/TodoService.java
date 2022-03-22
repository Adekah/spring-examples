package com.adeka.todoApp.Business;

import com.adeka.todoApp.DataAccess.ITodoDal;
import com.adeka.todoApp.Entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService implements ITodoService {

    private ITodoDal iTodoDal;

    @Autowired
    public TodoService(ITodoDal iTodoDal) {
        this.iTodoDal = iTodoDal;
    }

    @Override
    @Transactional
    public List<Todo> getAll() {
        return this.iTodoDal.getAll();
    }

    @Override
    @Transactional
    public void Add(Todo todo) {
        this.iTodoDal.Add(todo);
    }

    @Override
    @Transactional
    public void Delete(Todo todo) {
        this.iTodoDal.Delete(todo);
    }

    @Override
    @Transactional
    public void Update(Todo todo) {
        this.iTodoDal.Update(todo);
    }

    @Override
    @Transactional
    public Todo getById(int id) {
        return this.iTodoDal.getById(id);
    }
}
