package com.np.biblioteka.mvc.view.user;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.np.biblioteka.Display;
import com.np.biblioteka.mvc.view.View;

import java.util.Collections;

public class IndexView extends View {

    public IndexView() {

    }

    @Override
    public void render() {
        Display display = getDisplay();

        BasicWindow window = new BasicWindow();

        Panel panel = new Panel();
        panel.setFillColorOverride(TextColor.ANSI.BLUE);
        panel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
        panel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
        window.setHints(Collections.singletonList(Window.Hint.FULL_SCREEN));

        Label logo = new Label(Display.imageToAsciiArt("image/logo.jpg", 20, 20))
                .setBackgroundColor(TextColor.ANSI.BLUE)
                .setForegroundColor(TextColor.ANSI.WHITE);
        panel.addComponent(logo);

        display.getGui().addWindowAndWait(window);
    }
}
