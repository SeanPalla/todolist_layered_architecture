package com.qa;

public enum TodoMenuOption {
    CREATE("C", " - (Create a Todo item)"), READ("R", " - (Read a list of all Todo items)"),
    UPDATE("U", " - (Update a file name)"), DELETE_BY_ID("D", " - (Delete a file by the id provided)"),
    DELETE_BY_NAME("DN", " - (Delete a file by the name provided)"), EXIT("E", " - (Exit the program)");

    private String inputCode;
    private String inputInfo;

    private TodoMenuOption(String inputCode, String inputInfo) {
        this.inputCode = inputCode;
        this.inputInfo = inputInfo;
    }

    public String getInputCode() {
        return this.inputCode;
    }

    public String getInputInfo() {
        return this.inputInfo;
    }
}