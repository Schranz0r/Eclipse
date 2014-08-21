package X_Engine.X2D;

import org.lwjgl.opengl.GL11;
;

public class X_Sprite extends X_Object2D {
	
	public float textureOffsetX, textureOffsetY;	// Tex-Offset to calculate the Spriteposition in the Image
	public int gridSizeX, gridSizeY;				// gridsize to "cut" the image into Sprites
	public float sprSizeX, sprSizeY;				// spritesize X / Y in float <= 0.5  <--- 0.5 = 2 Sprites in this direction 
	public float selectX, selectY;					// the gridposition of the selected Sprite
	public int selectSprID = 0;
	
	public void setGridSize(int x, int y){
		this.gridSizeX = x;
		this.gridSizeY = y;
		
		//Log.debug("sizeX: "+sizeX);
		//Log.debug("sizeY: "+sizeY);
		textureOffsetX = (float)sizeX/(float)gridSizeX;		// exemple : 100px texturesize / 25px spritesize = 4 Sprites in X
		//Log.debug("textureOffsetX: "+textureOffsetX);
		textureOffsetY = (float)sizeY/(float)gridSizeY;
		//Log.debug("textureOffsetY: "+textureOffsetY);
		reCalculateSpriteGrid();
	}
	
	private void reCalculateSpriteGrid(){
		this.sprSizeX = 1.0f / textureOffsetX;		// exemple : 1.0 / 4 = 0.25   <---- Spritesize in the texturecoordinate!!
		//Log.debug("sprSizeX: "+sprSizeX);
		this.sprSizeY = 1.0f / textureOffsetY;		//exemple :  1.0 / 4 = 0.25    <---- Spritesize in the texturecoordinate!!
		//Log.debug("sprSizeY: "+sprSizeY);
	}
	
	public void select(int num){
		//Log.debug("NUM: "+num);
		this.selectSprID = num;						// example : 5
		
		float posS = (float)num / (float)textureOffsetX;				// exemple : 5/4 = 1.25
		//Log.debug("posS: "+posS);
		
		this.selectY = (float)(int)posS * sprSizeY;		// exemple : selectY = 1 * 0.25  == 0.25
		//Log.debug("selectY: "+selectY);
		
		this.selectX = posS - (int)posS;			// exemple : selectX = 1.25 - 1  == 0.25
		//Log.debug("selectX: "+selectX);
	}
	
	
	@Override
	public void updateRect(){
		this.rect.setLocation(posX, posY);
		this.rect.setSize(gridSizeX, gridSizeY);
	}
	
	@Override
	public void draw(int x, int y){
		//Log.debug("OVERRIDE: TRUE");
		setPosition(x, y);
		updateRect();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		texture.bind();
		GL11.glPushMatrix();
		GL11.glTranslated(offsetX, offsetY, 0);
		GL11.glRotatef(rotation, 0, 0, 1);
		float sprX = selectX+sprSizeX;
		float sprY = selectY+sprSizeY;
		//Log.debug("sprX: "+sprX);
		//Log.debug("sprY: "+sprY);
		GL11.glColor3f(color.color.r, color.color.g, color.color.b);
		GL11.glBegin(GL11.GL_QUADS);
			//lefttop
			GL11.glTexCoord2f(selectX, 							selectY);
			GL11.glVertex2f((float)x, 							(float)y);
			//righttop
			GL11.glTexCoord2f(sprX, 							selectY);
			GL11.glVertex2f((float)x+(float)gridSizeX*scale, 	(float)y);
			//rightbottom
			GL11.glTexCoord2f(sprX,								sprY);
			GL11.glVertex2f((float)x+(float)gridSizeX*scale, 	(float)y+(float)gridSizeY*scale);
			//leftbottom
			GL11.glTexCoord2f(selectX, 							sprY);
			GL11.glVertex2f((float)x, 							(float)y+(float)gridSizeY*scale);	
		GL11.glEnd();
		GL11.glPopMatrix();
		
	}

}
