package com.np.biblioteka;

import com.np.biblioteka.mvc.MVC;

import java.io.IOException;
import java.util.logging.Logger;

public class Biblioteka {

    private static final Logger logger = Logger.getLogger(Biblioteka.class.getName());
    private static Biblioteka instance;

    public static Biblioteka getInstance() {
        if(instance == null) {
            instance = new Biblioteka();
        }
        return instance;
    }


    private Display display;

    private Biblioteka() {
        try {
            display = new Display();

        }
        catch(IOException e) {
            logger.severe("Could not create display");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void start() {
        MVC.controller();
    }


    public static Logger getLogger() {
        return logger;
    }

    public Display getDisplay() {
        return display;
    }
}
