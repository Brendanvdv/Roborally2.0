package rebuild;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import java.io.File;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

//Description: Plays a sound file
//input: file path
public class SoundPlayer {
    public static void playSound(String fileName) {
        //Start a new thread be able to play multiple sounds at the same time
        new Thread(() -> {
            //Create a new count down latch to wait for the sound to finish playing
            CountDownLatch syncLatch = new CountDownLatch(1);

            try {
                Clip clip = AudioSystem.getClip();

                //add a listener to the clip to be able to wait for the sound to finish playing
                clip.addLineListener(e -> {
                    if (e.getType() == LineEvent.Type.STOP) {
                        syncLatch.countDown();
                    }
                });

                //load the sound file into the clip and start playing it
                clip.open(AudioSystem.getAudioInputStream(new File("src/test/resources/sounds/" + fileName + ".wav")));
                clip.start();
                syncLatch.await();

            } catch (Exception e) {
                System.out.println("Error with playing sound.");
                e.printStackTrace();
            }

        }).start();

    }
    
    //Play random sound given an array of sound names
    public static void playRandomSound(String[] sounds) {
    	int rnd = new Random().nextInt(sounds.length);
    	playSound(sounds[rnd]);
    }

}


