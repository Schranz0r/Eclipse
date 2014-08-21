package X_Engine.XInput;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class X_Mouse {
	
	public static boolean isButtonDown(int buttonnumber){
		if(Mouse.isButtonDown(buttonnumber)){
			return true;
		}else{
			return false;
		}
	}

	public static int getX() {
		return Mouse.getX();
	}

	public static int getY() {
		return Display.getHeight()-1-Mouse.getY();
	}
	
	
	
}
