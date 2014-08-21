package X_Engine.X2D;

import java.awt.Rectangle;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import X_Engine.XCore.X_Color;
import X_Engine.XInput.X_Mouse;

public abstract class X_Object2D {
	
	public int posX, posY;					// position X / Y
	public int sizeX, sizeY;				// Imagesize X / Y
	public int offsetX, offsetY;			// Offset to set new Origin
	public float orgtexX, orgtexY;			// start of the texture for textureatlas X / Y
	public float texX, texY;				// texturesize 1.0 = 100% texturesize
	public float scale = 1.0f;				// Texturescale 1.0 = normal < 1.0 slower the size > 1.0 make it bigger
	public float rotation;					// Rotation of the sprite, WATCH OUT: rotation breaks the collision detection
	public Texture texture;					// Texturehandle
	public String texturename;				// texturename
	public X_Color color = new X_Color();	// color of the texture
	public Rectangle rect;					// rectangle for the collisioncheck  


	
	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
		updateRect();
	}	
	
	public void setSize(int x, int y){
		if(rect == null)
			rect = new Rectangle(posX, posY, sizeX, sizeY);	
		
		updateRect();
		this.setSizeX(x);
		this.setSizeY(y);
	
	}
	
	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
		updateRect();
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
		updateRect();
	}
	
	public X_Color getColor() {
		return color;
	}

	public void setColor(X_Color color) {
		this.color = color;
	}
	
	public void setColor(int r, int g, int b) {
		color.setColor(r, g, b);
	}
	
	public void setPosition(int x, int y){
		this.posX = x;
		this.posY = y;
	}
	
	public void setRotationAbsolut(float rotation){
		this.rotation = rotation;
	}
	
	public void loadTexture(String file){
		try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(file));
			
			this.texturename = file;
			this.sizeX = texture.getImageWidth();
			this.sizeY = texture.getImageHeight();
			this.texX = texture.getWidth();
			this.texY = texture.getHeight();		
			
			this.rect = new Rectangle(posX, posY, sizeX, sizeY);
			this.color.setColor(255, 255, 255);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void draw(int x, int y){
		setPosition(x, y);
		updateRect();
		if(texture == null){
			glDisable(GL_TEXTURE_2D);
		}else{
			glEnable(GL_TEXTURE_2D);
			texture.bind();
		}
		glPushMatrix();
		glTranslated(offsetX, offsetY, 0);
		glRotatef(rotation, 0, 0, 1);
		glColor3f(color.color.r, color.color.g, color.color.b);
		glBegin(GL_QUADS);
			//lefttop
			glTexCoord2f(0, 0);
			glVertex2f((float)x, (float)y);
			//righttop
			glTexCoord2f(texX, 0);
			glVertex2f((float)x+(float)sizeX*scale, (float)y);
			//rightbottom
			glTexCoord2f(texX,texY);
			glVertex2f((float)x+(float)sizeX*scale, (float)y+(float)sizeY*scale);
			//leftbottom
			glTexCoord2f(0, texY);
			glVertex2f((float)x, (float)y+(float)sizeY*scale);	
		glEnd();
		glPopMatrix();
		
	}
	

	public void updateRect(){
		this.rect.setLocation(posX, posY);
		this.rect.setSize(sizeX, sizeY);
	}
	
	public boolean isCollision(X_Object2D other){
		return this.rect.intersects(other.rect);
	}
	
	public boolean isMouseOver(){
		return this.rect.contains(X_Mouse.getX(), X_Mouse.getY());
	}
	
	public void unload(){
		if(texture == null){
			// nothing to do
		}else{
			texture.release();
		}
	}
}
