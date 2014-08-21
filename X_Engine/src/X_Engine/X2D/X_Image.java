package X_Engine.X2D;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;


public class X_Image extends X_Object2D {
	
	int vertices = 3;
	int vertex_size = 3; //x, y, z
	int color_size = 3; //r,g,b
	FloatBuffer vertex_data = BufferUtils.createFloatBuffer(vertices*vertex_size);
	FloatBuffer color_data = BufferUtils.createFloatBuffer(vertices*color_size);
	int vbo_vertex_handle = glGenBuffers();
	int vbo_color_handle = glGenBuffers();
	
	public void createVBO(){
		
		
		vertex_data.put(new float[] {-1f, -1f, 0f});
		vertex_data.put(new float[] {1f, -1f, 0f});
		vertex_data.put(new float[] {1f, 1f, 0f});
		vertex_data.flip();
		
		
		
		color_data.put(new float[] {1f, 0f, 0f});
		color_data.put(new float[] {0f, 1f, 0f});
		color_data.put(new float[] {0f, 0f, 1f});
		color_data.flip();
		
		
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo_vertex_handle);
		glBufferData(GL_ARRAY_BUFFER, vertex_data, GL_STATIC_DRAW);
		glBindBuffer(GL_ARRAY_BUFFER, 0); //release the Buffer
		
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo_color_handle);
		glBufferData(GL_ARRAY_BUFFER, color_data, GL_STATIC_DRAW);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		
	}
	
	@Override
	public void draw(int x, int y){
		glBindBuffer(GL_ARRAY_BUFFER, vbo_vertex_handle);
		glVertexPointer(vertex_size, GL_FLOAT, 0, 0l);
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo_color_handle);
		glColorPointer(color_size, GL_FLOAT, 0, 0l);
		
		glEnableClientState(GL_VERTEX_ARRAY);
		glEnableClientState(GL_COLOR_ARRAY);
		
		glDrawArrays(GL_TRIANGLES, 0, vertices);
		
		glDisableClientState(GL_VERTEX_ARRAY);
		glDisableClientState(GL_COLOR_ARRAY);
		
	}
	
	public void delete(){
		glDeleteBuffers(vbo_vertex_handle);
		glDeleteBuffers(vbo_color_handle);
	}
}
