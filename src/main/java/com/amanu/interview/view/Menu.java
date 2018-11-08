package com.amanu.interview.view;

import java.util.function.Consumer;

public class Menu {
    private String title;
    private Consumer<Menu> consumer;

    public Menu(String title, Consumer<Menu> consumer) {
        this.title = title;
        this.consumer = consumer;
    }

    public String getTitle() {
        return title;
    }

    public Consumer<Menu> getConsumer() {
        return consumer;
    }

    public static Menu of(String title, Consumer<Menu> consumer){
        return new Menu(title, consumer);
    }
}
