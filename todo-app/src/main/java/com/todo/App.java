package com.todo;

import java.util.ArrayList;
import java.util.List;

public class App {

    private static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: add <task> | list | done <id>");
            return;
        }

        switch (args[0]) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Please provide a task description.");
                } else {
                    addTask(args[1]);
                }
                break;

            case "list":
                listTasks();
                break;

            case "done":
                if (args.length < 2) {
                    System.out.println("Please provide task ID.");
                } else {
                    markDone(Integer.parseInt(args[1]));
                }
                break;

            default:
                System.out.println("Unknown command");
        }
    }

    public static void addTask(String text) {
        Task task = new Task(tasks.size() + 1, text, false);
        tasks.add(task);
        System.out.println("Added: " + text);
    }

    public static List<Task> getTasks() {
        return tasks;
    }

    public static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (Task t : tasks) {
                String status = t.isDone() ? "[✔]" : "[ ]";
                System.out.println(status + " " + t.getId() + ": " + t.getText());
            }
        }
    }

    public static void markDone(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setDone(true);
                System.out.println("Task " + id + " completed.");
                return;
            }
        }
        System.out.println("Task not found.");
    }
}
