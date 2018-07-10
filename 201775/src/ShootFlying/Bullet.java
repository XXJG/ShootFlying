package ShootFlying;

import java.awt.Graphics;
import java.awt.Image;

public class Bullet {
//定义炮弹的图片对象
	Image bImg;
	//定义炮弹的坐标
	int bx,by;

	//定义一个布尔型变量用于标识炮弹是否存在
	boolean exist=true;
public Bullet(Image bImg, int bx, int by) {
	super();
	this.bImg = bImg;
	this.bx = bx;
	this.by = by;

}
//自定义一个方法用于画炮弹
public void drawBullet(Graphics g){
	
	g.drawImage(bImg, bx, by, null);
	
} //炮弹移动
public void moveBullet(){
	by--;
	if(by==-bImg.getHeight(null)){
		exist=false;
	}
}
//自定义方法用于炮弹和敌机移动
public void elanmoveBullet(){
	by=by+6;
	if(by>=600){
		exist=false;
	}
}
//自定义方法炮弹和大飞机移动
public void bigplanemoveBullet(int bgbx){
	by++;
	bx=bgbx+10;
	if(by>=600){
		exist=false;
	}
}	
}
