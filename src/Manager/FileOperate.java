package Manager;
import java.io.*;
import java.util.*;
import ValueObject.*;
class PersonOpException extends IOException{
	public PersonOpException(){
		super("PersonOpException");
	}
	public PersonOpException(String m){
		super(m);
	}
}
public class FileOperate {
	public void saveTextS(ArrayList<Student> a) throws PersonOpException{//???PersonOpException
		String str;
		try {
			FileOutputStream file = new FileOutputStream("stu.txt");
			ObjectOutputStream bf = new ObjectOutputStream(file);
			for(int i=0;i<a.size();i++) {
				Student s = a.get(i);
				bf.writeObject(s);
			}
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		finally {
//			bf.close();
//		}                     ???
	}
	public void saveTextW(ArrayList<Worker> a) throws PersonOpException{
		String str1;
		try {
			FileOutputStream file = new FileOutputStream("work.txt");
			ObjectOutputStream bf1 = new ObjectOutputStream(file);
			for(int i=0;i<a.size();i++) {
				Worker s = a.get(i);
				bf1.writeObject(s);
			}
			bf1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Student> loadTextS() throws Exception{
		FileInputStream file = new FileInputStream("stu.txt");
		ObjectInputStream br = new ObjectInputStream(file);
		Student s = new Student();
		ArrayList<Student> a = new ArrayList<Student>();
		while((s = (Student)br.readObject())!=null) {
				a.add(s);
		}
		br.close();
		return a;
	}
	public ArrayList<Worker> loadTextW() throws Exception{
		FileInputStream file = new FileInputStream("stu.txt");
		ObjectInputStream br = new ObjectInputStream(file);
		Worker s = new Worker();
		ArrayList<Worker> a = new ArrayList<Worker>();
		while((s = (Worker)br.readObject())!=null) {
				a.add(s);
		}
		br.close();
		return a;
	}
}
