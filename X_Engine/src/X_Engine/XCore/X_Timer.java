package X_Engine.XCore;

public class X_Timer {
	
	private long time;
	private int delta;
	private long lastFrame;
	
	
	public long getTime(){
		return System.nanoTime() / 1000000;
	}
	
	public int getDelta(){
		this.time = getTime();
		if(this.delta == 0 && this.lastFrame == 0){
			this.lastFrame = getTime();
		}
		this.delta = (int) (time - lastFrame);
		lastFrame = time;
		return delta;
	}

}
