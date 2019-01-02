package Manager;
import java.util.ArrayList;
import ValueObject.Worker;
import ValueObject.Worker;
public interface WorOpe {    
	public void add(ArrayList<Worker> a);
	public boolean chongfu(int k,ArrayList<Worker> b);
	public void delete(ArrayList<Worker> a,long n); 
	public void update(ArrayList<Worker> a, long n);
	public void findAll(ArrayList<Worker> a);
	public void findByLike(ArrayList<Worker> a, String n); 
	public void findByNum(ArrayList<Worker> a, long n);
}