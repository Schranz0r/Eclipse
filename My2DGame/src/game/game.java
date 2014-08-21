package game;



import java.util.Random;

import org.lwjgl.Sys;
import org.newdawn.slick.util.Log;

import static org.lwjgl.opengl.GL11.*;
import XE_2D.XE_Circle;
import XE_2D.XE_CollisionRect;
import XE_2D.XE_Image;
import XE_Core.XE_Color;
import XE_Core.XE_Display;
import XE_Core.XE_FPS;
import XE_Core.XE_Mouse;

@SuppressWarnings("unused")
public class game {
	
	
	public static final String TITLE = "My2DGame - XE-Engine BETA_0.8";
	public static int WIDTH 	= 800;
	public static int HEIGHT 	= 600;
	public static int FRAMERATE = 60;
	
	public static XE_Image img;
	public static XE_Image img2;
	
	public static XE_Circle cir;
	
	public static Random rnd = new Random();
	
	public static float scale = 1f;
	public static float rotation;
	
	
	public static void main(String[] args){
		
		try {
			// init the game
			init();
			// run the mainloop
			run();
		} catch (Exception e) {
			e.printStackTrace();
			Sys.alert(TITLE, "An error occured and the game will exit.");
		} finally {
			// clear all up on error
			clear();
		}
		
	}
	
	
	public static void init() throws Exception{
		XE_Display.init(WIDTH, HEIGHT);
		XE_Display.setInterval(FRAMERATE);
		XE_Display.setTitle(TITLE);
		XE_Display.setIcon("res/icons/icon16.png", "res/icons/icon32.png");
		XE_CollisionRect.showDebug();
		
		
		img = new XE_Image();
		img.loadImage("res/icons/icon32.png");
		img.enableCollision();
		
		img2 = new XE_Image();
		img2.setHandle(8, 8);
		img2.loadImage("res/icons/icon16.png");
		img2.enableCollision();
		
		cir = new XE_Circle();
		cir.setOuterColor(new XE_Color(255,255,255,1));
		cir.setRadius(25);
		cir.enableCollision();
		
	}
	
	public static void run(){
		while(!XE_Display.isCloseRequested()){
			input();
			render();
			update();
		}
		clear();
	}
	
	public static void input(){
		// input and logic here!
		scale += 0.01;
		rotation += 1.2f;
	}
	
	public static void render(){
		// draw stuff here!
		//img.setScale(scale);
		
		img.setScale(scale);
		img.draw(20, 20);
		img2.setRotation(rotation);
		img2.draw(200, 200);
		
		if(img.isCollision(img2))
			Log.debug("HOLY SHIT!");
		
		cir.setCenterColor(new XE_Color(rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255),100));
		cir.draw(0, 0);
		
	}
	
	public static void update(){	
		XE_FPS.updateFPS();
		XE_Display.setTitle(TITLE+"           ---          FPS: "+XE_FPS.getFPS());
		XE_Display.update();
		XE_Display.clear(255,255,255);
	}
	
	public static void clear(){
		XE_Display.destroy();
	}
	
	
	
}
