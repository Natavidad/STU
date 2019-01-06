package InfoSys.model;
import java.rmi.*;
import java.util.*;
import InfoSys.view.infoSysView;
import InfoSys.VO.*;
public interface InfoSysModel extends Remote {
	
  /** ע����ͼ���Ա㵱ģ���޸������ݿ��еĿͻ���Ϣʱ�����Իص���ͼ��ˢ�½���ķ��� */
  public void addChangeListener(infoSysView sv) throws Exception;
  /** �����ݿ������һ���µĿͻ� */
  public void addStudent(Student cust) throws Exception;
  /** �����ݿ���ɾ��һ���ͻ� */ 
  public void deleteStudent(Student cust) throws Exception;
  /** �������ݿ��еĿͻ� */ 
  public void updateStudent(Student cust) throws Exception;
  /** ���ݲ���id�����ͻ� */
  public Student getStudent(long id) throws Exception;
  /** �������ݿ������еĿͻ��嵥 */
  public Set getAllStudents() throws Exception;
}