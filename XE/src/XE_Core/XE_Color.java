package XE_Core;

import org.newdawn.slick.Color;

public class XE_Color {
	public Color color;
	
	public XE_Color(){
		
	}
	
	public XE_Color(int r, int g, int b){	
		setColor(r, g, b, 100);
	}
	
	public XE_Color(int r, int g, int b, int a){
		setColor(r, g, b, a);
	}	
	
	public void setColor(int r, int g, int b, int a){
		// limit alpha 
		if(a > 100 )
			a = 100;	
		if(a < 0)
			a = 0;
		
		color = new Color((float)r/255, (float)g/255, (float)b/255, (float)a/100);

	}
	
	public int getR(){
		return color.getRed();
	}
	public int getG(){
		return color.getGreen();
	}
	public int getB(){
		return color.getBlue();
	}
	
	public int getRf(){
		return color.getRed()/255;
	}
	public int getGf(){
		return color.getGreen()/255;
	}
	public int getBf(){
		return color.getBlue()/255;
	}
	
	public int getAlpha(){
		return (int)(color.a*100f);
	}
	public void setAlpha(int alpha){
		this.color.a = (float)alpha/100;
	}	
	public float getAlphaf(){
		return color.a;
	}
	
}
