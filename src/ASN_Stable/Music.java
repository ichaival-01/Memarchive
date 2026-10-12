package ASN_Stable;

import javax.sound.sampled.*;
import java.net.*;

public class Music {

    Clip clip;

    public void setFile(URL name) {
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(name);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) {
            System.out.println("I can't find the audio");
        }
    }

    public void play() {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
        } else {
            System.out.println("Audio clip not initialized. Call setFile() first.");
        }
    }

    public void loop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } else {
            System.out.println("Audio clip not initialized. Call setFile() first.");
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        } else {
            System.out.println("No audio is currently playing.");
        }
    }
}