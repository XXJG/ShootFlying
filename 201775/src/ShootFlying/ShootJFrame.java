package ShootFlying;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class ShootJFrame extends JFrame{
//定义窗台的高和宽
	int width=400,height=600;
	public ShootJFrame(){
		
		int pw=Toolkit.getDefaultToolkit().getScreenSize().width;//获取窗体的高度宽度
		int ph=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setTitle("飞机大战V1.1");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds((pw-width)/2, (ph-height)/2, width, height);
		this.setResizable(false);
		//画布类对象加入窗体
		ShootJpanel sjp=new ShootJpanel();
		this.add(sjp);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new ShootJFrame();
	}
	
}
