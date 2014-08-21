package XE_2D;

public class XE_Rect extends XE_Object2D{
	
	public XE_Rect(){
		
	}
	
	public XE_Rect(int x, int y, int width, int height){
		
		this.setPosx(x);
		this.setPosy(y);
		this.setWidth(width);
		this.setHeight(height);
		
		createListObject();
	
	}	
	
}
