package InfoSys.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Set;

import InfoSys.Controller.*;
import InfoSys.model.InfoSysModel;
import InfoSys.model.InfoSysModelImpl;
import ValueObject.Student;
public class InfoSysViewImpl extends UnicastRemoteObject implements infoSysView,Serializable{
  private transient Gui gui;
  private InfoSysModelImpl storemodel;
  private Object display;
  private ArrayList storeControllers = new ArrayList(10);
  public InfoSysViewImpl(InfoSysModelImpl model)throws Exception {
	    try{
		       storemodel=model;
		       model.addChangeListener(this);  //向model注册自身
	    }catch(Exception e){
	      System.out.println("InfoSysViewImpl constructor "+e);
	    }
    gui=new Gui();
    //向图形界面注册监听器
    gui.addSelectionPanelListeners(selectionPanelListeners);
    gui.addCustPanelListeners(custPanelListeners);
  }
  
  /** 注册控制器*/
  public void addUserGestureListener(InfoSysControllerImpl b) throws Exception{
      storeControllers.add(b);
  }
  /** 在图形界面上展示参数display指定的数据 */
  public void showDisplay(Object display) throws Exception{
    if(!(display instanceof Exception))this.display=display;
    if(display instanceof Student){
       gui.refreshCustPane((Student)display);
    }
    if(display instanceof Set){
       gui.refreshAllCustPan((Set)display);
    }
    if(display instanceof Exception){
       gui.updateLog(((Exception)display).getMessage());
    }
  }
  /** 刷新界面上的客户信息*/
  public void handleCustomerChange(Student cust)throws Exception{
     long cIdOnPan=-1;
    try{
      if(display instanceof Set){
         gui.refreshAllCustPan(storemodel.getAllStudents());
         return;
      }
      if(display instanceof Student){
          cIdOnPan=gui.getCustIdOnCustPan();
          if(cIdOnPan!=cust.id)return;
          gui.refreshCustPane(cust);
      }
    }catch(Exception e){
      System.out.println("StoreViewImpl processCustomer "+e);
    }
  }
  /** 监听图形界面上【查询客户】按钮的ActionEvent的监听器 */
  transient ActionListener custGetHandler=new ActionListener(){
     public void actionPerformed(ActionEvent e){
        InfoSysController sc;
        long custId;
        custId=gui.getCustIdOnCustPan();
        for(int i=0;i<storeControllers.size();i++)
        {
        	sc=storeControllers.get(i);
        	sc.handleGetCustomerGesture(custId);
        }
     }
  };
  
  /** 监听图形界面上【添加客户】按钮的ActionEvent的监听器 */
  transient ActionListener custAddHandler=new ActionListener(){
	  
  };
  /** 监听图形界面上【删除客户】按钮的ActionEvent的监听器 */
  transient ActionListener custDeleteHandler=new ActionListener(){
	  
  };
  /** 监听图形界面上【更新客户】按钮的ActionEvent的监听器 */
  transient ActionListener custUpdateHandler=new ActionListener(){
	  
  };
  /** 监听图形界面上【客户详细信息】按钮的ActionEvent的监听器 */
  transient ActionListener custDetailsPageHandler=new ActionListener(){
     public void actionPerformed(ActionEvent e){
        InfoSysController sc;
        long custId;
        custId=gui.getCustIdOnCustPan();
        if(custId==-1){
          try{
            showDisplay(new Customer(-1));
          }catch(Exception ex){ex.printStackTrace();}
        }else{ 
          for(int i=0;i<storeControllers.size();i++)
          {            
        	sc=storeControllers.get(i);
            sc.handleGetCustomerGesture(custId);
          }
        } 
     }
  };
  /** 监听图形界面上【所有客户清单】按钮的ActionEvent的监听器 */
  transient ActionListener allCustsPageHandler=new ActionListener(){
	  
  };
  
  /** 负责监听单个客户面板custPan上的所有按钮的ActionEvent事件的监听器 */  
  transient ActionListener custPanelListeners[] ={custGetHandler,custAddHandler,
   custDeleteHandler,custUpdateHandler};
  /** 负责监听选择面板selPan上的所有按钮的ActionEvent事件的监听器 */    
  transient ActionListener selectionPanelListeners[]={
     custDetailsPageHandler,allCustsPageHandler};
}   