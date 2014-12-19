package ch.bfh.shooter.assets;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by jan on 04/11/14.
 */
public class Sound {

    public static Clip shoot = getSound("/sounds/lasershoot.wav");
    public static Clip intro = getSound("/sounds/intro.wav");
    public static Clip gameMusic = getSound("/sounds/gamemusic.wav");
    public static Clip heart = getSound("/sounds/heart.wav");
    public static Clip hurt = getSound("/sounds/hurt.wav");
    public static Clip select = getSound("/sounds/select.wav");
    public static Clip emptygun = getSound("/sounds/emptygun.wav");

    private static Clip getSound(String path) {

        URL url = Sound.class.getResource(path);
        Clip clip = null;
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        return clip;

    }

    public static void play(Clip clip) {
        if (clip.isActive()) {
            clip.stop();
        }

        clip.setFramePosition(0);
        clip.start();
    }

    public static void loop(Clip clip) {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void stop(Clip clip) {
        clip.stop();
    }



}
