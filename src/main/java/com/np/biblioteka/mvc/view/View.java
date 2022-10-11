package com.np.biblioteka.mvc.view;

import com.np.biblioteka.Biblioteka;
import com.np.biblioteka.display.Display;

public abstract class View implements Renderable {

    private Display display;

    public View() {
        display = Biblioteka.getInstance().getDisplay();
    }
}
