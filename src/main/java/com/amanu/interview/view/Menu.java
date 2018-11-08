package com.amanu.interview.view;

import java.util.function.Consumer;

public class Menu {
    private String title;
    private Consumer<String> consumer;

    public Menu(String title, Consumer<String> consumer) {
        this.title = title;
        this.consumer = consumer;
    }

    public String getTitle() {
        return title;
    }

    public Consumer<String> getConsumer() {
        return consumer;
    }

    public static Menu of(String title, Consumer<String> consumer){
        return new Menu(title, consumer);
    }
}
