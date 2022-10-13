package com.np.biblioteka;

import com.github.lalyos.jfiglet.FigletFont;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.screen.VirtualScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;
import org.alcibiade.asciiart.coord.TextBoxSize;
import org.alcibiade.asciiart.image.rasterize.ShapeRasterizer;
import org.alcibiade.asciiart.raster.ExtensibleCharacterRaster;
import org.alcibiade.asciiart.raster.Raster;
import org.alcibiade.asciiart.raster.RasterContext;
import org.alcibiade.asciiart.widget.PictureWidget;
import org.alcibiade.asciiart.widget.TextWidget;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Display {

    private final SwingTerminalFrame terminal;
    private final Screen screen;
    private final VirtualScreen virtualScreen;
    private final MultiWindowTextGUI gui;

    public Display() throws IOException {
        this.terminal = new DefaultTerminalFactory().createSwingTerminal();
        terminal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        terminal.setVisible(true);
        terminal.setExtendedState(SwingTerminalFrame.MAXIMIZED_BOTH);

        this.screen = new TerminalScreen(terminal);
        this.virtualScreen = new VirtualScreen(screen);
        this.gui = new MultiWindowTextGUI(virtualScreen);

        virtualScreen.setMinimumSize(new TerminalSize(50, 20));
        virtualScreen.startScreen();

        screen.doResizeIfNecessary();
        screen.startScreen();
        screen.setCursorPosition(null);
    }


    public static String imageToAsciiArt(String imagePath, int w, int h) {
        URL fileURL = Display.class.getClassLoader().getResource(imagePath);
        File image = new File(fileURL.getPath());
        try {
            BufferedImage bufferedImage = ImageIO.read(image);
            TextWidget widget = new PictureWidget(new TextBoxSize(w, h), bufferedImage, new ShapeRasterizer());
            Raster raster = new ExtensibleCharacterRaster();
            widget.render(new RasterContext(raster));
            return raster.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String generateAsciiArt(String text) {
        try {
            return FigletFont.convertOneLine(text);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
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
