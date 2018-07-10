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
	//定义一个图片对象，坐标
	static Image startImg;
	int x=0,y=0;
	//定义一个布尔型变量用于判断单击事件
	boolean ck=true;
	//创建多线程类对象
	Thread t;
	//////定义一个布尔型变量用于游戏的暂停与恢复
	boolean suspend=false;
	//定义一个英雄机的对象坐标
	static Image p[]=new Image[2];
	int px=100,py=100;
	//定义数组的下表标识
	int pc=0;
	Bullet bullet;
	Bullet bullet1;
    Bullet bullet2;
    Bullet bullet3;
	//定义一个集合用于管理炮弹
	List<Bullet> bullets=new ArrayList<Bullet>();
	List<Bullet> bullets1=new ArrayList<Bullet>();//敌机炮弹
	List<Bullet> bullets2=new ArrayList<Bullet>();
	List<Bullet> bullets3=new ArrayList<Bullet>();
	
	List<AwardPh> awardphs=new ArrayList<AwardPh>();
	//定义炮弹
	static Image bImg;
	static Image ebImg;
	static Image bgbImg;
	static Image award;
	static Image awardphImg;
	//大飞机	
	int bghp=100;
	int bgx=150;
	int bgy=50;
	int bgscore=100;
	int ax=400;
	int f=0;//大飞机方向
	static Image bgImg;
	int acount1;
	//定义一个整型变量用于减慢炮弹
	int count=0;
	int acount=0;
	int phx=  0;
	int phy = 100;
	//敌机集合声明定义
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
	
	
	//构造方法
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

		//画炮弹
		for (int i = 0; i < bullets.size(); i++) {
			bullet=bullets.get(i);
			bullet .drawBullet(g);

		}
		
		for (int i = 0; i < bullets1.size(); i++) {
			bullet1=bullets1.get(i);
			bullet1.drawBullet(g);

		}
		//画奖励
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
		//画大飞机
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

		
			//血条
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
		//画敌机，调用方法drawElan
		for (int i = 0; i < elans.size(); i++) {
			elan=elans.get(i);
			elan.drawElan(g);
		}
		//画英雄机
		if(ck==false){
			pc=pc==0?1:0;
			g.drawImage(p[pc], px, py, null);
		}
		if(ck==false){
			g.setColor(Color.red);
			g.drawString("得分："+score, 300, 50);
			g.drawString("生命："+php, 200, 50);
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
			//设置鼠标的图标为小手
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

		//获得鼠标的坐标给复制英雄机
		px=e.getX()-p[pc].getWidth(null)/2;
		py=e.getY()-p[pc].getHeight(null)/2;

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		//鼠标左键
		if(acount==0&&e.getModifiers()==e.BUTTON1_MASK&&ck&&e.getX()>=131&&e.getX()<=264&&e.getY()>=396&&e.getY()<=436){
			//更改ck值
			ck=false;
			//定义游戏主界面y坐标值
			y=-5400;
			//加载游戏主界面图
			try {
				
				startImg=ImageIO.read(new File("images/background/background_"+(int)(Math.random()*4+1)+".png"));

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//启动多线程
			t.start();
		}
		if(acount!=0&&e.getModifiers()==e.BUTTON1_MASK&&ck&&e.getX()>=128&&e.getX()<=296&&e.getY()>=311&&e.getY()<=365){
             
			//repaint();
			ck=false;
			//把生命值设置为50（背景图片没有更换的原因）
			php = 50;
			//清空子弹集合
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
			//清空敌机集合
			for (int i = 0; i < elans.size(); i++) {
				elans.remove(i);
				i --;
			}
			//清空得分
			score = 0;
			y=-5400;
			bghp=100;
			//加载游戏主界面图
			try {
				startImg=ImageIO.read(new File("images/background/background_"+(int)(Math.random()*4+1)+".png"));
				//更换英雄机图片（GAMEOVER之后把英雄机换成了爆炸图片）
				p[0]=ImageIO.read(new File("images/1.png"));
				p[1]=ImageIO.read(new File("images/1.png"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//启动多线程
			t = new Thread(this);
			t.start();

		}

		//鼠标右键
		if(e.getModifiers()==e.BUTTON3_MASK&&ck==false){

			elans.removeAll(elans);
			//去除所有敌机
			
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
				count++;//定义count来改变炮弹密集程度
				if(count==1000){
					count=0;
				}
				////清除炮弹集合中所有炮弹生存值为fasle
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
				
				
				//清除集合中所有敌机生存值
				for (int i = 0; i < elans.size(); i++) {
					elan=elans.get(i);
					if(elan.exist==false&&elan.time==0&&elan.hp==0){
						score+=elan.score;//去除当前敌机的分数给成绩变量
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
				//////背景
				
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
				//完成英雄机炮弹的移动
				for (int j = 0; j < bullets.size(); j++) {
					bullet=bullets.get(j);
					bullet.moveBullet();	
				}
				//完成大飞机炮弹移动
				
				for (int i = 0; i < bullets2.size(); i++) {
					bullet2=bullets2.get(i);
					bullet2.bigplanemoveBullet(bgx-20);
				}
				for (int i = 0; i < bullets3.size(); i++) {
					bullet3=bullets3.get(i);
					bullet3.bigplanemoveBullet(bgx+70);
				}
				
				
				//完成敌机炮弹移动
				for (int j = 0; j < bullets1.size(); j++) {
					bullet1=bullets1.get(j);
					bullet1.elanmoveBullet();
				}
				  
				
				
				
				
				
				   
				//完成敌机的移动
				for (int i = 0; i < elans.size(); i++) {
					elan=elans.get(i);
					elan.moveElan();
					//判断敌机是否碰撞英雄机
					HeroAndElan pae=new HeroAndElan();
					boolean f=pae.planAndElanCollision(px, py, p[pc], elan);
					if(f){
						php-=elan.hp;
						elan.exist=false;

					}
				}
				
				
				//大飞机
				HeroAndElan pae1=new HeroAndElan();
				boolean f4=pae1.bplanAndHeroCollision(px, py, p[pc], bgbImg,bgx,bgy);
				if(f4){
					php=0;
				}
				//英雄机处理
				if(php<=0){
					//更换游戏结束界面
					startImg=new ImageIcon("images/GameInterface/jeimian_2.png").getImage();
					//更改游戏界面坐标
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
				int res = JOptionPane.showConfirmDialog(null, "敌人太强、是否继续","yes or no",JOptionPane.YES_NO_OPTION);
				if(res == JOptionPane.YES_OPTION){
					System.out.println("继续");
					
				}
				else System.exit(0);
					t.stop();
					
				}
				
				
				if((y>=-5100&&y<-5000)|| (y>=-3100&&y<=-3000 )|| (y>=-2100&&y<=-2000) ){
                //创建奖励血
				if(count%60==0){
				awardph = new AwardPh(awardphImg, phx, phy, 30);
               awardphs.add(awardph);
               }
				//移动奖励血
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
				//创建英雄机炮弹  
				if(count%30==0){
					bullet =new Bullet(bImg,px+p[pc].getWidth(null)/2-bImg.getWidth(null)/2,py);
					bullets.add(bullet);
				
				}
				
				
				//创建大飞机炮弹
			  if(count%120==0){
					bullet2 = new Bullet(bgbImg, bgx+10, bgy+10);
					bullets2.add(bullet2);
					bullet3 = new Bullet(bgbImg, bgx+30, bgy+10);
					bullets3.add(bullet3);
			  }
				//创建敌机炮弹
				if(count%50==0){
					for (int i = 0; i < elans.size(); i++) {
						elan=elans.get(i);
					bullet1 =new Bullet(ebImg,elan.ex-ebImg.getWidth(null)/2+23,elan.ey+10);
					bullets1.add(bullet1);
					}
				}
//					
//				
				
				//敌机小于炮弹数量，使用ImageIcon方法读取敌机图片，添加敌机
				if(count%60==0){
					int num=(int)(Math.random()*5+2);
					elan=new Elan(new ImageIcon("images/LittlePlane/plane"+num+".png").getImage(), (int)(Math.random()*350), -50, num, num, num);

					elans.add(elan);

				}
				//通过双重for循环完成炮弹对敌机的碰撞判断
              
				for (int i = 0; i <bullets.size(); i++) {
					bullet=bullets.get(i);
					for (int j = 0; j <elans.size(); j++) {
						elan=elans.get(j);
						//
						BulletAndelan bae=new BulletAndelan();
						bae.bulletAndElanCollision(bullet, elan);
					}
				}
			
				//子弹对英雄机的伤害
				for (int i = 0; i <bullets1.size(); i++) {
					bullet1=bullets1.get(i);
					
					BulletAndelan bae1=new BulletAndelan();
					boolean f1=bae1.bulletAndHeroCollision(bullet1, px, py, p[pc]);
					if(f1){
						php--;
						bullet1.exist=false;

					}
					
				}
			   
				
				//子弹对大飞机的伤害
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
					int res = JOptionPane.showConfirmDialog(null, "你的得分："+score,"yes or no",JOptionPane.YES_NO_OPTION);
				if(res == JOptionPane.YES_OPTION){
					System.out.println("继续");
					
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
	//自定义一个待返回值的暂停方法
	public boolean suspend(){
		suspend=true;
		return suspend;
	}
	//自定义一个方法带返回值的恢复方法
	public synchronized boolean resume(){
		suspend=false;
		notify();//唤醒一个正在等待的线程
		return suspend;
	}
}
