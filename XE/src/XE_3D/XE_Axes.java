package XE_3D;

import static org.lwjgl.opengl.GL11.*;

public class XE_Axes {
	private int listHandle = glGenLists(1);
	private float size;
	
	public XE_Axes(float size){
		this.size = size;
		create(size);
	}
	
	
	public void setSize(float size){
		this.size = size;
		if(this.size != size)
			create(size);
	}
	
	public float getSize() {
		return size;
	}	
	
	public void draw(float x, float y, float z){

		// new matrix to translate
		glPushMatrix();
			
			// move object to position 
			glTranslatef(x, y, z);		
			
			// draw the ListObject
			glCallList(listHandle);
			
		// back to normal matrix	
		glPopMatrix();

	}
	
	private void create(float size){
		this.size = size;
			
			glLineWidth(1f*size);
			
			// create a new List to compile
			glNewList(listHandle, GL_COMPILE);			
			glBegin(GL_LINES);
				// Y = green
				glColor3f(0f, 1f*size, 0f);
				// Y-Line
		    	glVertex3f(0f, 0f, 0f);
		    	glVertex3f(0f, 1f*size, 0f);
		    	// Y-Arrow 
		    	glVertex3f(0f, 1f*size, 0f);
		    	glVertex3f(0.125f*size, 0.75f*size, 0f);
		    	glVertex3f(0f, 1f*size, 0f);
		    	glVertex3f(-0.125f*size, 0.75f*size, 0f);
		    	glVertex3f(0.125f*size, 0.75f*size, 0f);
		    	glVertex3f(-0.125f*size, 0.75f*size, 0f);
		    	
		    	glVertex3f(0f, 1f*size, 0f);
		    	glVertex3f(0f, 0.75f*size, 0.125f*size);
		    	glVertex3f(0f, 1f*size, 0f);
		    	glVertex3f(0f, 0.75f*size, -0.125f*size);
		    	glVertex3f(0f, 0.75f*size, 0.125f*size);
		    	glVertex3f(0f, 0.75f*size, -0.125f*size);		    		    		    	
		    	
				// X = red
				glColor3f(1f*size, 0f, 0f);
				// X-Line
		    	glVertex3f(0f, 0f, 0f);
		    	glVertex3f(1f*size, 0f, 0f);
		    	// X-Arrow 
		    	glVertex3f(1f*size, 0f, 0f);
		    	glVertex3f(0.75f*size, 0f, 0.125f*size);
		    	glVertex3f(1f*size, 0f, 0f);
		    	glVertex3f(0.75f*size, 0f, -0.125f*size);
		    	glVertex3f(0.75f*size, 0f, 0.125f*size);
		    	glVertex3f(0.75f*size, 0f, -0.125f*size);
		    	
		    	glVertex3f(1f*size, 0f, 0f);
		    	glVertex3f(0.75f*size, 0.125f*size, 0f);
		    	glVertex3f(1f*size, 0f, 0f);
		    	glVertex3f(0.75f*size, -0.125f*size, 0f);
		    	glVertex3f(0.75f*size, 0.125f*size, 0f);
		    	glVertex3f(0.75f*size, -0.125f*size, 0f);			    	
	
				// Z = blue
				glColor3f(0f, 0f, 1f*size);
				// Z-Line
		    	glVertex3f(0f, 0f, 0f);
		    	glVertex3f(0f, 0f, 1f*size);
		    	// Z-Arrow 
		    	glVertex3f(0f, 0f, 1f*size);
		    	glVertex3f(0.125f*size, 0f, 0.75f*size);
		    	glVertex3f(0f, 0f, 1f*size);
		    	glVertex3f(-0.125f*size, 0f, 0.75f*size);
		    	glVertex3f(0.125f*size, 0f, 0.75f*size);
		    	glVertex3f(-0.125f*size, 0f, 0.75f*size);
		    	
		    	glVertex3f(0f, 0f, 1f*size);
		    	glVertex3f(0f, 0.125f*size, 0.75f*size);
		    	glVertex3f(0f, 0f, 1f*size);
		    	glVertex3f(0f, -0.125f*size, 0.75f*size);
		    	glVertex3f(0f, 0.125f*size, 0.75f*size);
		    	glVertex3f(0f, -0.125f*size, 0.75f*size);
		    	
		    	
		    glEnd();
		    glEndList();
		
	}
	
	
	
}
