package wugui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
/*
 * 
 * 增加粗线、使用graphics2d
 * 增加写字 fonts
 */
public class DrawWugui extends JPanel{
	int x=420;int y=103;
public void paint(Graphics g)
{ Graphics2D g2 = (Graphics2D)g;
	
	super.paint(g);
	setBackground(Color.white);
	//头
	g.setColor(Color.yellow);
	g.fillOval(x, y, 70, 100);
	//眼睛
	g.setColor(Color.black);
	g.fillOval(x+10, y+30, 10, 10);
	g.fillOval(x+50, y+30, 10, 10);
	
    
	//脚
    g.setColor(Color.yellow); 
    g.fillOval(x-100, y+150, 60, 40); 
    g.fillOval(x+115, y+160, 60, 40);
    g.fillOval(x-95, y+275, 60, 40);
    g.fillOval(x+100, y+280, 60, 40);
    //尾巴
    g.setColor(Color.yellow); 
    g.fillOval(x+20, y+345,30, 60); 
   //背 
	
   	g.setColor(Color.green);
       g.fillOval(x-50, y+99, 170, 250);
    
    //背线
    g.setColor(Color.black);
    g2.setStroke(new BasicStroke(2.0f));
    g.drawLine(x+5, y+150, x+75, y+150);
    g.drawLine(x-5, y+115, x+5, y+150);
    g.drawLine(x+75, y+150, x+90, y+130);
    g.drawLine(x-49,y+210,x+120,y+210);//
    g.drawLine(x+5,y+280,x+75,y+280);
    g.drawLine(x+5,y+280,x-30,y+300);
    g.drawLine(x+100,y+300,x+75,y+280);
    g.drawLine(x+35, y+100, x+32, y+350);//
 
    //字体设置
    g.setFont(new Font("楷体", Font.PLAIN, 30));
    g.drawString("--designed by xjg", 600, 600);
}
/*public void startgui(){
new	Thread(){
	public void run(){
	while(true)
	{
		x++;
		repaint();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}	
}.start();

}	*/
}
