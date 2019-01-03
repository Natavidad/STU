package InfoSys.Controller;
import ValueObject.*;
public interface InfoSysControllerImpl {
	/** 处理根据ID查询客户的动作 */
	  public void handleGetCustomerGesture(long id);
	  /** 处理添加客户的动作 */
	  public void handleAddCustomerGesture(Student c);
	  /** 处理删除客户的动作 */
	  public void handleDeleteCustomerGesture(Student c);
	  /** 处理更新客户的动作 */
	  public void handleUpdateCustomerGesture(Student c);
	  /** 处理列出所有客户清单的动作 */
	  public void handleGetAllCustomersGesture();
}