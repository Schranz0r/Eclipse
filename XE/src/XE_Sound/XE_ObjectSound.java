package XE_Sound;

import java.io.IOException;
import java.util.regex.Pattern;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

public class XE_ObjectSound {
	private Audio sound;
	private String name;
	private String filetype;
	
	public void loadWavSound(String file){
		
		String[] split = file.split(Pattern.quote( "." )); // ex:  "res/sounds/bing.wav"
		
		this.filetype = split[1].toUpperCase();	
		
		try {
			sound = AudioLoader.getAudio(filetype,ResourceLoader.getResourceAsStream(file));
			this.setName(file);
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

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
}
