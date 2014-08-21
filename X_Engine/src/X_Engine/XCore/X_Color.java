package X_Engine.XCore;

import org.newdawn.slick.Color;

public class X_Color {
	public Color color;
	public int r,g,b;
	public float alpha = 1.0f;
	
	public X_Color(int r, int g, int b){
		setColor(r, g, b);
	}
	
	public X_Color(){
		
	}
	
	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
		this.color.a = alpha;
	}

	public void setColor(int r, int g, int b) {
		Color col = new Color(r,g,b);
		
		this.color = col;
		this.color.a = alpha;
		this.r = r;
		this.g = g;
		this.b = b;

	}
	
	
}
