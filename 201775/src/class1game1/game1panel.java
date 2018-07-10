package class1game1;

import java.awt.Graphics;

import javax.swing.JPanel;

public class game1panel extends JPanel{
//定义小球的坐标  直径  方向
	int x=100,y=100,d=50,f=0;
 public void paint(Graphics g)
 {
	super.paint(g);
	g.fillOval(x, y, d, d);
	 
 }
 public void startBall(){
	 new Thread(){
		 public void run(){
			 while(true)
			 {
				 //1
				 if(f==0){x++;y++;}
				 if(f==1){x--;y++;}
				 if(f==2){x--;y--;}
				 if(f==3){x++;y--;}
				 //判断小球是否更改方向
				 if(x==0){if(f==2) f=3;//左边
				 else f=0;}
				 if(y==0){if(f==3) f=0;//上边
				 else f=1;}
				 if(x==400-d-10){//右边
					if(f==0) f=1;
					else f=2;
				 }
				 if(y==600-d-30){//下边		
					 if(f==1) f=2;
					 else f=3;
				 }
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
