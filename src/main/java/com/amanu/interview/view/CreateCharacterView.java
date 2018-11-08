package com.amanu.interview.view;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Amanuel Nega on November 07, 2018.
 */
public class CreateCharacterView implements View {

    private final Consumer<String> characterSelected;

    public CreateCharacterView(Consumer<String> characterSelected) {
        this.characterSelected = characterSelected;
    }

    @Override
    public String getTitle() {
        return "Create Character";
    }

    @Override
    public String getHeader() {
        return "Create your character" +
                "\n\n" +
                "Which hero/heroin do you want to be? ";
    }

    @Override
    public List<Menu> getMenus() {
        ArrayList<Menu> menus = new ArrayList<>();

        Consumer<Menu> consumer = (menu) -> {
            characterSelected.accept(menu.getTitle());
        };

        menus.add(Menu.of("Tarzan", consumer));
        menus.add(Menu.of("Robin Hood", consumer));

        // A little bribe :-) 
        menus.add(Menu.of("Ashwini", consumer));
        menus.add(Menu.of("Rad", consumer));

        return menus;
    }

}
