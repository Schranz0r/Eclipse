package XE_3D;

import java.util.ArrayList;
import java.util.List;


public class XE_Camera {
	public static List<XE_Camera> cameras = new ArrayList<XE_Camera>();
	public static int activeCamera = -1;
	public static boolean needUpdate;
	
	
	private int CamID;							// unique Camera-ID
	private float camX, camY, camZ;				// cameraposition 
	private float rotX, rotY, rotZ;				// rotations

	
	
	private int genCameraID(){
		return cameras.size();
	}


	public XE_Camera(){
		this.CamID = genCameraID();
		setCameraToList(this);
		// set created cam to actual cam!
		activeCamera = this.CamID;	
		
	}
	
	public XE_Camera(float camX, float camY, float camZ){
		this.CamID = genCameraID();
		setCameraToList(this);
		SetCamera(camX, camY, camZ, 0, 180, 0);
		// set created cam to actual cam!
		activeCamera = this.CamID;
		
	}
	

	public void SetCamera(float camX, float camY, float camZ, float rotX, float rotY, float rotZ){

		cameras.get(this.CamID).setCamX(camX);
		cameras.get(this.CamID).setCamY(camY);
		cameras.get(this.CamID).setCamZ(camZ);
		
		cameras.get(this.CamID).setRotX(rotX);
		cameras.get(this.CamID).setRotY(rotY+180);
		cameras.get(this.CamID).setRotZ(rotZ);	
		
		needUpdate = true;
	}
	
	
	public void rotateYaw(float phi){
		if(this.rotY != phi){
			cameras.get(this.CamID).rotY +=phi;
			needUpdate = true;
		}
	}
	
	public void rotatePitch(float phi){
		if(this.rotX != phi){
			if(this.rotX >= 89.99f)
				this.rotX = 89.99f;
			if(this.rotX <= -89.99f)
				this.rotX = -89.99f;
			cameras.get(this.CamID).rotX +=phi;
			needUpdate = true;
		}
	}
	
	public void rotateRoll(float phi){
		if(this.rotZ != phi){
			cameras.get(this.CamID).rotZ +=phi;
			needUpdate = true;
		}
	}
	
	public void moveForward(float speed){
			cameras.get(this.CamID).camZ -= speed *Math.sin(Math.toRadians(cameras.get(this.CamID).rotY + 90));
			cameras.get(this.CamID).camX -= speed *Math.cos(Math.toRadians(cameras.get(this.CamID).rotY + 90));
			needUpdate = true;
	}
	
	public void moveBackward(float speed){
		cameras.get(this.CamID).camZ += speed *Math.sin(Math.toRadians(cameras.get(this.CamID).rotY + 90));
		cameras.get(this.CamID).camX += speed *Math.cos(Math.toRadians(cameras.get(this.CamID).rotY + 90));
		needUpdate = true;
	}
	
	public void moveLeft(float speed){
		cameras.get(this.CamID).camZ += speed *Math.sin(Math.toRadians(cameras.get(this.CamID).rotY+180));
		cameras.get(this.CamID).camX += speed *Math.cos(Math.toRadians(cameras.get(this.CamID).rotY+180));
		needUpdate = true;
	}

	public void moveRight(float speed){
		cameras.get(this.CamID).camZ += speed *Math.sin(Math.toRadians(cameras.get(this.CamID).rotY));
		cameras.get(this.CamID).camX += speed *Math.cos(Math.toRadians(cameras.get(this.CamID).rotY));
		needUpdate = true;
	}

	public void moveUp(float speed){
		cameras.get(this.CamID).camY += speed;
		needUpdate = true;
	}	

	public void moveDown(float speed){
		cameras.get(this.CamID).camY -= speed;
		needUpdate = true;
	}	
	
	private void setCameraToList(XE_Camera cam){
		cameras.add(cam);
	}
	
	public static int getActiveCamera() {
		return activeCamera;
	}

	public void setActive() {
		if(activeCamera != this.CamID){
			activeCamera = this.CamID;
			needUpdate = true;
		}
	}

	public float getCamX() {
		return camX;
	}

	public void setCamX(float camX) {
		this.camX = camX;
	}

	public float getCamY() {
		return camY;
	}

	public void setCamY(float camY) {
		this.camY = camY;
	}

	public float getCamZ() {
		return camZ;
	}

	public void setCamZ(float camZ) {
		this.camZ = camZ;
	}

	public float getRotX() {
		return rotX;
	}


	public void setRotX(float rotX) {
		this.rotX = rotX;
	}


	public float getRotY() {
		return rotY;
	}


	public void setRotY(float rotY) {
		this.rotY = rotY;
	}


	public float getRotZ() {
		return rotZ;
	}


	public void setRotZ(float rotZ) {
		this.rotZ = rotZ;
	}
	
}
