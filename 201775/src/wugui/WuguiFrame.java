package wugui;

import java.awt.Color;

import javax.swing.JFrame;
/*
 * 实现小乌龟画法
 * 熟练掌握坐标
 */
public class WuguiFrame {
public static void main(String[] args) {
	JFrame jf=new JFrame();
	jf.setSize(1204, 768);
	jf.setTitle("小乌龟");
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	DrawWugui dp=new DrawWugui();
//	dp.startgui();
	jf.add(dp);
	jf.show();
}
}
