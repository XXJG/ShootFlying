package class76;
/*
 * ����˼·  ���� 1.����һ��С��  �������ԣ�Ϊ���췽����  ��  �Զ���һ��������һ��С��
 *              2.����һ�������С��ķ���   ���췽������  ����С�����Է���  
 *              3.ʵ�ֻ����С��ķ�����ʵ�ֱ���
 *              4.����list���飬ʵ�ֶ��С�򣬲��ҽ�����ӵ�������  ���Զ����������С�����Է�����
 *    �м������ǻ���
 *    
 */
import javax.swing.JFrame;

public class Ballalljframe extends JFrame{
	public Ballalljframe() {
		
		// TODO Auto-generated constructor stub
		this.setTitle("ƹ��С��");
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(false);//��ֹ�������
		Ballallpanel ajp=new Ballallpanel();
		ajp.startBall();
		this.add(ajp);
		this.setVisible(true);
	}
public static void main(String[] args) {
	new Ballalljframe();
}
}
