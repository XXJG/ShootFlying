package wugui;

import java.awt.Color;

import javax.swing.JFrame;
/*
 * ʵ��С�ڹ껭��
 * ������������
 */
public class WuguiFrame {
public static void main(String[] args) {
	JFrame jf=new JFrame();
	jf.setSize(1204, 768);
	jf.setTitle("С�ڹ�");
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	DrawWugui dp=new DrawWugui();
//	dp.startgui();
	jf.add(dp);
	jf.show();
}
}
