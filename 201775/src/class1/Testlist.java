package class1;

import java.util.ArrayList;
import java.util.List;//awt是列表

public class Testlist {
public static void main(String[] args) {
	//定义一个集合  泛型
	List<String> strs=new ArrayList<String>();
	//向集合中添加数据
	strs.add("张三");
	strs.add("李四");
	strs.add("王五");
	//输出集合中记录
	System.out.println(strs.size());
	getList(strs);//实参
	System.out.println("=======");
	strs.remove(1);
	getList(strs);
}
//自定义方法遍历集合
public static void getList(List lt){//形参
	for (int i = 0; i < lt.size(); i++) {
		System.out.println(lt.get(i));
	}
}
}
