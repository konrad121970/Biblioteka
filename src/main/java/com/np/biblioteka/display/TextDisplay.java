package com.np.biblioteka.display;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.screen.VirtualScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class TextDisplay implements Display {

    private final Terminal terminal;
    private final Screen screen;
    private final VirtualScreen virtualScreen;
    private final MultiWindowTextGUI gui;

    public TextDisplay() throws IOException {
        this.terminal = new DefaultTerminalFactory().createTerminal();
        this.screen = new TerminalScreen(terminal);
        this.virtualScreen = new VirtualScreen(screen);

        virtualScreen.setMinimumSize(new TerminalSize(50, 30));
        this.gui = new MultiWindowTextGUI(virtualScreen);
        virtualScreen.startScreen();
    }


    public Terminal getTerminal() {
        return terminal;
    }

    public Screen getScreen() {
        return screen;
    }

    public VirtualScreen getVirtualScreen() {
        return virtualScreen;
    }

    public MultiWindowTextGUI getGui() {
        return gui;
    }
}
