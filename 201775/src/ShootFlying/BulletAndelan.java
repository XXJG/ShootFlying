package ShootFlying;

import java.awt.Image;

public class BulletAndelan {
//定义一个方法用于判断炮弹 和敌机碰撞
	boolean flg=false;
	boolean flg1=false;
	boolean flg2=false;
	public void bulletAndElanCollision(Bullet b1,Elan e1){
		int b1x=b1.bx;
		int b1y=b1.by;
		int b2x=b1.bx+b1.bImg.getWidth(null);
		int b3y=b1.by+b1.bImg.getHeight(null);
		int e1x=e1.ex;
		int e1y=e1.ey;
		int e2x=e1.ex+e1.eImg.getWidth(null);
		int e3y=e1.ey+e1.eImg.getHeight(null);
		//判断条件
	
		if(b1x>=e1x&&b1y>=e1y&&b2x<=e2x&&b3y<=e3y){
			b1.exist=false;
			e1.exist=false;
		}
	}
	//英雄机与炮弹
	public boolean bulletAndHeroCollision(Bullet b1,int px,int py,Image pImg){
		int b1x=b1.bx;
		int b1y=b1.by;
		//int b2x=b1.bx+b1.bImg.getWidth(null);
		//int b3y=b1.by+b1.bImg.getHeight(null);
		int px1=px+pImg.getWidth(null)/2;
		int py1=py+pImg.getHeight(null)/2;
		//int pw=pImg.getWidth(null)/2;
		//int ph=pImg.getHeight(null)/2;
		//判断条件
	
		if(b1x>=px&&b1x<=px1&&b1y>=py&&b1y<=py1){
			b1.exist=false;
			flg=true;
			
		}
		return flg;
	}
	//英雄机与大飞机子弹碰撞
	public boolean bigbulletAndHeroCollision(Bullet b1,int px,int py,Image bpImg){
		int b1x=b1.bx;
		int b1y=b1.by;
		//int b2x=b1.bx+b1.bImg.getWidth(null);
		//int b3y=b1.by+b1.bImg.getHeight(null);
		int px1=px+bpImg.getWidth(null)/2;
		int py1=py+bpImg.getHeight(null)/2;
		//int pw=pImg.getWidth(null)/2;
		//int ph=pImg.getHeight(null)/2;
		//判断条件
	
		if(b1x>=px&&b1x<=px1&&b1y>=py&&b1y<=py1){
			b1.exist=false;
			flg2=true;
			
		}
		return flg2;
	}
	//大飞机与子弹
	public boolean bulletAndBigPlaneCollision(Bullet b1,int bgx,int bgy,Image bgImg){
		int b1x=b1.bx;
		int b1y=b1.by;
		int b2x=b1.bx+b1.bImg.getWidth(null);
		int b3y=b1.by+b1.bImg.getHeight(null);
		int bgx1=bgx+bgImg.getWidth(null)/2;
		int bgy1=bgy+bgImg.getHeight(null)/2;
		//int pw=pImg.getWidth(null)/2;
		//int ph=pImg.getHeight(null)/2;
		//判断条件
	
		if(b1x>=bgx&&b1y>=bgy&&b2x<=bgx1&&b3y<=bgy1){
			b1.exist=false;
			flg1=true;
			
		}
		return flg1;
	}
	
}
