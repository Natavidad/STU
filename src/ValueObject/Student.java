package ValueObject;
import java.io.Serializable;
public class Student extends Person implements Serializable{  //�ýӿڽ���һ����ǣ�û�з���
	public float score;
	public String toString() {
		return id+","+name+","+age+","+score;
	}
}