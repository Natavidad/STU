package ValueObject;
public class Worker extends Person{
	public float money;
	public String work;
	public String toString() {
		return id+","+name+","+age+","+money+","+work;
	}
}