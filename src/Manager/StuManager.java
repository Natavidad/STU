package Manager;
import java.util.*;
import ValueObject.*;
import ValueObject.Student;

public class StuManager implements StuOpe{
	Scanner scan  = new Scanner(System.in);
	public void add(ArrayList<Student> a) {
		System.out.println("输入学生ID：");
		int k = scan.nextInt();
		if(chongfu(k,a)) {
			System.out.println("学号重复,请重新选择");
		}
		else{
			Student s = new Student();
			s.id = k;
			System.out.println("输入学生姓名：");
			scan.nextLine();//除去空格干扰
			s.name = scan.nextLine();
			System.out.println("输入学生年龄：");
			s.age = scan.nextInt();
			System.out.println("输入学生成绩：");
			s.score = scan.nextFloat();
			a.add(s);
		}
	}
	public boolean chongfu(int k,ArrayList<Student> b) {
		for(int i=0;i<b.size();i++) {
			if(b.get(i).id == k) return true;
		}
		return false;
	}
	public void delete(ArrayList<Student> a,long n) {
		for(int i=0;i<a.size();i++) {
			if((a.get(i).id == n)) {
				a.remove(i);
			}
		}
	}
	public void update(ArrayList<Student> a, long n) {
		for(int i=0;i<a.size();i++) {
			if(a.get(i).id == n) {
				System.out.println("输入学生ID：");
				a.get(i).id = scan.nextLong();
				System.out.println("输入学生姓名：");
				a.get(i).name = scan.nextLine();
				System.out.println("输入学生年龄：");
				a.get(i).age = scan.nextInt();
				System.out.println("输入学生成绩：");
				a.get(i).score = scan.nextFloat();
			}
			else System.out.println("未找到该学号，请核对后输入");
		}
	}
	public void findAll(ArrayList<Student> a) {
		for(int i=0;i<a.size();i++) {
			System.out.println("第"+(i+1)+"位学生学号："+a.get(i).id+",姓名："+a.get(i).name+",年龄："+a.get(i).age+",成绩："+a.get(i).score);
		}
		System.out.println("***************************");
	}
	public void findByLike(ArrayList<Student> a, String n) {
		for(int i=0;i<a.size();i++) {
			if(a.get(i).equals(n)) System.out.println("第"+(i+1)+"位学生学号："+a.get(i).id+",姓名："+a.get(i).name+",年龄："+a.get(i).age+",成绩："+a.get(i).score);
			else System.out.println("未找到，请核对姓名后查找");
		}
	}
	public void findByNum(ArrayList<Student> a, long n) {
			for(int i=0;i<a.size();i++) {
				if(a.get(i).id == n) System.out.println("第"+(i+1)+"位学生学号："+a.get(i).id+",姓名："+a.get(i).name+",年龄："+a.get(i).age+",成绩："+a.get(i).score);
				else System.out.println("未找到，请核对学号后查找");
			}
		}
}