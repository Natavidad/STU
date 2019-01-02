package Manager;
import ValueObject.*;

public interface StudentOperate {    
	public int add(Student[] a,int o); 
	public void delete(); 
	public void update(); 
	public void findAll(); 
	public void findByLike(); 
} 