package ShootFlying;

import java.awt.Graphics;
import java.awt.Image;

public class AwardPh {
Image awardphImg;
int phx;
int phy;
int ph;
boolean exist=true;
public AwardPh(Image awardph, int phx, int phy, int ph) {
	super();
	this.awardphImg = awardph;
	this.phx = phx;
	this.phy = phy;
	this.ph = ph;
}
//�Զ��巽����������
public void drawAward(Graphics g){
	g.drawImage(awardphImg, phx, phy, null);
}
//�������ƶ�
public void moveAward(){
	phx++;
	if(phx==400){
		exist=false;
	}
}
}
