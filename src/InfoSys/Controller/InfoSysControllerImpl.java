package InfoSys.Controller;
import java.util.*;
import InfoSys.*;
import InfoSys.VO.Student;
import InfoSys.model.InfoSysModel;
import InfoSys.view.infoSysView;
public class InfoSysControllerImpl implements InfoSysController{
	 private InfoSysModel storeModel; 
	 private infoSysView storeView;
	 public InfoSysControllerImpl(InfoSysModel model, infoSysView view ){ 
		 try{ 
			 storeModel=model; 
			 storeView=view; 
			 view.addUserGestureListener(this);  //向视图注册控制器自身 
	 	}catch(Exception e)
		 { 
	 		reportException(e);
	 	}
	 } 
	 
	/** 报告异常信息 */ 
	 private void reportException(Object o)
	 { 
		 try{ storeView.showDisplay(o); }
	 catch(Exception e){ 
		 System.out.println("StoreControllerImpl reportException"+e); 
		 } 
	 } 
	 
	/** 处理根据 ID 查询客户的动作 */ 
	 public void handleGetStudentGesture(long id)
	 { 
		 Student cust=null; 
		 try{ 
			 cust=storeModel.getStudent(id); 
			 storeView.showDisplay(cust); 
	 }
	 catch(Exception e){
		 reportException(e); 
		 cust=new Student(id);
		 try{
			 	storeView.showDisplay(cust);
			 }
		 catch(Exception ex){
			 reportException(ex);
			 } 
		 }
		 } 
	 
	/** 处理添加客户的动作 */ 
	 public void handleAddStudentGesture(Student c)
	 { 
		 try{ 
			 storeModel.addStudent(c); 
			 }
		 catch(Exception e)
		 {
			 reportException(e);
			 } 
		 } 
	 
	/** 处理删除客户的动作 */ 
	 public void handleDeleteStudentGesture(Student c)
	 {
		 try{ 
			 storeModel.deleteStudent(c); 
			 }
		 catch(Exception e)
		 {
			 reportException(e);
			 } 
		 } 
	 
	/** 处理更新客户的动作 */
	 public void handleUpdateStudentGesture(Student c)
	 {
		 try{ 
			 storeModel.updateStudent(c); 
			 }
		 catch(Exception e)
		 {
			 reportException(e);
			 } 
		} 
	 
	/** 处理列出所有客户清单的动作 */ 
	 public void handleGetAllStudentsGesture()
	 {
		 try{ 
			 storeModel.getAllStudents(); 
			 }
		 catch(Exception e)
		 {
			 reportException(e);
			 } 
		 } 
}
