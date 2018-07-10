package day2moon;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class moonpanel extends JPanel{
	int x=300,y=100;
public void paint(Graphics g)
{
super.paint(g);
setBackground(Color.black);
g.setColor(Color.white);
g.fillOval(100, 100, 50, 50);
g.setColor(Color.black);
g.fillOval(x, y, 50, 50);
}
public void startmoon(){
	new Thread(){
		public void run()
		{
			while(true)
			{	x--;
			if(x==0) x=300;
			repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
	}.start();
}
}