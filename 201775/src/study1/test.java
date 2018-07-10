package study1;
import javax.swing.JFrame;
/*
 * 实现一个窗体
 * 实现满天星星
 * */
public class test {
public static void main(String[] args) {
	//创建类对象实例化
	JFrame jf=new JFrame();
	jf.setBounds(100, 100, 800, 600);
	jf.setTitle("jasmine");
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	FirstJPanel fp=new FirstJPanel();
	jf.add(fp);
	jf.setVisible(true);
    }
}
