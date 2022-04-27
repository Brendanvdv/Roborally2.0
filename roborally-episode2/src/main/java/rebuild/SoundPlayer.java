package rebuild;
package com.company;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import java.io.File;
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
				clip.open(AudioSystem.getAudioInputStream(new File(fileName + ".wav")));
				clip.start();
				syncLatch.await();

			} catch (Exception e) {
				System.out.println("Error with playing sound.");
				e.printStackTrace();
			}

		}).start();

	}

	public static void startMainTheme() {
		playSound("src/com/company/sound/mainTheme");
	}
}
