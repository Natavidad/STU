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
	{ } //备用
	/** 报告异常信息 */
	private void reportException(Object o){
		try{
			storeView.showDisplay(o); 
			}
		catch(Exception e){
				System.out.println("StoreModelImpl reportException"+e); 
				} 
		} 
  /** 注册视图，以便当模型修改了数据库中的客户信息时，可以回调视图的刷新界面的方法 */
  public void addChangeListener(infoSysView sv) throws Exception{
	  this.addChangeListener(sv);
  }
  /** 向数据库中添加一个新的客户 */
  public void addStudent(Student cust) throws Exception
  {
	  
  }
  /** 从数据库中删除一个客户 */ 
  public void deleteStudent(Student cust) throws Exception
  {
	  
  }
  /** 更新数据库中的客户 */ 
  public void updateStudent(Student cust) throws Exception
  {
	  
  }
  /** 根据参数id检索客户 */
  public Student getStudent(long id) throws Exception
  {
	  
	  return null;
  }
  /** 返回数据库中所有的客户清单 */
  public Set getAllStudents() throws Exception{
	  return null;
  }
}