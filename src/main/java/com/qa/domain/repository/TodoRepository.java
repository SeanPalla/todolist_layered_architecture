package com.qa.domain.repository;

import java.util.ArrayList;
import java.util.List;

import com.qa.domain.entity.Todo;

public class TodoRepository {
    private List<Todo> todoItems;
    private long idCounter;

    public TodoRepository() {
        this.todoItems = new ArrayList<>();
        idCounter = 1;

    }

    public Todo save(Todo todo) {
        for (int i = 0; i < todoItems.size(); i++) {
            Todo current = todoItems.get(i);
            if (todo.getName().equals(current.getName())) {
                // throw new RuntimeException("Todo already exists with given name");
            }
        }
        todo.setId(idCounter++);
        todoItems.add(todo);
        return todo;
    }

    public List<Todo> read() {
        return todoItems;
    }

    public boolean update(String todo, String newTodo) {

        for (int i = 0; i < todoItems.size(); i++) {
            Todo current = todoItems.get(i);
            if (current.getName().equals(todo)) {
                current.setName(newTodo);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(long id) {
        boolean didDelete = false;

        for (int i = 0; i < todoItems.size(); i++) {
            Todo current = todoItems.get(i);

            if (current.getId() == id) {
                didDelete = todoItems.remove(current);
                break;
            }
        }
        return didDelete;
    }

    public boolean deleteByName(String name) {
        boolean didDelete = false;

        for (int i = 0; i < todoItems.size(); i++) {
            Todo current = todoItems.get(i);

            if (current.getName().equals(name)) {
                didDelete = todoItems.remove(current);
                break;
            }
        }
        return didDelete;
    }
}
