package appControl;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Random;

//Description: Plays a sound file
//input: file path
public class SoundPlayer {
	private static Clip soundTrackClip;
	public static void playSound(String fileName) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(new File("src/test/resources/sounds/" + fileName + ".wav")));
			clip.start();

		} catch (Exception e) {
			System.out.println("Error with playing sound.");
			e.printStackTrace();
		}

	}

	// Play random sound given an array of sound names
	public static void playRandomSound(String[] sounds) {
		int rnd = new Random().nextInt(sounds.length);
		playSound(sounds[rnd]);
	}

	public static void startSoundTrack() {
		try {
			soundTrackClip = AudioSystem.getClip();
			soundTrackClip.open(AudioSystem.getAudioInputStream(new File("src/test/resources/sounds/soundtrack.wav")));
			soundTrackClip.loop(Clip.LOOP_CONTINUOUSLY);

		} catch (Exception e) {
			System.out.println("Error with playing sound.");
			e.printStackTrace();
		}
	}
	public static void stopSoundTrack() {
		try {
			soundTrackClip.stop();
		} catch (Exception e) {
			System.out.println("Error, no sound running");
		}
	}


}