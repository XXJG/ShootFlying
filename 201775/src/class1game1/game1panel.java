package class1game1;

import java.awt.Graphics;

import javax.swing.JPanel;

public class game1panel extends JPanel{
//����С�������  ֱ��  ����
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
				 //�ж�С���Ƿ���ķ���
				 if(x==0){if(f==2) f=3;//���
				 else f=0;}
				 if(y==0){if(f==3) f=0;//�ϱ�
				 else f=1;}
				 if(x==400-d-10){//�ұ�
					if(f==0) f=1;
					else f=2;
				 }
				 if(y==600-d-30){//�±�		
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
