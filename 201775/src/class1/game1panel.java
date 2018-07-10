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

public class game1panel extends JPanel implements MouseMotionListener{//���̳�  ��ӿ�  
//����С�������  ֱ��  ����
	int x=100,y=100,d=50,f=0;
	int px=100,py=500,pw=200;
	/*
	 * ��ʼ������Ϸ
	 */
	int score=0;
	int speed=1;
	//����һ��С�����ɫ
	Color ballcolor;
//	boolean t=false;
	int t=0;
	//���췽����ɳ�ʼ��
	public game1panel(){
		addMouseMotionListener(this);   //�����Ӧ
		
		
	}
	
 public void paint(Graphics g)
 {
	super.paint(g);
	g.setColor(ballcolor);
	g.fillOval(x, y, d, d);
	g.setColor(Color.black);
	//��graphicsת��Ϊgraphics2D  
	Graphics2D g2=(Graphics2D)g;
	//g2����һ�����ֵ
	g2.setStroke(new BasicStroke(10.0f));
	//ͨ��graphics2d���л滭
	g.drawLine(px, py, px+pw, py);
	
	//���õ÷�
	g.setColor(Color.red);
	g.drawString("�÷֣�"+score, 300, 50);
	if(t!=0)
	{
		g.setFont(new Font("����",Font.BOLD,40));
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
				 //�ж�С���Ƿ���ķ���
				 if(x<=0){if(f==2) f=3;//���
				 else f=0;}
				 if(y<=0){if(f==3) f=0;//�ϱ�
				 else f=1;}
				 if(x>=400-d-10){//�ұ�
					if(f==0) f=1;
					else f=2;
				 }
				 if(y>=py-d){//�±�		
					if(x+d/2>=px&&x+d/2<=px+pw)//�ڵ��巶Χ��
					{
						 if(f==1) f=2;
						 else f=3;
						 score+=5;
						 //���ݵ÷ֵ�����
						 if(score%20==0){if(pw>=d)pw-=20;}
						 if(score%10==0){speed+=1;}
						 //������������������ɫ
						 int r=(int)(Math.random()*256);
						 int g=(int)(Math.random()*256);
						 int b=(int)(Math.random()*256);
						 ballcolor =new Color(r,g,b);
					}
					//���ĵ÷�
					
					else {   //���ڵ��巶Χ��
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
 //����϶�
@Override
public void mouseDragged(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
//����ƶ�
@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	px=e.getX()-pw/2;
}
}
