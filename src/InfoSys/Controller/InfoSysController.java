package InfoSys.Controller;
import ValueObject.*;
public interface InfoSysControllerImpl {
	/** �������ID��ѯ�ͻ��Ķ��� */
	  public void handleGetStudentGesture(long id);
	  /** ������ӿͻ��Ķ��� */
	  public void handleAddStudentGesture(Student c);
	  /** ����ɾ���ͻ��Ķ��� */
	  public void handleDeleteStudentGesture(Student c);
	  /** ������¿ͻ��Ķ��� */
	  public void handleUpdateStudentGesture(Student c);
	  /** �����г����пͻ��嵥�Ķ��� */
	  public void handleGetAllStudentsGesture();
}