
public class AAAAAAA {

}
package store; //�˴�ʡ�� import ��� �� public class StoreViewImpl implements StoreView {   private transient StoreGui gui;   private StoreModel storemodel;   private Object display; 
private ArrayList storeControllers= new ArrayList(10); 
public StoreViewImpl(StoreModel model) {     try{        storemodel=model;        model.addChangeListener(this);  //�� model ע������     }catch(Exception e){       System.out.println("StoreViewImpl constructor "+e);     } 
  gui=new StoreGui();     //��ͼ�ν���ע�������     gui.addSelectionPanelListeners(selectionPanelListeners);     gui.addCustPanelListeners(custPanelListeners);   }      /** ע�������*/   public void addUserGestureListener(StoreController b)  throws StoreException{     storeControllers.add(b);   }   /** ��ͼ�ν�����չʾ���� display ָ�������� */   public void showDisplay(Object display) throws StoreException{     if(!(display instanceof Exception))this.display=display; 
  if(display instanceof Customer){        gui.refreshCustPane((Customer)display);     }     if(display instanceof Set){        gui.refreshAllCustPan((Set)display);     } 
  if(display instanceof Exception){        gui.updateLog(((Exception)display).getMessage());     }   } 
/** ˢ�½����ϵĿͻ���Ϣ*/   public void handleCustomerChange(Customer cust)throws StoreException{      long cIdOnPan=-1; 
  try{       if(display instanceof Set){          gui.refreshAllCustPan(storemodel.getAllCustomers());          return;       }       if(display instanceof Customer){           cIdOnPan=gui.getCustIdOnCustPan();           if(cIdOnPan!=cust.getId())return; 
        gui.refreshCustPane(cust);       }     }catch(Exception e){       System.out.println("StoreViewImpl processCustomer "+e);     }   }      /** ����ͼ�ν����ϡ���ѯ�ͻ�����ť�� ActionEvent �ļ����� */   transient ActionListener custGetHandler=new ActionListener(){      public void actionPerformed(ActionEvent e){         StoreController sc;         long custId;         custId=gui.getCustIdOnCustPan(); 
      for(int i=0;i<storecontrollers.size();i++){           sc=storeControllers.get(i);           sc.handleGetCustomerGesture(custId);         }      }   };      /** ����ͼ�ν����ϡ���ӿͻ�����ť�� ActionEvent �ļ����� */   transient ActionListener custAddHandler=new ActionListener(){��};</storecontrollers.size();i++){ 
/** ����ͼ�ν����ϡ�ɾ���ͻ�����ť�� ActionEvent �ļ����� */ 
transient ActionListener custDeleteHandler=new ActionListener(){��}; 
/** ����ͼ�ν����ϡ����¿ͻ�����ť�� ActionEvent �ļ����� */   transient ActionListener custUpdateHandler=new ActionListener(){��}; 
/** ����ͼ�ν����ϡ��ͻ���ϸ��Ϣ����ť�� ActionEvent �ļ����� */   transient ActionListener custDetailsPageHandler=new ActionListener(){      public void actionPerformed(ActionEvent e){         StoreController sc;         long custId;         custId=gui.getCustIdOnCustPan();         if(custId==-1){           try{             showDisplay(new Customer(-1));           }catch(Exception ex){ex.printStackTrace();}         }else{            for(int i=0;i<storecontrollers.size();i++){             sc=storeControllers.get(i);             sc.handleGetCustomerGesture(custId);           }         }       }   };</storecontrollers.size();i++){ 
/** ����ͼ�ν����ϡ����пͻ��嵥����ť�� ActionEvent �ļ����� */   transient ActionListener allCustsPageHandler=new ActionListener(){��};      /** ������������ͻ���� custPan �ϵ����а�ť�� ActionEvent �¼��ļ� ���� */     transient ActionListener custPanelListeners[] ={custGetHandler,custAddHandler,    custDeleteHandler,custUpdateHandler}; 
/** �������ѡ����� selPan �ϵ����а�ť�� ActionEvent �¼��ļ����� */       transient ActionListener selectionPanelListeners[]={      custDetailsPageHandler,allCustsPageHandler}; }