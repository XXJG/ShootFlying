package addcalss1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Ballallpanel extends JPanel implements MouseListener,MouseMotionListener{
	//定义一个集合用于存小球
  List<Ball> balls=new ArrayList<Ball>();
  //定义小球对象
  Ball ball;//代码优化
  Ball b1,b2;
  BallAndBall bac;
  int score;
  int pt=0;
  //构造方法
  int px=100,py=100,d=30;
  
  public Ballallpanel(){
	  
	  for (int i = 0; i < 5; i++) {
		addBall();
	}
	  //调用addBall 方法
		//给鼠标添加监听
	addMouseListener(this);
	addMouseMotionListener(this);
	
  }
  //自定义方法用于生成小球
  public void addBall(){
	  //通过随机数完成小球属性
	  int x=(int)(Math.random()*750);
	  int y=(int)(Math.random()*550);
	  int direction=(int)(Math.random()*4);
	  int speed=(int)(Math.random()*5+1);
	  int diameter=(int )(Math.random()*50+10);
	  int r=(int)(Math.random()*256);
		 int g=(int)(Math.random()*256);
		 int b=(int)(Math.random()*256);
		Color ballcolor =new Color(r,g,b);
		 ball=new Ball(x, y, direction, speed, diameter, ballcolor);//类对象化
		balls.add(ball);       //添加到集合中 
  }
  
  //实现画的方法
  
  public void paint(Graphics g)
  {
	  super.paint(g);
	  //通过一个循环完成每个小球的绘制
	  for (int i = 0; i < balls.size(); i++) {
		ball=balls.get(i);
		//调用当前小球的画的方法                调用
		ball.drawball(g);
	}
	 
	 g.drawString("得分："+score, 550, 50);
	  g.fillOval(px, py, d, d);
	  if(pt!=0)
	  {
	
		  g.drawString("Game Over", 300, 200);
	  }
  }
  public void startBall(){
	  new Thread(){
		  
		  public void run(){
			  while(true){
				  for (int i = 0; i <balls.size(); i++) {
					 ball=balls.get(i);
					 ball.moveBall();
				}
				for (int j = 0; j< balls.size(); j++) {
				b2=balls.get(j);
					bac=new BallAndBall();
					boolean f=bac.getBallcollision(px, py, d, b2);
					if(f){
						if(d>b2.diameter)
						{
							d+=b2.diameter;
							balls.remove(j);
							score=score+5;
							break;
						}
						if(d<=b2.diameter)
						{
							pt=1;
							repaint();
							this.stop();
						}
					
						
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
@Override//鼠标单击事件
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	addBall();
}
@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override//鼠标移出
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override//鼠标按钮压下事件
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override//按钮释放抬起
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseDragged(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	px=e.getX()-d/2;
	py=e.getY()-d/2;
}
  
}

//小球移动
 /* public void startballs(){
	  new Thread(){
		public void run()  {
			while(true)
			{    
				for (int i = 0; i <balls.size(); i++) {
					 if(balls.get(i).direction==0){balls.get(i).x+=balls.get(i).speed;balls.get(i).y+=balls.get(i).speed;}
					 if(balls.get(i).direction==1){balls.get(i).x-=balls.get(i).speed;balls.get(i).y+=balls.get(i).speed;}
					 if(balls.get(i).direction==2){balls.get(i).x-=balls.get(i).speed;balls.get(i).y-=balls.get(i).speed;}
					 if(balls.get(i).direction==3){balls.get(i).x+=balls.get(i).speed;balls.get(i).y-=balls.get(i).speed;}
					 //判断小球是否更改方向
					 if(balls.get(i).x<=0){if(balls.get(i).direction==2) balls.get(i).direction=3;//左边
					 else balls.get(i).direction=0;}
					 if(balls.get(i).y<=0){if(balls.get(i).direction==3) balls.get(i).direction=0;//上边
					 else balls.get(i).direction=1;}
					 if(balls.get(i).x>=800-balls.get(i).diameter-10){//右边
						if(balls.get(i).direction==0) balls.get(i).direction=1;
						else balls.get(i).direction=2;
					 }
					if(balls.get(i).y>=600-balls.get(i).diameter-20)//下边
					{
						 if(balls.get(i).direction==1) balls.get(i).direction=2;
						 else balls.get(i).direction=3;
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
  }*/

