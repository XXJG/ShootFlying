package RWgui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class RWguipanel extends JPanel{
	int x=300;
	int y=320;
	
public void paint(Graphics g)
{
Graphics2D g2 = (Graphics2D)g;
super.paint(g);
g.setColor(new Color(0,128,64));//ªÊ÷∆¬∑æ∂
g.fillRect(150,0, 360,768);
setBackground(Color.white);
//Õ∑
g.setColor(Color.yellow);
g.fillOval(x, y, 70, 100);
//—€æ¶
g.setColor(Color.black);
g.fillOval(x+10, y+30, 10, 10);
g.fillOval(x+50, y+30, 10, 10);


//Ω≈

g.setColor(Color.yellow); 
g.fillOval(x-100, y+150, 60, 40); 
g.fillOval(x+115, y+160, 60, 40);
g.fillOval(x-95, y+275, 60, 40);
g.fillOval(x+100, y+280, 60, 40);

//Œ≤∞Õ
g.setColor(Color.yellow); 
g.fillOval(x+20, y+345,30, 60); 
//±≥ 

	g.setColor(Color.green);
   g.fillOval(x-50, y+99, 170, 250);

//±≥œﬂ
g.setColor(Color.black);
g2.setStroke(new BasicStroke(2.0f));
g.drawLine(x+5, y+150, x+75, y+150);
g.drawLine(x-5, y+115, x+5, y+150);
g.drawLine(x+75, y+150, x+90, y+130);
g.drawLine(x-49,y+210,x+120,y+210);//
g.drawLine(x+5,y+280,x+75,y+280);
g.drawLine(x+5,y+280,x-30,y+300);
g.drawLine(x+100,y+300,x+75,y+280);
g.drawLine(x+35, y+100, x+32, y+350);
//◊÷ÃÂ…Ë÷√
g.setFont(new Font("∑¬ÀŒ", Font.BOLD, 30));
g.drawString("--designed by xjg", 700, 680);
}
public void startgui()
{
	
new Thread(){
	public void run(){
	while(true)
	{	y--;
	 
	if(y+345==0) y=768;
		repaint();
		try {
			Thread.sleep(8);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
}.start();	
}
}
