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
		       model.addChangeListener(this);  //��modelע������
	    }catch(Exception e){
	      System.out.println("InfoSysViewImpl constructor "+e);
	    }
    gui=new Gui();
    //��ͼ�ν���ע�������
    gui.addSelectionPanelListeners(selectionPanelListeners);
    gui.addCustPanelListeners(custPanelListeners);
  }
  
  /** ע�������*/
  public void addUserGestureListener(InfoSysControllerImpl b) throws Exception{
      storeControllers.add(b);
  }
  /** ��ͼ�ν�����չʾ����displayָ�������� */
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
  /** ˢ�½����ϵĿͻ���Ϣ*/
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
  /** ����ͼ�ν����ϡ���ѯ�ͻ�����ť��ActionEvent�ļ����� */
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
  
  /** ����ͼ�ν����ϡ���ӿͻ�����ť��ActionEvent�ļ����� */
  transient ActionListener custAddHandler=new ActionListener(){
	  
  };
  /** ����ͼ�ν����ϡ�ɾ���ͻ�����ť��ActionEvent�ļ����� */
  transient ActionListener custDeleteHandler=new ActionListener(){
	  
  };
  /** ����ͼ�ν����ϡ����¿ͻ�����ť��ActionEvent�ļ����� */
  transient ActionListener custUpdateHandler=new ActionListener(){
	  
  };
  /** ����ͼ�ν����ϡ��ͻ���ϸ��Ϣ����ť��ActionEvent�ļ����� */
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
  /** ����ͼ�ν����ϡ����пͻ��嵥����ť��ActionEvent�ļ����� */
  transient ActionListener allCustsPageHandler=new ActionListener(){
	  
  };
  
  /** ������������ͻ����custPan�ϵ����а�ť��ActionEvent�¼��ļ����� */  
  transient ActionListener custPanelListeners[] ={custGetHandler,custAddHandler,
   custDeleteHandler,custUpdateHandler};
  /** �������ѡ�����selPan�ϵ����а�ť��ActionEvent�¼��ļ����� */    
  transient ActionListener selectionPanelListeners[]={
     custDetailsPageHandler,allCustsPageHandler};
}   