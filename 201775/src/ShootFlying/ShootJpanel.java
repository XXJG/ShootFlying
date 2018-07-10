package ShootFlying;

import java.awt.BasicStroke;

import java.applet.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.audio.*;

public class ShootJpanel extends JPanel implements MouseMotionListener,MouseListener,Runnable {
	//����һ��ͼƬ��������
	static Image startImg;
	int x=0,y=0;
	//����һ�������ͱ��������жϵ����¼�
	boolean ck=true;
	//�������߳������
	Thread t;
	//////����һ�������ͱ���������Ϸ����ͣ��ָ�
	boolean suspend=false;
	//����һ��Ӣ�ۻ��Ķ�������
	static Image p[]=new Image[2];
	int px=100,py=100;
	//����������±��ʶ
	int pc=0;
	Bullet bullet;
	Bullet bullet1;
    Bullet bullet2;
    Bullet bullet3;
	//����һ���������ڹ����ڵ�
	List<Bullet> bullets=new ArrayList<Bullet>();
	List<Bullet> bullets1=new ArrayList<Bullet>();//�л��ڵ�
	List<Bullet> bullets2=new ArrayList<Bullet>();
	List<Bullet> bullets3=new ArrayList<Bullet>();
	
	List<AwardPh> awardphs=new ArrayList<AwardPh>();
	//�����ڵ�
	static Image bImg;
	static Image ebImg;
	static Image bgbImg;
	static Image award;
	static Image awardphImg;
	//��ɻ�	
	int bghp=100;
	int bgx=150;
	int bgy=50;
	int bgscore=100;
	int ax=400;
	int f=0;//��ɻ�����
	static Image bgImg;
	int acount1;
	//����һ�����ͱ������ڼ����ڵ�
	int count=0;
	int acount=0;
	int phx=  0;
	int phy = 100;
	//�л�������������
	List<Elan> elans=new ArrayList<Elan>();
	Elan elan;
	AwardPh awardph;
	int score=0;
	int php=50;
	
