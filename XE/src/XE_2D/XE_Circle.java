package XE_2D;

import static org.lwjgl.opengl.GL11.*;
import XE_Core.XE_Color;

public class XE_Circle extends XE_Object2D{
	
	private int radius;
	private XE_Color center_color = new XE_Color(255,255,255,100);
	private XE_Color outer_color = new XE_Color(255,255,255,100);
	
	
	public void setRadius(int radius){
		this.radius = radius;
		this.width = radius*2;
		this.height = radius*2;
		color = new XE_Color(255, 255, 255, 100);
		createListObject();
	}
	
	public int getRadius() {
		return radius;
	}

	public XE_Color getCenterColor() {
		return center_color;
	}

	public void setCenterColor(XE_Color center_color) {
		this.center_color = center_color;
	}

	public XE_Color getOuterCcolor() {
		return outer_color;
	}

	public void setOuterColor(XE_Color outer_color) {
		this.outer_color = outer_color;
	}

	@Override
	public void createListObject(){
		// create a new List to compile
		glNewList(listHandle, GL_COMPILE);	
		glBegin(GL_TRIANGLE_FAN);
		
		// centerpoint of the circle
		glColor4f(center_color.getRf(), center_color.getGf(), center_color.getBf(), center_color.getAlphaf());
		glVertex2f(radius, radius);
		
		glColor4f(outer_color.getRf(), outer_color.getGf(), outer_color.getBf(), outer_color.getAlphaf());
		
			for(int i = 0; i<368; i+=8){
				glVertex2f(radius+(float)Math.sin(Math.toRadians(i))*radius,radius+(float)Math.cos(Math.toRadians(i))*radius);
			}
			
		// end drawing
		glEnd();
		
		// end the list 
		glEndList();		
		
		
	}
	
	@Override
	public void draw(int x, int y){
		
		// set position variables, we need it later on for collisions and stuff
		this.posx = x;
		this.posy = y;
		
		// is collision enabled then
		// set position of the rectangle for collision !
		if(enableCollision){
			getRect().setPosition(x, y);
		}
		
		glDisable(GL_TEXTURE_2D);
		
		
		// new matrix to translate
		glPushMatrix();
			
			// move object to position 
			glTranslatef(posx, posy, 0);
			
			// set color
			glColor4f(getColor().getR(), getColor().getG(), getColor().getB(), getColor().getAlphaf());			
			
			// draw the ListObject
			glCallList(listHandle);
			
		// back to normal matrix	
		glPopMatrix();
		
		// disable texturing again, maybe we want to draw a solid?!
		glDisable(GL_TEXTURE_2D);
	}

}