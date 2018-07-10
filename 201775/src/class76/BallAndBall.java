package class76;

public class BallAndBall {
	static final int left_up=0;
	static final int left_down=1;
	static final int right_up=2;
	static final int right_down=3;
	//自定义一个方法判断两个小球碰撞
	
		//自定义一个待返回值的方法用于两个小球碰撞
		public boolean getBallcollision(Ball b1,Ball b2){
			boolean flg=false;
			int b1x=b1.x+b1.diameter/2;
			int b1y=b1.y+b1.diameter/2;
			int b2x=b2.x+b2.diameter/2;
		    int b2y=b2.y+b2.diameter/2;
		    double e= Math.sqrt((b2x-b1x)*(b2x-b1x)+(b2y-b1y)*(b2y-b1y));
		    //开始进行判断
		    if(b1.diameter/2+b2.diameter/2>=e){
		    flg=true;
		    }
		    else flg=false;
		    return flg;
		}
		
		
		
		
		
		
		
		
		
//	int b1x=b1.x+b1.diameter/2;
//	int b1y=b1.y+b1.diameter/2;
//	int b2x=b2.x+b2.diameter/2;
//    int b2y=b2.y+b2.diameter/2;
//    double e= Math.sqrt((b2x-b1x)*(b2x-b1x)+(b2y-b1y)*(b2y-b1y));
//    //开始进行判断
//    if(b1.diameter/2+b2.diameter/2>=e){
//    	switch(b2.direction){
//    	case left_up:b2.direction=right_down;break;
//    	case left_down:b2.direction=right_up;break;
//    	case  right_up: b2.direction=left_down;break;
//    	case right_down:b2.direction=left_up;break;
//    	}
//       	switch(b2.direction){
//       	case left_up:b1.direction=right_down;break;
//        case left_down:b1.direction=right_up;break;
//       	case  right_up:b1.direction=left_down;break;
//       	case right_down:b1.direction=left_up;break;
//       	
    //	}
 //   }
    
	
    }
	

