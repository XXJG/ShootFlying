package class1;

import javax.swing.JFrame;

import class1.game1panel;

public class game1frame extends JFrame{

	//用构造方法完成初始化
	public game1frame(){
		this.setTitle("乒乓小子");
		this.setBounds(100, 100, 400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game1panel gp=new game1panel();
		gp.startBall();
		this.add(gp);
		this.setResizable(false);//禁止窗体最大化
		this.setVisible(true);
	
	}
	public static void main(String[] args) {
	new game1frame();
		
	}
}
