package InfoSys.view;
import java.rmi.*;

import InfoSys.Controller.InfoSysController;
import ValueObject.*;
public interface infoSysView extends Remote{
	  /** 注册处理用户动作的监听器，即StoreController控制器 */
	  public void addUserGestureListener(InfoSysController ctrl) throws Exception;
	  /** 在图形界面上显示数据，参数display表示待显示的数据 */
	  public void showDisplay(Object display) throws Exception;
	  /** 当模型层修改了数据库中某个客户的信息时，同步刷新视图层的图形界面 */
	  public void handleCustomerChange(Student cust)throws Exception;
}

