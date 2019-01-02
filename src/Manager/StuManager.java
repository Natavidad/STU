package Manager;
import java.util.*;
import ValueObject.*;
import ValueObject.Student;

public class StuManager implements StuOpe{
	Scanner scan  = new Scanner(System.in);
	public void add(ArrayList<Student> a) {
		System.out.println("����ѧ��ID��");
		int k = scan.nextInt();
		if(chongfu(k,a)) {
			System.out.println("ѧ���ظ�,������ѡ��");
		}
		else{
			Student s = new Student();
			s.id = k;
			System.out.println("����ѧ��������");
			scan.nextLine();//��ȥ�ո����
			s.name = scan.nextLine();
			System.out.println("����ѧ�����䣺");
			s.age = scan.nextInt();
			System.out.println("����ѧ���ɼ���");
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
				System.out.println("����ѧ��ID��");
				a.get(i).id = scan.nextLong();
				System.out.println("����ѧ��������");
				a.get(i).name = scan.nextLine();
				System.out.println("����ѧ�����䣺");
				a.get(i).age = scan.nextInt();
				System.out.println("����ѧ���ɼ���");
				a.get(i).score = scan.nextFloat();
			}
			else System.out.println("δ�ҵ���ѧ�ţ���˶Ժ�����");
		}
	}
	public void findAll(ArrayList<Student> a) {
		for(int i=0;i<a.size();i++) {
			System.out.println("��"+(i+1)+"λѧ��ѧ�ţ�"+a.get(i).id+",������"+a.get(i).name+",���䣺"+a.get(i).age+",�ɼ���"+a.get(i).score);
		}
		System.out.println("***************************");
	}
	public void findByLike(ArrayList<Student> a, String n) {
		for(int i=0;i<a.size();i++) {
			if(a.get(i).equals(n)) System.out.println("��"+(i+1)+"λѧ��ѧ�ţ�"+a.get(i).id+",������"+a.get(i).name+",���䣺"+a.get(i).age+",�ɼ���"+a.get(i).score);
			else System.out.println("δ�ҵ�����˶����������");
		}
	}
	public void findByNum(ArrayList<Student> a, long n) {
			for(int i=0;i<a.size();i++) {
				if(a.get(i).id == n) System.out.println("��"+(i+1)+"λѧ��ѧ�ţ�"+a.get(i).id+",������"+a.get(i).name+",���䣺"+a.get(i).age+",�ɼ���"+a.get(i).score);
				else System.out.println("δ�ҵ�����˶�ѧ�ź����");
			}
		}
}