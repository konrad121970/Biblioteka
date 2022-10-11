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

    private Terminal terminal;
    private Screen screen;
    private VirtualScreen virtualScreen;
    private MultiWindowTextGUI gui;

    public TextDisplay() throws IOException {
        this.terminal = new DefaultTerminalFactory().createTerminal();
        this.screen = new TerminalScreen(terminal);
        this.virtualScreen = new VirtualScreen(screen);

        virtualScreen.setMinimumSize(new TerminalSize(50, 30));
        this.gui = new MultiWindowTextGUI(virtualScreen);
        virtualScreen.startScreen();
    }



}
