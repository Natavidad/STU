
public class AAAAAAA {
	package store; //此处省略 import 语句 … public class StoreViewImpl implements StoreView {   private transient StoreGui gui;   private StoreModel storemodel;   private Object display; 
	  private ArrayList storeControllers= new ArrayList(10); 
	  public StoreViewImpl(StoreModel model) {     try{        storemodel=model;        model.addChangeListener(this);  //向 model 注册自身     }catch(Exception e){       System.out.println("StoreViewImpl constructor "+e);     } 
	    gui=new StoreGui();     //向图形界面注册监听器     gui.addSelectionPanelListeners(selectionPanelListeners);     gui.addCustPanelListeners(custPanelListeners);   }      /** 注册控制器*/   public void addUserGestureListener(StoreController b)  throws StoreException{     storeControllers.add(b);   }   /** 在图形界面上展示参数 display 指定的数据 */   public void showDisplay(Object display) throws StoreException{     if(!(display instanceof Exception))this.display=display; 
	    if(display instanceof Customer){        gui.refreshCustPane((Customer)display);     }     if(display instanceof Set){        gui.refreshAllCustPan((Set)display);     } 
	    if(display instanceof Exception){        gui.updateLog(((Exception)display).getMessage());     }   } 
	  /** 刷新界面上的客户信息*/   public void handleCustomerChange(Customer cust)throws StoreException{      long cIdOnPan=-1; 
	    try{       if(display instanceof Set){          gui.refreshAllCustPan(storemodel.getAllCustomers());          return;       }       if(display instanceof Customer){           cIdOnPan=gui.getCustIdOnCustPan();           if(cIdOnPan!=cust.getId())return; 
	          gui.refreshCustPane(cust);       }     }catch(Exception e){       System.out.println("StoreViewImpl processCustomer "+e);     }   }      /** 监听图形界面上【查询客户】按钮的 ActionEvent 的监听器 */   transient ActionListener custGetHandler=new ActionListener(){      public void actionPerformed(ActionEvent e){         StoreController sc;         long custId;         custId=gui.getCustIdOnCustPan(); 
	        for(int i=0;i<storecontrollers.size();i++){           sc=storeControllers.get(i);           sc.handleGetCustomerGesture(custId);         }      }   };      /** 监听图形界面上【添加客户】按钮的 ActionEvent 的监听器 */   transient ActionListener custAddHandler=new ActionListener(){…};</storecontrollers.size();i++){ 
	  /** 监听图形界面上【删除客户】按钮的 ActionEvent 的监听器 */ 
	  transient ActionListener custDeleteHandler=new ActionListener(){…}; 
	  /** 监听图形界面上【更新客户】按钮的 ActionEvent 的监听器 */   transient ActionListener custUpdateHandler=new ActionListener(){…}; 
	  /** 监听图形界面上【客户详细信息】按钮的 ActionEvent 的监听器 */   transient ActionListener custDetailsPageHandler=new ActionListener(){      public void actionPerformed(ActionEvent e){         StoreController sc;         long custId;         custId=gui.getCustIdOnCustPan();         if(custId==-1){           try{             showDisplay(new Customer(-1));           }catch(Exception ex){ex.printStackTrace();}         }else{            for(int i=0;i<storecontrollers.size();i++){             sc=storeControllers.get(i);             sc.handleGetCustomerGesture(custId);           }         }       }   };</storecontrollers.size();i++){ 
	  /** 监听图形界面上【所有客户清单】按钮的 ActionEvent 的监听器 */   transient ActionListener allCustsPageHandler=new ActionListener(){…};      /** 负责监听单个客户面板 custPan 上的所有按钮的 ActionEvent 事件的监 听器 */     transient ActionListener custPanelListeners[] ={custGetHandler,custAddHandler,    custDeleteHandler,custUpdateHandler}; 
	  /** 负责监听选择面板 selPan 上的所有按钮的 ActionEvent 事件的监听器 */       transient ActionListener selectionPanelListeners[]={      custDetailsPageHandler,allCustsPageHandler}; }
}
