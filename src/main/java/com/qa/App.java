package com.qa;

import com.qa.controller.TodoController;
import com.qa.domain.repository.TodoRepository;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        TodoController todoController = new TodoController(new TodoRepository());
        TodoListApp tdl = new TodoListApp(todoController);
        tdl.run();
    }
}
