package com.amanu.interview.display;

import com.amanu.interview.view.View;

/**
 * @author Amanuel Nega on November 08, 2018.
 */
public class CLIGameDisplay extends IOStreamGameDisplay {

    CLIGameDisplay() {
        super(System.out, System.in);
    }

    @Override
    public void draw(View view) {
        //TODO Clear the cli first, then call super
        super.draw(view);
    }
}
