package study1;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;
/*
 * ͨ��random�������������������
 * ͨ�������ص���Բ�����£��ǵ�������ɫ�Ĳ�ͬ������ �Ӿ��Ĵ��
 * ��˸������
 */
public class FirstJPanel extends JPanel{
public void paint(Graphics g)
{super.paint(g);
setBackground(Color.BLACK);
for(int i=0;i<500;i++)
{
g.setColor(Color.white);
g.drawString("*", (int)(Math.random()*800), (int)(Math.random()*600));	
}
g.setColor(Color.yellow);
g.fillOval(580, 50, 120, 120);
g.setColor(Color.black);
g.fillOval(570, 50, 120, 120);
g.setColor(Color.white);
g.setFont(new Font("����", Font.PLAIN, 30));
g.drawString("designed by xjg", 400, 400);
g.setColor(new Color(123,54,126));
g.drawLine(2000, 200, 400, 200);
}

}

