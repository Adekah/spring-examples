package com.adeka.todoApp.DataAccess;

import com.adeka.todoApp.Entities.Todo;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HibernateTodoDal implements ITodoDal {

    private EntityManager entityManager;

    public HibernateTodoDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public List<Todo> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Todo> todos = session.createQuery("from Todo", Todo.class).getResultList();
        return todos;
    }

    @Override
    public void Add(Todo todo) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(todo);
    }

    @Override
    public void Delete(Todo todo) {
        Session session = entityManager.unwrap(Session.class);
        Todo todoToDelete = session.get(Todo.class, todo.getId());

        session.delete(todoToDelete);
    }

    @Override
    public void Update(Todo todo) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(todo);
    }

    @Override
    public Todo getById(int id) {

        Session session = entityManager.unwrap(Session.class);
        Todo todo = session.get(Todo.class, id);
        return todo;
    }
}
