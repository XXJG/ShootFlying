package class1;

import java.util.ArrayList;
import java.util.List;//awt���б�

public class Testlist {
public static void main(String[] args) {
	//����һ������  ����
	List<String> strs=new ArrayList<String>();
	//�򼯺����������
	strs.add("����");
	strs.add("����");
	strs.add("����");
	//��������м�¼
	System.out.println(strs.size());
	getList(strs);//ʵ��
	System.out.println("=======");
	strs.remove(1);
	getList(strs);
}
//�Զ��巽����������
public static void getList(List lt){//�β�
	for (int i = 0; i < lt.size(); i++) {
		System.out.println(lt.get(i));
	}
}
}
