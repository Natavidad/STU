package Manager;
import java.util.ArrayList;
import java.util.Scanner;

import ValueObject.*;
public class WorkManager implements WorOpe{
	Scanner scan  = new Scanner(System.in);
	public void add(ArrayList<Worker> a) {
		System.out.println("输入职工ID：");
		int k = scan.nextInt();
		if(chongfu(k,a)) {
			System.out.println("工号重复,请重新选择");
		}
		else{
			Worker s = new Worker();
			s.id = k;
			System.out.println("输入职工姓名：");
			scan.nextLine();//除去空格干扰
			s.name = scan.nextLine();
			System.out.println("输入职工年龄：");
			s.age = scan.nextInt();
			System.out.println("输入职工工资：");
			s.money = scan.nextFloat();
			System.out.println("输入职工工作：");
			scan.nextLine();
			s.work = scan.nextLine();
			a.add(s);
		}
	}
	public boolean chongfu(int k,ArrayList<Worker> b) {
		for(int i=0;i<b.size();i++) {
			if(b.get(i).id == k) return true;
		}
		return false;
	}
	public void delete(ArrayList<Worker> a,long n) {
		for(int i=0;i<a.size();i++) {
			if((a.get(i).id == n)) {
				a.remove(i);
			}
		}
	}
	public void update(ArrayList<Worker> a, long n) {
		for(int i=0;i<a.size();i++) {
			if(a.get(i).id == n) {
				System.out.println("输入职工ID：");
				a.get(i).id = scan.nextLong();
				System.out.println("输入职工姓名：");
				a.get(i).name = scan.nextLine();
				System.out.println("输入职工年龄：");
				a.get(i).age = scan.nextInt();
				System.out.println("输入职工工资：");
				a.get(i).money = scan.nextFloat();
				System.out.println("输入职工工作：");
				a.get(i).work = scan.nextLine();
			}
			else System.out.println("未找到该学号，请核对后输入");
		}
	}
	public void findAll(ArrayList<Worker> a) {
		for(int i=0;i<a.size();i++) {
			System.out.println("第"+(i+1)+"位职工工号："+a.get(i).id+",姓名："+a.get(i).name+",年龄："+a.get(i).age+",工资："+a.get(i).money+",工作："+a.get(i).work);
		}
		System.out.println("***************************");
	}
	public void findByLike(ArrayList<Worker> a, String n) {
		for(int i=0;i<a.size();i++) {
			if(a.get(i).equals(n)) System.out.println("第"+(i+1)+"位职工工号："+a.get(i).id+",姓名："+a.get(i).name+",年龄："+a.get(i).age+",工资："+a.get(i).money+",工作"+a.get(i).work);
			else System.out.println("未找到，请核对姓名后查找");
		}
	}
	public void findByNum(ArrayList<Worker> a, long n) {
		for(int i=0;i<a.size();i++) {
			if(a.get(i).id == n) System.out.println("第"+(i+1)+"位职工工号："+a.get(i).id+",姓名："+a.get(i).name+",年龄："+a.get(i).age+",工资："+a.get(i).money+",工作"+a.get(i).work);
			else System.out.println("未找到，请核对工号后查找");
		}
	}
}