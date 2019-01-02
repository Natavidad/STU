package Manager;
import java.util.ArrayList;
import java.util.Scanner;

import ValueObject.*;
public class WorkManager implements WorOpe{
	Scanner scan  = new Scanner(System.in);
	public void add(ArrayList<Worker> a) {
		System.out.println("����ְ��ID��");
		int k = scan.nextInt();
		if(chongfu(k,a)) {
			System.out.println("�����ظ�,������ѡ��");
		}
		else{
			Worker s = new Worker();
			s.id = k;
			System.out.println("����ְ��������");
			scan.nextLine();//��ȥ�ո����
			s.name = scan.nextLine();
			System.out.println("����ְ�����䣺");
			s.age = scan.nextInt();
			System.out.println("����ְ�����ʣ�");
			s.money = scan.nextFloat();
			System.out.println("����ְ��������");
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
				System.out.println("����ְ��ID��");
				a.get(i).id = scan.nextLong();
				System.out.println("����ְ��������");
				a.get(i).name = scan.nextLine();
				System.out.println("����ְ�����䣺");
				a.get(i).age = scan.nextInt();
				System.out.println("����ְ�����ʣ�");
				a.get(i).money = scan.nextFloat();
				System.out.println("����ְ��������");
				a.get(i).work = scan.nextLine();
			}
			else System.out.println("δ�ҵ���ѧ�ţ���˶Ժ�����");
		}
	}
	public void findAll(ArrayList<Worker> a) {
		for(int i=0;i<a.size();i++) {
			System.out.println("��"+(i+1)+"λְ�����ţ�"+a.get(i).id+",������"+a.get(i).name+",���䣺"+a.get(i).age+",���ʣ�"+a.get(i).money+",������"+a.get(i).work);
		}
		System.out.println("***************************");
	}
	public void findByLike(ArrayList<Worker> a, String n) {
		for(int i=0;i<a.size();i++) {
			if(a.get(i).equals(n)) System.out.println("��"+(i+1)+"λְ�����ţ�"+a.get(i).id+",������"+a.get(i).name+",���䣺"+a.get(i).age+",���ʣ�"+a.get(i).money+",����"+a.get(i).work);
			else System.out.println("δ�ҵ�����˶����������");
		}
	}
	public void findByNum(ArrayList<Worker> a, long n) {
		for(int i=0;i<a.size();i++) {
			if(a.get(i).id == n) System.out.println("��"+(i+1)+"λְ�����ţ�"+a.get(i).id+",������"+a.get(i).name+",���䣺"+a.get(i).age+",���ʣ�"+a.get(i).money+",����"+a.get(i).work);
			else System.out.println("δ�ҵ�����˶Թ��ź����");
		}
	}
}