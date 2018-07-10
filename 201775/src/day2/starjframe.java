package day2;

import javax.swing.JFrame;

public class starjframe {
    //自定义方法创建窗口
	public void showMe()
	{
		JFrame jf=new JFrame();
		jf.setTitle("下雪");
		jf.setSize(1024,768);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		starpanel sp=new starpanel();
		jf.add(sp);
		sp.startstar();
		/*Thread t=new Thread(sp);
		t.start();*/
		jf.show();
		
	}
	public static void main(String[] args) {
		starjframe sjf=new starjframe();
		
		sjf.showMe();
	}
}
