package X_Engine.XCore;

public class X_FPS {
	
	public static X_Timer timer = new X_Timer();
	public static long lastFPS;
	public static int fps;
	public static int curr_FPS;
	
	
	public static void updateFPS(){
		if (timer.getTime() > lastFPS) {	
			curr_FPS = fps;
			fps = 0;
			lastFPS = timer.getTime()+1000;
		}
		fps++;		
	}
	
	public static int getFPS(){
		return curr_FPS;
	}
}
