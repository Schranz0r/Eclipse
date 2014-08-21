package X_Engine.XCore;

import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.glu.GLU;

public class X_Display {

	public int RefreshRate = 60;
	public boolean VSync = true;
	public int Width;
	public int Height;
	public int Fov;
	public float zNear, zFar;
	@SuppressWarnings("unused")
	private boolean is3D;
	
	
	public void setDisplay(int width, int height, String title){
		try {
			Width = width;
			Height = height;
			
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(title);
			Display.setSwapInterval(RefreshRate);
			Display.setVSyncEnabled(VSync);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	public void setDisplayTo3D(int Fov, float zNear, float zFar){
		this.Fov = Fov;
		this.zNear = zNear;
		this.zFar = zFar;
		this.is3D = true;
		
		glEnable(GL_DEPTH_TEST);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluPerspective(Fov, (float)Width/(float)Height, zNear, zFar);
		glMatrixMode(GL_MODELVIEW);
	}
	
	public void setDisplayTo2D(){
		this.is3D = false;
		glEnable(GL_TEXTURE_2D);
		glShadeModel(GL_SMOOTH);        
		glDisable(GL_DEPTH_TEST);
		glDisable(GL_LIGHTING);                    
 
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);                
        glClearDepth(1);                                       
 
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
 
        glViewport(0,0,Width,Height);
		glMatrixMode(GL_MODELVIEW);
 
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Width, Height, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}	
	public boolean isCloseRequested(){
		return Display.isCloseRequested();
	}
	
	public void closeDisplay(){
		AL.destroy();
		Display.destroy();
	}
	
	public void update(){
		X_FPS.updateFPS();
		Display.update();
	}
	
	public void clear(){
		glClear(GL_COLOR_BUFFER_BIT);	
	}
	
	public void clearColor(X_Color color){
		glClear(GL_COLOR_BUFFER_BIT);
		glClearColor(color.color.r, color.color.g, color.color.b, color.color.a);
	}
	
	public void setTitle(String title){
		Display.setTitle(title);
	}
}
