package com.amanu.interview.view;

import java.util.List;

/**
 * @author Amanuel Nega on November 07, 2018.
 */
public interface View {
    
    String getTitle();
    
    default String getHeader() {return "";}

    List<Menu> getMenus();

}
