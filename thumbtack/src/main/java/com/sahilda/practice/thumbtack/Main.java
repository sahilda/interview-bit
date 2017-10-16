package com.sahilda.practice.thumbtack;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        runTodoApp();
    }

    private static void runTodoApp() {
        TodoApp todoApp = TodoApp.makeTodoApp();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(todoApp, 1, 3, TimeUnit.SECONDS);

        todoApp.getTodos();
        try {
            Thread.sleep(1000 * 45);
        } catch (Exception e) {
            e.printStackTrace();
        }
        todoApp.getTodos();
    }

}
