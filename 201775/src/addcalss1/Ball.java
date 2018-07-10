package addcalss1;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
   //定义小球的坐标方向  速度  直径  变量定义
	int x,y,direction,speed,diameter;
	Color ballcolor;
	//定义四个常亮用于方向
	static final int left_up=0;
	static final int left_down=1;
	static final int right_up=2;
	static final int right_down=3;
	//构造方法完成初始化   sources -generate using fields   输送至Ballpanel
	public Ball(int x, int y, int direction, int speed, int diameter,
			Color ballcolor) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.speed = speed;
		this.diameter = diameter;
		this.ballcolor = ballcolor;
	}
	//定义方法用于画小球  生产
	public void drawball(Graphics g)
	{
		g.setColor(ballcolor);
		g.fillOval(x, y, diameter, diameter);//一个小球的绘制
	}
	public void moveBall(){
		switch (direction) {
		case left_up:
			x--;y--;
			if(x<=0)  direction=right_up;
			if(y<=0)   direction=left_down;
			break;
		case left_down: 
			x--;
			y++;
			if(x<=0)  direction=right_down;
			if(y>=600-diameter-20) direction=left_up;
			break;
		case right_up:  
			x++;y--;
			if(y<=0)  direction=right_down;
				if(x>=800-diameter-10) direction=left_up;
			break;
		case right_down:
			x++;y++;
			if(x>=800-diameter-20) direction=left_down;
			if(y>=600-diameter-10)  direction=right_up;
			break;
		default:
			break;
		}
	}
	
}
