package com.np.biblioteka.mvc.view;

import com.np.biblioteka.Biblioteka;
import com.np.biblioteka.Display;

public abstract class View implements Renderable {

    private final Display display;

    public View() {
        display = Biblioteka.getInstance().getDisplay();
    }

    public Display getDisplay() {
        return display;
    }
}
