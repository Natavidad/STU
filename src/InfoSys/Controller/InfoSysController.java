package InfoSys.Controller;
import ValueObject.*;
public interface InfoSysControllerImpl {
	/** �������ID��ѯ�ͻ��Ķ��� */
	  public void handleGetCustomerGesture(long id);
	  /** ������ӿͻ��Ķ��� */
	  public void handleAddCustomerGesture(Student c);
	  /** ����ɾ���ͻ��Ķ��� */
	  public void handleDeleteCustomerGesture(Student c);
	  /** ������¿ͻ��Ķ��� */
	  public void handleUpdateCustomerGesture(Student c);
	  /** �����г����пͻ��嵥�Ķ��� */
	  public void handleGetAllCustomersGesture();
}