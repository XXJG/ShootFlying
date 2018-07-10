package class1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class game1panel extends JPanel implements MouseMotionListener{//单继承  多接口  
//定义小球的坐标  直径  方向
	int x=100,y=100,d=50,f=0;
	int px=100,py=500,pw=200;
	/*
	 * 开始修饰游戏
	 */
	int score=0;
	int speed=1;
	//定义一个小球的颜色
	Color ballcolor;
//	boolean t=false;
	int t=0;
	//构造方法完成初始化
	public game1panel(){
		addMouseMotionListener(this);   //添加响应
		
		
	}
	
 public void paint(Graphics g)
 {
	super.paint(g);
	g.setColor(ballcolor);
	g.fillOval(x, y, d, d);
	g.setColor(Color.black);
	//将graphics转化为graphics2D  
	Graphics2D g2=(Graphics2D)g;
	//g2设置一个厚度值
	g2.setStroke(new BasicStroke(10.0f));
	//通过graphics2d进行绘画
	g.drawLine(px, py, px+pw, py);
	
	//设置得分
	g.setColor(Color.red);
	g.drawString("得分："+score, 300, 50);
	if(t!=0)
	{
		g.setFont(new Font("黑体",Font.BOLD,40));
		g.drawString("Game Over", 130, 200);}
 }
 public void startBall(){
	 new Thread(){
		 public void run(){
			 while(true)
			 {
				 //1
				 if(f==0){x+=speed;y+=speed;}
				 if(f==1){x-=speed;y+=speed;}
				 if(f==2){x-=speed;y-=speed;}
				 if(f==3){x+=speed;y-=speed;}
				 //判断小球是否更改方向
				 if(x<=0){if(f==2) f=3;//左边
				 else f=0;}
				 if(y<=0){if(f==3) f=0;//上边
				 else f=1;}
				 if(x>=400-d-10){//右边
					if(f==0) f=1;
					else f=2;
				 }
				 if(y>=py-d){//下边		
					if(x+d/2>=px&&x+d/2<=px+pw)//在挡板范围内
					{
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
					//更改得分
					
					else {   //不在挡板范围内
					  t=1;
					  repaint();
					  this.stop();
					}
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
 //鼠标拖动
@Override
public void mouseDragged(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
//鼠标移动
@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	px=e.getX()-pw/2;
}
}
