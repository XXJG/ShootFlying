package study1;
import javax.swing.JFrame;
/*
 * ʵ��һ������
 * ʵ����������
 * */
public class test {
public static void main(String[] args) {
	//���������ʵ����
	JFrame jf=new JFrame();
	jf.setBounds(100, 100, 800, 600);
	jf.setTitle("jasmine");
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	FirstJPanel fp=new FirstJPanel();
	jf.add(fp);
	jf.setVisible(true);
    }
}
