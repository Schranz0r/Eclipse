package XE_Core;


public class XE_FPS {
	
	private static XE_Timer timer = new XE_Timer();
	private static long lastFPS;
	private static int fps;
	private static int curr_FPS;
	
	
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
