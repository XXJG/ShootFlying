package ShootFlying;

import java.awt.Graphics;
import java.awt.Image;

public class Bullet {
//�����ڵ���ͼƬ����
	Image bImg;
	//�����ڵ�������
	int bx,by;

	//����һ�������ͱ������ڱ�ʶ�ڵ��Ƿ����
	boolean exist=true;
public Bullet(Image bImg, int bx, int by) {
	super();
	this.bImg = bImg;
	this.bx = bx;
	this.by = by;

}
//�Զ���һ���������ڻ��ڵ�
public void drawBullet(Graphics g){
	
	g.drawImage(bImg, bx, by, null);
	
} //�ڵ��ƶ�
public void moveBullet(){
	by--;
	if(by==-bImg.getHeight(null)){
		exist=false;
	}
}
//�Զ��巽�������ڵ��͵л��ƶ�
public void elanmoveBullet(){
	by=by+6;
	if(by>=600){
		exist=false;
	}
}
//�Զ��巽���ڵ��ʹ�ɻ��ƶ�
public void bigplanemoveBullet(int bgbx){
	by++;
	bx=bgbx+10;
	if(by>=600){
		exist=false;
	}
}	
}
