package com.np.biblioteka;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.net.URL;

public class MP3Player {
    private URL url;
    private Player player;

    public MP3Player(URL url) {
        this.url = url;
    }

    public void close() {
        if (player != null)
            player.close();
    }

    public void play() {
        try {
            BufferedInputStream bis = new BufferedInputStream(url.openStream());
            player = new Player(bis);
        }
        catch (Exception e) {
            System.out.println("Problem playing file " + url);
            e.printStackTrace();
        }

        new Thread(() -> {
            try {
                player.play();
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }).start();
    }
}
