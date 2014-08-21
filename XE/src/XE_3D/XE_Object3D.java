package XE_3D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

public class XE_Object3D {
	private Vector3f pos;
	private List<Float> verts = new ArrayList<Float>();
	private Float[] vertices = new Float[]{1f, 1f, 0f, 1f, 0f, 0f, 0f, 0f, 0f,};
	
	
	public Vector3f getPos() {
		return pos;
	}

	public void setPos(Vector3f pos) {
		this.pos = pos;
	}
	
	
	public void load(){
		verts.addAll(Arrays.asList(vertices));
	}
	/*
	public void draw(float x, float y, float z){
		this.pos.x = x;
		this.pos.y = y;
		this.pos.z = z;
		
		glLoadIdentity();
		glTranslatef(pos.x, pos.y, pos.z);
		glVertexPointer(3, GL_FLOAT, 0, vertices);
		glDrawArrays(GL_TRIANGLES, 0, vertices);
	}
	*/
}
