package com.qa.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.qa.domain.entity.Todo;
import com.qa.domain.repository.TodoRepository;
import com.qa.utilities.InputUtilities;

public class TodoController {

    private TodoRepository todoRepository;
    // Scanner sc = new Scanner(System.in);

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void create() {
        String name = InputUtilities.getString("Name: ");
        String date = InputUtilities.getString("Date (yyyy/mm/dd): ");

        Todo todo = todoRepository.save(new Todo(name, LocalDate.parse(date)));
        System.out.println("Todo created successfully! \n\t" + todo.toString() + "\n");
    }

    public void read() {
        List<Todo> todos = todoRepository.read();
        for (Todo todo : todos) {
            System.out.println(todo.toString());
        }
    }

    public void update() {

    }

    public void deleteById() {
        long id = InputUtilities.getInt("ID: ");

        boolean didDelete = todoRepository.deleteById(id);
        if (didDelete)
            System.out.println("Deleted task with id: " + id);
        else
            System.out.println("Could not delete the task");
    }

    public void deleteByName() {
        String name = InputUtilities.getString("Name: ");

        boolean didDelete = todoRepository.deleteByName(name);
        if (didDelete)
            System.out.println("Deleted task with id: " + name);
        else
            System.out.println("Could not delete the task");
    }
}