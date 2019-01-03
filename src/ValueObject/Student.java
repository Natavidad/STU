package ValueObject;
import java.io.Serializable;
public class Student extends Person implements Serializable{  //该接口仅是一个标记，没有方法
	public float score;
	public String toString() {
		return id+","+name+","+age+","+score;
	}
}