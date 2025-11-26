package com.todo;

public class Task {
    private int id;
    private String text;
    private boolean done;

    public Task(int id, String text, boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }

    public int getId() { return id; }
    public String getText() { return text; }
    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }
}
