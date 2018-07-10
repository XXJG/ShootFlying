package RWgui;

import javax.swing.JFrame;

public class RWguiframe extends JFrame{
	public RWguiframe(){
		this.setTitle("±¼ÅÜµÄÐ¡ÎÚ¹ê");
		this.setSize(1024, 768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RWguipanel rwp=new RWguipanel();
		rwp.startgui();
		this.setResizable(false);
		this.add(rwp);
		this.setVisible(true);
		
	}
public static void main(String[] args) {
	new RWguiframe();
}
}
