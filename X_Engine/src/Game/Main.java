package Game;

import X_Engine.XCore.X_Color;
import X_Engine.XCore.X_Display;
import X_Engine.XCore.X_FPS;
import X_Engine.XCore.X_INFO;


public class Main {
	

	public static void main(String[] args){
		
		int WIDTH = 800;
		int HEIGHT = 600;
		String TITLE = X_INFO.NAME+" "+X_INFO.VERSION;
			
		X_Display display = new X_Display();
		display.setDisplay(WIDTH, HEIGHT, TITLE);
		display.setDisplayTo3D(45,0.2f, 1000.0f);
		
		
		X_Color col = new X_Color(255,255,255);
		
		
		while(!display.isCloseRequested()){
			display.clearColor(col);
			
			
			
			
			display.setTitle(TITLE+"     -     FPS: "+X_FPS.getFPS());
			display.update();
		}
		
		display.closeDisplay();
		
	}	
	
}
