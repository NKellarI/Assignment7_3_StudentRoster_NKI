/**
 * 
 */

/**
 * @author Noah Isaac
 */
public class Menu {
	private String[] toDraw;
	public Menu(String menuName) 
	{
		toDraw = new String[]{"","","","","","",""};
		System.out.print(menuName);
		System.out.println("##############################################");
	}
	public void drawElements(boolean isNewLine) 
	{
		for(int i = 0; i < toDraw.length; i++) 
		{
			if(isNewLine) {
			System.out.println(toDraw[i]);
			}else {System.out.print(toDraw[i]);}
		}
	}
	public void drawElement(boolean isNewLine, int index) 
	{
		if(isNewLine) {
			System.out.println(toDraw[index]);
			}else {System.out.print(toDraw[index]);}
	}
	public String[] getToDraw() {
		return toDraw;
	}
	public void setToDraw(String[] toDraw) {
		this.toDraw = toDraw;
	}
	
}
