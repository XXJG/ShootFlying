package ShootFlying;

import java.awt.Graphics;
import java.awt.Image;

public class Elan {

	//定义敌机的图片对象
	Image eImg;
	int ex,ey;
	int hp;
	boolean exist=true;
	//敌机速度
	int speed;
	int score;
	//定义爆炸事件
	int time=8;
	public Elan(Image eImg, int ex, int ey, int hp, int speed,
			int score) {
		super();
		this.eImg = eImg;
		this.ex = ex;
		this.ey = ey;
		this.hp = hp;
		this.speed = speed;
		this.score = score;
	}
	//自定义方法画敌机
	public void drawElan(Graphics g){
		g.drawImage(eImg, ex, ey, null);
	}
	//敌机移动
	public void moveElan(){
		ey+=speed;
		if(ey>=600){
			exist=false;
		}
	}
	
}
