package X_Engine.XSound;

import java.io.IOException;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

public class X_Sound {
	
	public Audio sound;
	public String name;
	
	public void loadWavSound(String file){
		try {
			sound = AudioLoader.getAudio("WAV",ResourceLoader.getResourceAsStream(file));
			this.name = file;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void playSound(float pitch, float gain, boolean loop){
		sound.playAsSoundEffect(pitch, gain, loop);
	}
	
	public boolean isPlaying(){
		return sound.isPlaying();
	}
	
}
