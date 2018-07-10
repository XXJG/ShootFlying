package class1pratice;

import javax.swing.JFrame;

public class jfgame1 extends JFrame{
	public jfgame1(){
		this.setTitle("¥Ú«Ú");
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jpgame1 jpg = new jpgame1();
		jpg.startball();
		jpg.startball2();
		this.add(jpg);
		this.setResizable(false);
		this.show();
	}
	public static void main(String[] args) {
	new jfgame1();	
	}

}
