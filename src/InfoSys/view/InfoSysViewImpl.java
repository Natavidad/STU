package InfoSys.view;
import java.rmi.*;
import ValueObject.*;
public interface infoSysView extends Remote{
	  /** ע�ᴦ���û������ļ���������StoreController������ */
	  public void addUserGestureListener(StoreController ctrl) throws Exception;
	  /** ��ͼ�ν�������ʾ���ݣ�����display��ʾ����ʾ������ */
	  public void showDisplay(Object display) throws Exception;
	  /** ��ģ�Ͳ��޸������ݿ���ĳ���ͻ�����Ϣʱ��ͬ��ˢ����ͼ���ͼ�ν��� */
	  public void handleCustomerChange(Student cust)throws Exception;
}