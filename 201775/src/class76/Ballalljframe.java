package class76;
/*
 * 调用思路  首先 1.创建一个小球  设置属性（为构造方法）  和  自定义一个方法画一个小球
 *              2.创建一个画多个小球的方法   构造方法调用  设置小球属性方法  
 *              3.实现画多个小球的方法，实现遍历
 *              4.创建list数组，实现多个小球，并且将其添加到集合中  在自定义随机设置小球属性方法中
 *    中间桥梁是画布
 *    
 */
import javax.swing.JFrame;

public class Ballalljframe extends JFrame{
	public Ballalljframe() {
		
		// TODO Auto-generated constructor stub
		this.setTitle("乒乓小子");
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(false);//禁止窗体最大化
		Ballallpanel ajp=new Ballallpanel();
		ajp.startBall();
		this.add(ajp);
		this.setVisible(true);
	}
public static void main(String[] args) {
	new Ballalljframe();
}
}
