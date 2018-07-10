package ShootFlying;

import java.awt.Image;

public class HeroAndElan {
	//定义一个标识
	boolean flg=false;
	boolean flg1=false;
	boolean flg2=true;
	boolean flg3=false;
	public boolean planAndElanCollision(int px,int py,Image pImg,Elan e1){
		int px1=px+pImg.getWidth(null)/2;
		int py1=py+pImg.getHeight(null)/2;
		int pw=pImg.getWidth(null)/2;
		int ph=pImg.getHeight(null)/2;
		int ex1=e1.ex+e1.eImg.getWidth(null)/2;
		int ey1=e1.ey+e1.eImg.getHeight(null)/2;
		int ew=e1.eImg.getWidth(null)/2;
		int eh=e1.eImg.getHeight(null)/2;
				
				if(Math.sqrt(Math.pow((ex1-px1), 2)+Math.pow((ey1-py1), 2))<=(ew+pw)
						||Math.sqrt(Math.pow((ex1-px1),2)+Math.pow((ey1-py1), 2))<=eh+ph){
				flg=true;
				e1.exist=false;
				}
		return flg;
		
	}
	//大飞机与英雄机
	
	public boolean bplanAndHeroCollision(int px,int py,Image pImg,Image bpImg,int bpx,int bpy){
		int px1=px+pImg.getWidth(null)/2;
		int py1=py+pImg.getHeight(null)/2;
		int pw=pImg.getWidth(null)/2;
		int ph=pImg.getHeight(null)/2;
		int ex1=bpx+bpImg.getWidth(null)/2;
		int ey1=bpy+bpImg.getHeight(null)/2;
		int ew=bpImg.getWidth(null)/2;
		int eh=bpImg.getHeight(null)/2;
				
				if(Math.sqrt(Math.pow((ex1-px1), 2)+Math.pow((ey1-py1), 2))<=(ew+pw)
						||Math.sqrt(Math.pow((ex1-px1),2)+Math.pow((ey1-py1), 2))<=eh+ph){
				flg1=true;
				flg2=false;
				}
		return flg1;
		
		
		
		}
	
	public boolean awardAndHerocollision(int px,int py,Image pImg,AwardPh a){
		int px1=px+pImg.getWidth(null)/2;
		int py1=py+pImg.getHeight(null)/2;
		int pw=pImg.getWidth(null)/2;
		int ph=pImg.getHeight(null)/2;
		int ax1=a.phx+a.awardphImg.getWidth(null)/2;
		int ay1=a.phy+a.awardphImg.getHeight(null)/2;
		int aw=a.awardphImg.getWidth(null)/2;
		int ah=a.awardphImg.getHeight(null)/2;
				
	  if(Math.sqrt(Math.pow((ax1-px1), 2)+Math.pow((ay1-py1), 2))<=(aw+pw)
						||Math.sqrt(Math.pow((ax1-px1),2)+Math.pow((ay1-py1), 2))<=ah+ph){
				flg3=true;
				a.exist=false;
				}
		
		return flg3;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//public void heroAndElancollision(Elan e,int x1,int y1,int hw,boolean pe){
//	int e1x=e.ex;
//	int e1y=e.ey;
//	int h2x=x1+hw;
//	int e2x=e.ex+e.eImg.getWidth(null);
//	int e3y=e.ey+e.eImg.getHeight(null);
//	if(hw<=e.eImg.getWidth(null)){
//		if(x1>=e1x&&y1>=e1y&&h2x<=e2x&&y1<=e3y){
//		e.exist=false;
//		pe=false;
//		}
//	}
//	else if(hw>e.eImg.getWidth(null)){
//		if(){
//		e.exist=false;
//		pe=false;
//		}
//	}
	

//}
}

