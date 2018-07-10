package day2moon;

import javax.swing.JFrame;

public class moojframe extends JFrame{
public moojframe(){
	this.setTitle("MoonLight");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(1024, 768);
	moonpanel mp =new moonpanel();
	mp.startmoon();
	this.add(mp);
	this.show();
	
}
public static void main(String[] args) {
	moojframe mjf=new moojframe();
	mjf.show();
}
}
