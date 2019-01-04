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
			 view.addUserGestureListener(this);  //����ͼע����������� 
	 	}catch(Exception e)
		 { 
	 		reportException(e);
	 	}
	 } 
	 
	/** �����쳣��Ϣ */ 
	 private void reportException(Object o)
	 { 
		 try{ storeView.showDisplay(o); }
	 catch(Exception e){ 
		 System.out.println("StoreControllerImpl reportException"+e); 
		 } 
	 } 
	 
	/** ������� ID ��ѯ�ͻ��Ķ��� */ 
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
	 
	/** ������ӿͻ��Ķ��� */ 
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
	 
	/** ����ɾ���ͻ��Ķ��� */ 
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
	 
	/** ������¿ͻ��Ķ��� */
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
	 
	/** �����г����пͻ��嵥�Ķ��� */ 
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
