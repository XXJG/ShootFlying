package class76;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Ballallpanel extends JPanel implements MouseListener{
	//����һ���������ڴ�С��
  List<Ball> balls=new ArrayList<Ball>();
  //����С�����
  Ball ball;//�����Ż�
  Ball b1,b2;
  BallAndBall bac;
  //
  int px=100,py=100,d=50;
 // int score;
  //���췽��
  public Ballallpanel(){
	  
	  for (int i = 0; i < 2; i++) {
		addBall();
	}
	  //����addBall ����
		//�������Ӽ���
		addMouseListener(this);
	
  }
  //�Զ��巽����������С��
  public void addBall(){
	  //ͨ����������С������
	  int x=(int)(Math.random()*750);
	  int y=(int)(Math.random()*550);
	  int direction=(int)(Math.random()*4);
	  int speed=(int)(Math.random()*5+1);
	  int diameter=(int )(Math.random()*50+10);
	  int r=(int)(Math.random()*256);
		 int g=(int)(Math.random()*256);
		 int b=(int)(Math.random()*256);
		Color ballcolor =new Color(r,g,b);
		 ball=new Ball(x, y, direction, speed, diameter, ballcolor);//�����
		balls.add(ball);       //��ӵ������� 
  }
  
  //ʵ�ֻ��ķ���
  
  public void paint(Graphics g)
  {
	  super.paint(g);
	  //ͨ��һ��ѭ�����ÿ��С��Ļ���
	  for (int i = 0; i < balls.size(); i++) {
		ball=balls.get(i);
		//���õ�ǰС��Ļ��ķ���                ����
		ball.drawball(g);
	}
	 // g.drawString("�÷֣�"+score, 550, 50);
	  g.fillOval(px, py, d, d);
  }
  public void startBall(){
	  new Thread(){
		  
		  public void run(){
			  while(true){
				  for (int i = 0; i <balls.size(); i++) {
					 ball=balls.get(i);
					 ball.moveBall();
				}
				  for (int j = 0; j < balls.size()-1; j++) {
					b1=balls.get(j);
					for (int i = j+1; i < balls.size(); i++) {
						b2=balls.get(i);
						bac=new BallAndBall();
					//	bac.ballcollision(b1, b2);
						boolean f=bac.getBallcollision(b1, b2);
						if(f){
							if(b1.diameter>b2.diameter){
								b1.diameter+=b2.diameter;
								balls.remove(i);
							//	score=score+5;
								break;
								
							}
							if(b1.diameter<b2.diameter){
								b2.diameter+=b1.diameter;
								balls.remove(i);
						//		score=score+5;
								break;
							}
								
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
@Override//��굥���¼�
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	addBall();
}
@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override//����Ƴ�
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override//��갴ťѹ���¼�
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override//��ť�ͷ�̧��
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
  
}

//С���ƶ�
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
					 //�ж�С���Ƿ���ķ���
					 if(balls.get(i).x<=0){if(balls.get(i).direction==2) balls.get(i).direction=3;//���
					 else balls.get(i).direction=0;}
					 if(balls.get(i).y<=0){if(balls.get(i).direction==3) balls.get(i).direction=0;//�ϱ�
					 else balls.get(i).direction=1;}
					 if(balls.get(i).x>=800-balls.get(i).diameter-10){//�ұ�
						if(balls.get(i).direction==0) balls.get(i).direction=1;
						else balls.get(i).direction=2;
					 }
					if(balls.get(i).y>=600-balls.get(i).diameter-20)//�±�
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

