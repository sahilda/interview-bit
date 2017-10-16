package com.sahilda.practice.thumbtack;

import javafx.concurrent.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
import java.util.logging.Handler;

public class TodoApp implements Runnable {

    List<TODO> todos;
    PriorityQueue<TODO> heapTodos;

    public TodoApp() {
        todos = new ArrayList<>();
        heapTodos = new PriorityQueue<>();
    }

    public void addNewTodo(String task) {
        TODO todo = new TODO(task);
        todos.add(todo);
        addToHeap(todo);
    }

    public void addNewTodo(String task, Date dueDate, String dueUrl) {
        TODO todo = new TODO(task, dueDate, dueUrl);
        todos.add(todo);
        addToHeap(todo);
    }

    public void markTodoComplete(TODO todo) {
        todo.markComplete();
    }

    public void getTodos() {
        for (TODO todo : todos) {
            System.out.println(todo.task + " " + todo.status);
        }
    }

    private void addToHeap(TODO todo) {
        if (todo.dueDate != null) {
            heapTodos.add(todo);
        }
    }

    @Override
    public void run() {
        Date current = new Date();
        List<TODO> list = new ArrayList<>();
        while (heapTodos.peek() != null && heapTodos.peek().dueDate.compareTo(current) == -1) {
            TODO todo = heapTodos.poll();
            if (!todo.status.equals(TODO.Status.COMPLETE)) {
                list.add(todo);
            }
        }

        for (TODO todo : list) {
            System.out.println("Running dueUrl on " + todo.task);
            todo.markComplete();
            try {
                todo.callDueUrl();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static TodoApp makeTodoApp() {
        String url = "http://www.google.com";
        int SECOND = 1000;

        TodoApp todoApp = new TodoApp();
        todoApp.addNewTodo("Do Dishes");

        Date date = new Date();
        date.setTime(date.getTime() + 10 * SECOND);
        todoApp.addNewTodo("Clean room", date, url);

        date = new Date();
        date.setTime(date.getTime() + 20 * SECOND);
        todoApp.addNewTodo("Clean car", date, url);

        date = new Date();
        date.setTime(date.getTime() + 30 * SECOND);
        todoApp.addNewTodo("Do laundry", date, url);

        date = new Date();
        date.setTime(date.getTime() + 10 * SECOND);
        todoApp.addNewTodo("Eat food", date, url);
        return todoApp;
    }

}

class TODO implements Comparable<TODO> {

    public String task;
    public Date dueDate;
    public Status status;
    public String dueUrl;

    enum Status {
        IN_PROGRESS,
        COMPLETE;
    }

    public TODO(String task, Date dueDate, String dueUrl) {
        this.task = task;
        this.dueDate = dueDate;
        this.dueUrl = dueUrl;
        this.status = Status.IN_PROGRESS;
    }

    public TODO(String task) {
        this.task = task;
        this.status = Status.IN_PROGRESS;
    }

    public void markComplete() {
        this.status = Status.COMPLETE;
    }

    public void callDueUrl() throws IOException {
        URL url = new URL(dueUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }
        br.close();

        System.out.println("Response Code:" + connection.getResponseCode());
    }

    @Override
    public int compareTo(TODO o) {
        if (this == o) {
            return 0;
        }
        return this.dueDate.compareTo(o.dueDate);
    }

}
