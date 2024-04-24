import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AppSounds {
    private Clip backgroundMusic;
    private static final String BACKGROUND_MUSIC_FILE_PATH = "C:\\Users\\Janrich\\Desktop\\ITE186\\src\\Bg.wav";
    private static final String EASY_SOUND_FILE_PATH = "C:\\Users\\Janrich\\Desktop\\ITE186\\src\\Easy.wav";

    public AppSounds() {
    }

    public void playBackgroundMusic() {
        try {
            File audioFile = new File(BACKGROUND_MUSIC_FILE_PATH);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioStream);
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    public void stopBackgroundMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
        }
    }

    public void playEasySound() {
        try {
            File audio = new File(EASY_SOUND_FILE_PATH);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audio);
            Clip soundClip = AudioSystem.getClip();
            soundClip.open(audioStream);
            soundClip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
}
