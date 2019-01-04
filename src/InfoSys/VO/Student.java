package InfoSys.VO;
public class Student{
	private long id; 
	private String name=""; 
	private float score;  
	private int age;   
	public Student(long id,String name,float score,int age)
	{     
		this.id=id;  
		this.name=name;    
		this.score=score;    
		this.age=age;   
	}     
	public Student(long id){
		this.id=id;  
		}  
	public Long getId(){ 
		return id;  
		} 
	public String getName(){  
		return name;   
		} 
	public void setName(String name){  
		this.name=name;   
		}  
	public int getage(){  
		return age;   
		} 
	public void setage(String age){  
		this.name=age;   
		}
	public float getscore(){  
		return score;   
		} 
	public void setscore(String name){  
		this.score=score;   
		}
	public String toString(){ 
		return "Student: "+id+" "+name+" "+score+" "+age;   
	}
}
