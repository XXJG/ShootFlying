package class1pratice;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class jpgame1 extends JPanel implements MouseMotionListener{
int x=100,y=100,d=50,f=0;
int px=100,py=500,pw=200;
int score=0;
int speed=1;
int t=0;
int qx=150,qy=160;
	Color ballcolor;
	public jpgame1(){
		addMouseMotionListener(this);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2=(Graphics2D)g;
		g.setColor(ballcolor);
		g.fillOval(x, y, d, d);
		g.setColor(Color.black);
		g2.setStroke(new BasicStroke(10.0f));
		g.drawLine(px, py, px+pw, py);
		g.setColor(Color.red);
		g.drawString("得分:"+score, 300, 50);
		if(t!=0)
		{
			g.setFont(new Font("黑体",Font.BOLD,40));
			g.drawString("Game Over", 130, 200);}
		if(score>10)
		{
			g.fillOval(qx, qy, d, d);
			
		}
		
	}

public void startball(){
	new Thread(){
		public void run(){
			while(true){
			if(f==0)  {x+=speed;y+=speed;}
			if(f==1) {x-=speed;y+=speed;}
			if(f==2) {x-=speed;y-=speed;}
			if(f==3) {x+=speed;y-=speed;}
			if(x<=0)  {if(f==2) f=3;
			else f=0;}
			if(y<=0)  {
				if(f==3) f=0;
				else f=1;
			}
			if(x>=400-d-10){
				if(f==0) f=1;
				else f=2;
			}
			if(y==py-d)
			{
				if(x+d/2>=px&&x+d/2<=px+pw){
				if(f==1) f=2;
				 else f=3;
				 score+=5;
				 //根据得分挡板变短
				 if(score%20==0){if(pw>=d)pw-=20;}
				 if(score%10==0){speed+=1;}
				 //根据随机数更改球的颜色
				 int r=(int)(Math.random()*256);
				 int g=(int)(Math.random()*256);
				 int b=(int)(Math.random()*256);
				 ballcolor =new Color(r,g,b);	
			}	
			else{
				t=1;
				repaint();
				this.stop();
				
			}}
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
public void startball2(){
	new Thread(){
		public void run(){
		while(true){
			if(f==0)  {qx+=speed;qy+=speed;}
			if(f==1) {qx-=speed;qy+=speed;}
			if(f==2) {qx-=speed;qy-=speed;}
			if(f==3) {qx+=speed;qy-=speed;}
			if(qx<=0)  {if(f==2) f=3;
			else f=0;}
			if(qy<=0)  {
				if(f==3) f=0;
				else f=1;
			}
			if(qx>=400-d-10){
				if(f==0) f=1;
				else f=2;
			}
			if(qy==py-d)
			{
				if(qx+d/2>=px&&x+d/2<=px+pw){
				if(f==1) f=2;
				 else f=3;
				 score+=5;
				 //根据得分挡板变短
				 if(score%20==0){if(pw>=d)pw-=20;}
				 if(score%10==0){speed+=1;}
				 //根据随机数更改球的颜色
				 int r=(int)(Math.random()*256);
				 int g=(int)(Math.random()*256);
				 int b=(int)(Math.random()*256);
				 ballcolor =new Color(r,g,b);	
			}	
			else{
				t=1;
				repaint();
				this.stop();
				
			}}
			repaint();
			
			
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
	}.start();
}

@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	px=e.getX()-pw/2;
}
}
