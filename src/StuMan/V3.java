package StuMan;
import java.util.*;
import Manager.*;
import ValueObject.*;
public class V3 {
	public static void main(String args[]) throws Exception {
		while(true) {
			Print.P1();
			int z=0;//���
			int j=0;//�ڲ�
			ArrayList<ValueObject.Student> a= new ArrayList<ValueObject.Student>();//?????
			ArrayList<ValueObject.Worker> b= new ArrayList<ValueObject.Worker>();
			StuManager sm = new StuManager();
			WorkManager w = new WorkManager();
			FileOperate f = new FileOperate();
			Scanner scan = new Scanner(System.in);
			z = scan.nextInt();
			if(z == 1) {
				while(j!=7) {
					Print.P2();
					j = scan.nextInt();
					if(j == 1) {
						f.loadTextS();
						sm.add(a);
						f.saveTextS(a);
					}if(j == 2) {
						f.loadTextS();
						sm.findAll(a);
					}if(j == 3) {
						System.out.println("������Ҫ��ѯ��ѧ��ѧ��");
						f.loadTextS();
						long n = scan.nextLong();
						sm.findByNum(a,n);}
						if(j == 4) {
						System.out.println("������Ҫɾ����ѧ��ѧ��");
						f.loadTextS();
						long n = scan.nextLong();
						sm.delete(a,n);
						f.saveTextS(a);
					}if(j == 5) {
						System.out.println("������Ҫ�޸ĵ�ѧ��ѧ��");
						f.loadTextS();
						long n = scan.nextLong();
						sm.update(a,n);
						f.saveTextS(a);
					}
					if(j == 6) {
						System.out.println("������Ҫ��ѯ��ѧ������");
						f.loadTextS();
						scan.nextLine();
						String n = scan.nextLine();
						sm.findByLike(a,n);
						f.saveTextS(a);
						}
				}
			}
			if(z == 2) {
				while(j!=7) {
					Print.P3();
					j = scan.nextInt();
					if(j == 1) {
						f.loadTextW();
						w.add(b);
						f.saveTextW(b);
					}if(j == 2) {
						f.loadTextW();
						w.findAll(b);
					}if(j == 3) {
						f.loadTextW();
						System.out.println("������Ҫ��ѯ��ְ��ѧ��");
						long n = scan.nextLong();
						w.findByNum(b,n);}
						if(j == 4) {
							f.loadTextW();
						System.out.println("������Ҫɾ����ְ��ѧ��");
						long n = scan.nextLong();
						w.delete(b,n);
						f.saveTextW(b);
					}if(j == 5) {
						f.loadTextW();
						System.out.println("������Ҫ�޸ĵ�ְ��ѧ��");
						long n = scan.nextLong();
						w.update(b,n);
						f.saveTextW(b);
					}
					if(j == 6) {
						f.loadTextW();
						System.out.println("������Ҫ��ѯ��ְ������");
						scan.nextLine();
						String n = scan.nextLine();
						w.findByLike(b,n);
						}
				}
			}
			if(z == 3) {
				System.exit(0);
			}
			}
	}
}
