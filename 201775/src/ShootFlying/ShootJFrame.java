package ShootFlying;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class ShootJFrame extends JFrame{
//���崰̨�ĸߺͿ�
	int width=400,height=600;
	public ShootJFrame(){
		
		int pw=Toolkit.getDefaultToolkit().getScreenSize().width;//��ȡ����ĸ߶ȿ��
		int ph=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setTitle("�ɻ���սV1.1");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds((pw-width)/2, (ph-height)/2, width, height);
		this.setResizable(false);
		//�����������봰��
		ShootJpanel sjp=new ShootJpanel();
		this.add(sjp);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new ShootJFrame();
	}
	
}
