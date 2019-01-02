package StuMan;
import java.util.*;
import Manager.*;
import ValueObject.*;
public class V3 {
	public static void main(String args[]) throws Exception {
		while(true) {
			Print.P1();
			int z=0;//外层
			int j=0;//内层
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
						System.out.println("请输入要查询的学生学号");
						f.loadTextS();
						long n = scan.nextLong();
						sm.findByNum(a,n);}
						if(j == 4) {
						System.out.println("请输入要删除的学生学号");
						f.loadTextS();
						long n = scan.nextLong();
						sm.delete(a,n);
						f.saveTextS(a);
					}if(j == 5) {
						System.out.println("请输入要修改的学生学号");
						f.loadTextS();
						long n = scan.nextLong();
						sm.update(a,n);
						f.saveTextS(a);
					}
					if(j == 6) {
						System.out.println("请输入要查询的学生姓名");
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
						System.out.println("请输入要查询的职工学号");
						long n = scan.nextLong();
						w.findByNum(b,n);}
						if(j == 4) {
							f.loadTextW();
						System.out.println("请输入要删除的职工学号");
						long n = scan.nextLong();
						w.delete(b,n);
						f.saveTextW(b);
					}if(j == 5) {
						f.loadTextW();
						System.out.println("请输入要修改的职工学号");
						long n = scan.nextLong();
						w.update(b,n);
						f.saveTextW(b);
					}
					if(j == 6) {
						f.loadTextW();
						System.out.println("请输入要查询的职工姓名");
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