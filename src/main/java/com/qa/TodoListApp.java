package com.qa;

import com.qa.utilities.InputUtilities;

import com.qa.domain.repository.TodoRepository;
import com.qa.controller.TodoController;

public class TodoListApp {

    private TodoController todoController;
    private boolean isRunning = true;

    public TodoListApp(TodoController todoController) {
        this.todoController = todoController;
    }

    public void run() {
        do {
            try {
                printMenu();
                // get input
                String input = InputUtilities.getString("> ");
                TodoMenuOption option = getInputOption(input);
                switch (option) {
                    case CREATE:
                        todoController.create();
                        break;
                    case READ:
                        todoController.read();
                        break;
                    case UPDATE:
                        todoController.update();
                        break;
                    case DELETE_BY_ID:
                        todoController.deleteById();
                        break;
                    case DELETE_BY_NAME:
                        todoController.deleteByName();
                        break;
                    case EXIT:
                        isRunning = false;
                        break;
                }
            } catch (IllegalArgumentException e) {
                // the catch () {} block is the code that runs if an exception occurs
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                // can have multiple catch blocks, from most specific to least specific
                System.out.println("Something went wrong...");
            }
        } while (isRunning);
    }

    private TodoMenuOption getInputOption(String input) {
        TodoMenuOption[] menuOptions = TodoMenuOption.values();
        for (int i = 0; i < menuOptions.length; i++) {
            if (menuOptions[i].getInputCode().equalsIgnoreCase(input)) {
                return menuOptions[i];
            }
        }
        throw new IllegalArgumentException("Invalid menu option");
    }

    private void printMenu() {
        TodoMenuOption[] menuOptions = TodoMenuOption.values();
        for (int i = 0; i < menuOptions.length; i++) {
            String output = String.format("[%s] %s", menuOptions[i].getInputCode(), menuOptions[i].toString() +
                    menuOptions[i].getInputInfo());
            System.out.println(output);
        }
    }
}
