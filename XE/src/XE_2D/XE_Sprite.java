package XE_2D;

import static org.lwjgl.opengl.GL11.*;



public class XE_Sprite extends XE_Object2D{
	
	private float texCoordSizeX, texCoordSizeY;
	private int tileSizeX, tileSizeY;
	private int tilesX, tilesY;
	private int imageSizeX, imageSizeY;
	private int selectedSprite = -1;
	private float spritePosX, spritePosY;
	
	public void loadSprite(String file, int tilesX, int tilesY){
		
		// create a new textureload instance
		imageloader = new XE_ImageLoader();
		
		// load the texture in the loader
		imageloader.loadTexture(file);
		
		// set isTextured to true
		this.isTextured = true;
		
		// set tiles on X and Y direction 
		this.tilesX = tilesX;
		this.tilesY = tilesY;
		
		// sprite.png = x128 * y128; 
		this.imageSizeX = imageloader.texture.getImageWidth();
		this.imageSizeY = imageloader.texture.getImageHeight();
		
		// split : tileSize = imagesize / tiles  ->  x = 32, y = 32
		this.tileSizeX = imageSizeX / tilesX;
		this.tileSizeY = imageSizeY / tilesY;
		
		// TexCoordSize per Tile  -> 0.25f;
		this.texCoordSizeX = (1f/(float)imageSizeX) * (float)tileSizeX;
		this.texCoordSizeY = (1f/(float)imageSizeY) * (float)tileSizeY;
		
	}
	
	public void selectSprite(int num){
		// limit the selected number!
		if(num > tilesX*tilesY-1)
			num = tilesX*tilesY-1;
		
		if(num < 0)
			num = 0;
			
		// if num is changed?! -> Redo the ListObject! Speed up the display!
		if(num != selectedSprite){
			
			this.selectedSprite = num;
			
			// num = 6 -----> must be for this example 1.5f
			float tile = (float)num / (float)tilesX;
			
			// get pos in Y-Direction -----> 0.25
			spritePosY = (int)tile*texCoordSizeY;
			
			// get pos in X-Direction  ----> 0.5
			spritePosX = tile-(int)tile;		
			
			createListObject();
			
		}
	}
	
	@Override
	public void createListObject(){
		
		// create a new List to compile
		glNewList(listHandle, GL_COMPILE);
		
		// begin drawing to the list
		glBegin(GL_QUADS);
		
			// draw the vertices
			glTexCoord2f(spritePosX, spritePosY);
			glVertex2i(0, 0);			// top-left
			
			glTexCoord2f(spritePosX+texCoordSizeX, spritePosY);
			glVertex2i(tileSizeX, 0);		// top-right
			
			glTexCoord2f(spritePosX+texCoordSizeX, spritePosY+texCoordSizeY);
			glVertex2i(tileSizeX, tileSizeY);	// bottom-right
			
			glTexCoord2f(spritePosX, spritePosY+texCoordSizeY);
			glVertex2i(0, tileSizeY);		// bottom-left
			
		// end drawing
		glEnd();
		
		// end the list 
		glEndList();
		
	}
	
	
}
