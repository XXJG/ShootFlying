package ShootFlying;

import java.awt.Graphics;
import java.awt.Image;

public class Elan {

	//����л���ͼƬ����
	Image eImg;
	int ex,ey;
	int hp;
	boolean exist=true;
	//�л��ٶ�
	int speed;
	int score;
	//���屬ը�¼�
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
	//�Զ��巽�����л�
	public void drawElan(Graphics g){
		g.drawImage(eImg, ex, ey, null);
	}
	//�л��ƶ�
	public void moveElan(){
		ey+=speed;
		if(ey>=600){
			exist=false;
		}
	}
	
}
