package InfoSys.model;
import java.rmi.*;
import InfoSys.Controller.InfoSysController;
import InfoSys.VO.*;
import InfoSys.JDBC.*;
import java.util.*;
import InfoSys.view.infoSysView;
public class InfoSysModelImpl implements InfoSysModel {
	private InfoSysController storeController; 
	private infoSysView storeView; 
	public InfoSysModelImpl(InfoSysController controller, infoSysView view )
	{ } //����
	/** �����쳣��Ϣ */
	private void reportException(Object o){
		try{
			storeView.showDisplay(o); 
			}
		catch(Exception e){
				System.out.println("StoreModelImpl reportException"+e); 
				} 
		} 
  /** ע����ͼ���Ա㵱ģ���޸������ݿ��еĿͻ���Ϣʱ�����Իص���ͼ��ˢ�½���ķ��� */
  public void addChangeListener(infoSysView sv) throws Exception{
	  this.addChangeListener(sv);
  }
  /** �����ݿ������һ���µĿͻ� */
  public void addStudent(Student cust) throws Exception
  {
	  
  }
  /** �����ݿ���ɾ��һ���ͻ� */ 
  public void deleteStudent(Student cust) throws Exception
  {
	  
  }
  /** �������ݿ��еĿͻ� */ 
  public void updateStudent(Student cust) throws Exception
  {
	  
  }
  /** ���ݲ���id�����ͻ� */
  public Student getStudent(long id) throws Exception
  {
	  
	  return null;
  }
  /** �������ݿ������еĿͻ��嵥 */
  public Set getAllStudents() throws Exception{
	  return null;
  }
}