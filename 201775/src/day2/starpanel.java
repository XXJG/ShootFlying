package day2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class starpanel extends JPanel{
	
	int x[]=new int[1024];
	int y[]=new int[768];
	//���췽�� ��ʼ������
	public starpanel(){
		Random ran=new Random();
	for(int i=0;i<500;i++)
	{
		
	x[i]=ran.nextInt(1024);
	y[i]=ran.nextInt(768);
	}}
	
public void paint(Graphics g)
{
	
super.paint(g);
setBackground(Color.black);
for(int k=0;k<300;k++)
{
	g.setFont(new Font("",Font.PLAIN,30));
g.setColor(Color.white);
g.drawString("*", x[k],y[k]);
}

}
/*public void run()
{
	
while(true)
{	y++;
try {
	Thread.sleep(20);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
repaint();
}	
}*/
//�߳�  ���������ڲ���
public void startstar(){
	new Thread(){
		public void run()
		{
		while(true)
			{
			for(int j=0;j<500;j++){
				if(j%2==0)   //ʵ���ٶȵĲ�ͬ
		y[j]=y[j]+2;
		else y[j]++;
		if(y[j]>768) y[j]=0;
		}
		try {
			Thread.sleep(10);//����
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
				
	}
		}
	}.start();//ͬ�������󣬶�����÷���
}
}