	static{
		try {
			//InputStream in = new FileInputStream("sounds/gamestart.wav");
			
			startImg=ImageIO.read(new File("images/GameInterface/interface_1.png"));
			p[0]=ImageIO.read(new File("images/1.png"));
			p[1]=ImageIO.read(new File("images/1.png"));
			bImg=ImageIO.read(new File("images/bullet/bullet_1.png"));
			ebImg=ImageIO.read(new File("images/bullet/bullet_7.png"));
			bgImg=ImageIO.read(new File("images/BossPlane/plane_"+(int)(Math.random()*3+1)+".png"));
			bgbImg=ImageIO.read(new File("images/bullet/bullet_7.png"));
			award=ImageIO.read(new File("images/award/award_"+(int)(Math.random()*2+1)+".png"));
		    awardphImg=ImageIO.read(new File("images/award_1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//���췽��
	public ShootJpanel(){
		addMouseMotionListener(this);
		addMouseListener(this);
		t=new Thread(this);
		
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2=(Graphics2D)g;
		g.drawImage(startImg, x, y, null);

		//���ڵ�
		for (int i = 0; i < bullets.size(); i++) {
			bullet=bullets.get(i);
			bullet .drawBullet(g);

		}
		
		for (int i = 0; i < bullets1.size(); i++) {
			bullet1=bullets1.get(i);
			bullet1.drawBullet(g);

		}
		//������
		if(y>=-5100&&y<-5000){
			
			for (int i = 0; i < awardphs.size(); i++) {
				awardph = awardphs.get(i);
				awardph.drawAward(g);
			}
			
		}
		if(y>=-3100&&y<=-3000){
			for (int i = 0; i < awardphs.size(); i++) {
				awardph = awardphs.get(i);
				awardph.drawAward(g);
			}
		}
		if(y>=-2100&&y<=-2000){
			for (int i = 0; i < awardphs.size(); i++) {
				awardph = awardphs.get(i);
				awardph.drawAward(g);
			}
		}
		//����ɻ�
		if(ck==false&&y>=-1500)
		{ 
			for (int i = 0; i < bullets2.size(); i++) {
				bullet2=bullets2.get(i);
				bullet2.drawBullet(g);
			}
			for (int i = 0; i < bullets3.size(); i++) {
				bullet3=bullets3.get(i);
				bullet3.drawBullet(g);
			}
			g.drawImage(bgImg, bgx, bgy, null);

		
			//Ѫ��
		  g.setColor(Color.red);
		  g2.setStroke(new BasicStroke(15.0f));
		  g.drawLine(0, 0,ax, 0);
		}
		
		if(acount1!=0){
			g.setColor(Color.red);
			
			g.drawString("Good Boy!", 180, 150);
			g.drawImage(award,180,100,null);
			acount1=0;
		}
		//���л������÷���drawElan
		for (int i = 0; i < elans.size(); i++) {
			elan=elans.get(i);
			elan.drawElan(g);
		}
		//��Ӣ�ۻ�
		if(ck==false){
			pc=pc==0?1:0;
			g.drawImage(p[pc], px, py, null);
		}
		if(ck==false){
			g.setColor(Color.red);
			g.drawString("�÷֣�"+score, 300, 50);
			g.drawString("������"+php, 200, 50);
		}

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	//	System.out.println(e.getX());
		if(ck&&e.getX()>=131&&e.getX()<=264&&e.getY()>=396&&e.getY()<=436){
			//��������ͼ��ΪС��
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		else if(acount!=0&&ck&&e.getX()>=128&&e.getX()<=296&&e.getY()>=311&&e.getY()<=365){
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		else if(ck==false){
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		else{
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		//����������������Ӣ�ۻ�
		px=e.getX()-p[pc].getWidth(null)/2;
		py=e.getY()-p[pc].getHeight(null)/2;

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		//������
		if(acount==0&&e.getModifiers()==e.BUTTON1_MASK&&ck&&e.getX()>=131&&e.getX()<=264&&e.getY()>=396&&e.getY()<=436){
			//����ckֵ
			ck=false;
			//������Ϸ������y����ֵ
			y=-5400;
			//������Ϸ������ͼ
			try {
				
				startImg=ImageIO.read(new File("images/background/background_"+(int)(Math.random()*4+1)+".png"));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//�������߳�
			t.start();
		}
		if(acount!=0&&e.getModifiers()==e.BUTTON1_MASK&&ck&&e.getX()>=128&&e.getX()<=296&&e.getY()>=311&&e.getY()<=365){
             
			//repaint();
			ck=false;
			//������ֵ����Ϊ50������ͼƬû�и�����ԭ��
			php = 50;
			//����ӵ�����
			for (int i = 0; i < bullets.size(); i++) {
				bullets.remove(i);
				i --;
			}
			for (int i = 0; i < bullets1.size(); i++) {
				bullets1.remove(i);
				i --;
			}
			for (int i = 0; i < bullets2.size(); i++) {
				bullets2.remove(i);
				i --;
			}
			for (int i = 0; i < bullets3.size(); i++) {
				bullets3.remove(i);
				i --;
			}
			//��յл�����
			for (int i = 0; i < elans.size(); i++) {
				elans.remove(i);
				i --;
			}
			//��յ÷�
			score = 0;
			y=-5400;
			bghp=100;
			//������Ϸ������ͼ
			try {
				startImg=ImageIO.read(new File("images/background/background_"+(int)(Math.random()*4+1)+".png"));
				//����Ӣ�ۻ�ͼƬ��GAMEOVER֮���Ӣ�ۻ������˱�ըͼƬ��
				p[0]=ImageIO.read(new File("images/1.png"));
				p[1]=ImageIO.read(new File("images/1.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//�������߳�
			t = new Thread(this);
			t.start();

		}

		//����Ҽ�
		if(e.getModifiers()==e.BUTTON3_MASK&&ck==false){

			elans.removeAll(elans);
			//ȥ�����ел�
			
			suspend=suspend ? resume():suspend();
			
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {

	}
	@Override
	public void mouseExited(MouseEvent arg0) {

	}
	@Override
	public void mousePressed(MouseEvent e) {
		//	System.out.println(e.getX()+e.getY());
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			while(true)
			{ 
				count++;//����count���ı��ڵ��ܼ��̶�
				if(count==1000){
					count=0;
				}
				////����ڵ������������ڵ�����ֵΪfasle
				for (int i = 0; i < bullets.size(); i++) {
					bullet=bullets.get(i);
					if(bullet.exist==false){
						bullets.remove(i);
						break;
					}
				}
				for (int i = 0; i < bullets1.size(); i++) {
					bullet1=bullets1.get(i);
					if(bullet1.exist==false){
						bullets1.remove(i);
						break;
					}
				}
				
				
				//������������ел�����ֵ
				for (int i = 0; i < elans.size(); i++) {
					elan=elans.get(i);
					if(elan.exist==false&&elan.time==0&&elan.hp==0){
						score+=elan.score;//ȥ����ǰ�л��ķ������ɼ�����
						elans.remove(i);
						break;
					}
					else if(elan.exist==false){
						elan.time--;
						int num2=(int)(Math.random()*3);
						elan.eImg=new ImageIcon("images/blast/blast_"+num2+".png").getImage();
					}
					if(elan.exist==false&&elan.hp!=0){
						elan.hp--;
					}
				}
				if(suspend){
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//////����
				
				if(y<=-1500)
				y++;
				else
				{y=-1500;
				for (int i = 0; i <bullets2.size(); i++) {
					bullet2=bullets2.get(i);
					
					BulletAndelan bae2=new BulletAndelan();
					boolean f2=bae2.bulletAndHeroCollision(bullet2, px, py, p[pc]);
					if(f2){
						php--;
						bullet2.exist=false;

					}
					
				}
				for (int i = 0; i <bullets3.size(); i++) {
					bullet3=bullets3.get(i);
					
					BulletAndelan bae3=new BulletAndelan();
					boolean f3=bae3.bulletAndHeroCollision(bullet3, px, py, p[pc]);
					if(f3){
						php--;
						bullet3.exist=false;

					}
					
				}
				for(int i=0;i<elans.size();i++)
				{elans.remove(i);i--;}
				for(int j=0;j<bullets1.size();j++)
				{bullets1.remove(j);j--;}
				/*bgx++;
				if(bgx>=380){
					bgx=0;}*/
				
				if (f==0) {
					bgx++;
					if(bgx>=300){
						f=1;
					}
				}
				if(f==1){
					bgx--;
					if(bgx<=10){
						f=0;
					}
				}
				
				
				}
//				if(y==0){
//
//					y=-5400;
//				}
				///////////
				//���Ӣ�ۻ��ڵ����ƶ�
				for (int j = 0; j < bullets.size(); j++) {
					bullet=bullets.get(j);
					bullet.moveBullet();	
				}
				//��ɴ�ɻ��ڵ��ƶ�
				
				for (int i = 0; i < bullets2.size(); i++) {
					bullet2=bullets2.get(i);
					bullet2.bigplanemoveBullet(bgx-20);
				}
				for (int i = 0; i < bullets3.size(); i++) {
					bullet3=bullets3.get(i);
					bullet3.bigplanemoveBullet(bgx+70);
				}
				
				
				//��ɵл��ڵ��ƶ�
				for (int j = 0; j < bullets1.size(); j++) {
					bullet1=bullets1.get(j);
					bullet1.elanmoveBullet();
				}
				  
				
				
				
				
				
				   
				//��ɵл����ƶ�
				for (int i = 0; i < elans.size(); i++) {
					elan=elans.get(i);
					elan.moveElan();
					//�жϵл��Ƿ���ײӢ�ۻ�
					HeroAndElan pae=new HeroAndElan();
					boolean f=pae.planAndElanCollision(px, py, p[pc], elan);
					if(f){
						php-=elan.hp;
						elan.exist=false;

					}
				}
				
				
				//��ɻ�
				HeroAndElan pae1=new HeroAndElan();
				boolean f4=pae1.bplanAndHeroCollision(px, py, p[pc], bgbImg,bgx,bgy);
				if(f4){
					php=0;
				}
				//Ӣ�ۻ�����
				if(php<=0){
					//������Ϸ��������
					startImg=new ImageIcon("images/GameInterface/jeimian_2.png").getImage();
					//������Ϸ��������
					x=0;y=0;
					p[pc]=new ImageIcon("images/blast/blast_2.png").getImage();
					p[0]=p[1]=p[pc];

					acount=1;
					repaint();
					ck=true;
					for (int i = 0; i < bullets.size(); i++) {
						bullets.remove(i);
						i --;
					}
					for (int i = 0; i < bullets1.size(); i++) {
						bullets1.remove(i);
						i --;
					}
					for (int i = 0; i < bullets2.size(); i++) {
						bullets2.remove(i);
						i --;
					}
					for (int i = 0; i < bullets3.size(); i++) {
						bullets3.remove(i);
						i --;
					}
					for (int i = 0; i < elans.size(); i++) {
						elans.remove(i);
						i --;
					}
				int res = JOptionPane.showConfirmDialog(null, "����̫ǿ���Ƿ����","yes or no",JOptionPane.YES_NO_OPTION);
				if(res == JOptionPane.YES_OPTION){
					System.out.println("����");
					
				}
				else System.exit(0);
					t.stop();
					
				}
				
				
				if((y>=-5100&&y<-5000)|| (y>=-3100&&y<=-3000 )|| (y>=-2100&&y<=-2000) ){
                //��������Ѫ
				if(count%60==0){
				awardph = new AwardPh(awardphImg, phx, phy, 30);
               awardphs.add(awardph);
               }
				//�ƶ�����Ѫ
				for (int i = 0; i < awardphs.size(); i++) {
					awardph = awardphs.get(i);
					awardph.moveAward();
					HeroAndElan pae3=new HeroAndElan();
					boolean f5=pae3.awardAndHerocollision(px, py, p[pc],awardph);
					if(f5){
						php++;
					awardph.exist=false;

					}
				}
				
				}
				//����Ӣ�ۻ��ڵ�  
				if(count%30==0){
					bullet =new Bullet(bImg,px+p[pc].getWidth(null)/2-bImg.getWidth(null)/2,py);
					bullets.add(bullet);
				
				}
				
				
				//������ɻ��ڵ�
			  if(count%120==0){
					bullet2 = new Bullet(bgbImg, bgx+10, bgy+10);
					bullets2.add(bullet2);
					bullet3 = new Bullet(bgbImg, bgx+30, bgy+10);
					bullets3.add(bullet3);
			  }
				//�����л��ڵ�
				if(count%50==0){
					for (int i = 0; i < elans.size(); i++) {
						elan=elans.get(i);
					bullet1 =new Bullet(ebImg,elan.ex-ebImg.getWidth(null)/2+23,elan.ey+10);
					bullets1.add(bullet1);
					}
				}
//					
//				
				
				//�л�С���ڵ�������ʹ��ImageIcon������ȡ�л�ͼƬ����ӵл�
				if(count%60==0){
					int num=(int)(Math.random()*5+2);
					elan=new Elan(new ImageIcon("images/LittlePlane/plane"+num+".png").getImage(), (int)(Math.random()*350), -50, num, num, num);

					elans.add(elan);

				}
				//ͨ��˫��forѭ������ڵ��Եл�����ײ�ж�
              
				for (int i = 0; i <bullets.size(); i++) {
					bullet=bullets.get(i);
					for (int j = 0; j <elans.size(); j++) {
						elan=elans.get(j);
						//
						BulletAndelan bae=new BulletAndelan();
						bae.bulletAndElanCollision(bullet, elan);
					}
				}
			
				//�ӵ���Ӣ�ۻ����˺�
				for (int i = 0; i <bullets1.size(); i++) {
					bullet1=bullets1.get(i);
					
					BulletAndelan bae1=new BulletAndelan();
					boolean f1=bae1.bulletAndHeroCollision(bullet1, px, py, p[pc]);
					if(f1){
						php--;
						bullet1.exist=false;

					}
					
				}
			   
				
				//�ӵ��Դ�ɻ����˺�
				for (int i = 0; i < bullets.size(); i++) {
					bullet=bullets.get(i);
					BulletAndelan bae2=new BulletAndelan();
					boolean f2=bae2.bulletAndBigPlaneCollision(bullet, bgx, bgy, bgImg);
					if(f2){
						bghp=bghp-2;
						ax=ax-8;
						bullet.exist=false;
					}
					
					
				}
				if(bghp<=0){
					bgImg=new ImageIcon("images/blast/bossDeadEffect.png").getImage();
					startImg=new ImageIcon("images/GameInterface/jeimian_2.png").getImage();
					x=0;y=0;
					score=score+bgscore;
					repaint();
					ck=true;
					acount=1;
					acount1=1;
					for (int i = 0; i < bullets.size(); i++) {
						bullets.remove(i);
						i --;
					}
					for (int i = 0; i < bullets1.size(); i++) {
						bullets1.remove(i);
						i --;
					}
					for (int i = 0; i < bullets2.size(); i++) {
						bullets2.remove(i);
						i --;
					}
					for (int i = 0; i < bullets3.size(); i++) {
						bullets3.remove(i);
						i --;
					}
					for (int i = 0; i < elans.size(); i++) {
						elans.remove(i);
						i --;
					}
					int res = JOptionPane.showConfirmDialog(null, "��ĵ÷֣�"+score,"yes or no",JOptionPane.YES_NO_OPTION);
				if(res == JOptionPane.YES_OPTION){
					System.out.println("����");
					
				}
				else System.exit(0);
					t.stop();
					
					
				}

				repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}
	//�Զ���һ��������ֵ����ͣ����
	public boolean suspend(){
		suspend=true;
		return suspend;
	}
	//�Զ���һ������������ֵ�Ļָ�����
	public synchronized boolean resume(){
		suspend=false;
		notify();//����һ�����ڵȴ����߳�
		return suspend;
	}
}
