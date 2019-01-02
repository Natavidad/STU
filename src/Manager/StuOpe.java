package Manager;
import java.util.ArrayList;
import ValueObject.*;
public interface StuOpe {    
	public void add(ArrayList<Student> a);
	public boolean chongfu(int k,ArrayList<Student> b);
	public void delete(ArrayList<Student> a,long n); 
	public void update(ArrayList<Student> a, long n) ;
	public void findAll(ArrayList<Student> a)  ;
	public void findByNum(ArrayList<Student> a, long n); 
	public void findByLike(ArrayList<Student> a, String n);
} 
