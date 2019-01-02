package ValueObject;
public class Student extends Person{
	public float score;
	public String toString() {
		return id+","+name+","+age+","+score;
	}
}