package InfoSys.view;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ValueObject.*;
import Manager.*;
public class Gui {
	  protected JFrame frame;
	  protected Container contentPane;
	  protected CardLayout card=new CardLayout();
	  protected JPanel cardPan=new JPanel();
	  //�������ְ�ť��ѡ������ϵ����
	  protected JPanel selPan=new JPanel();
	  protected JButton custBt=new JButton("ѧ����ϸ��Ϣ");
	  protected JButton allCustBt=new JButton("����ѧ���嵥");
	  //��ʾ�����ͻ�������ϵ����
	  protected JPanel custPan=new JPanel();
	  protected JLabel nameLb=new JLabel("ѧ������");
	  protected JLabel idLb=new JLabel("ID");
	  protected JLabel scoreLb=new JLabel("�ɼ�");
	  protected JLabel ageLb=new JLabel("����");
	  protected JTextField nameTf=new JTextField(25);
	  protected JTextField idTf=new JTextField(25);
	  protected JTextField scoreTf=new JTextField(25);
	  protected JTextField ageTf=new JTextField(25);
	  protected JButton getBt=new JButton("��ѯѧ��");
	  protected JButton updBt=new JButton("����ѧ��");
	  protected JButton addBt=new JButton("���ѧ��");
	  protected JButton delBt=new JButton("ɾ��ѧ��");
	  //�о����пͻ�������ϵ����
	  protected JPanel allCustPan=new JPanel();
	  protected JLabel allCustLb=new JLabel("����ѧ���嵥",SwingConstants.CENTER);
	  protected JTextArea allCustTa=new JTextArea();
	  protected JScrollPane allCustSp=new JScrollPane(allCustTa);
	  String[] tableHeaders={"ID","����","����","�ɼ�"};
	  JTable table;
	  JScrollPane tablePane;
	  DefaultTableModel tableModel;
	  //��־����ϵ����
	  protected JPanel logPan=new JPanel();
	  protected JLabel logLb=new JLabel("������־",SwingConstants.CENTER);
	  protected JTextArea logTa=new JTextArea(9,50);
	  protected JScrollPane logSp=new JScrollPane(logTa);
	  
	  /** ��ʾ�����ͻ���� custPan */
	  public void refreshCustPane(Student s){
	    showCard("student");
	    if(s == null){
	      idTf.setText(null);
	      nameTf.setText(null);
	      scoreTf.setText(null);
	      ageTf.setText(null);
	      return;
	    }
	    idTf.setText(new Long(s.id).toString());
	    nameTf.setText(s.name.trim());
	    ageTf.setText(new Integer(s.age).toString());
	    scoreTf.setText(new Float(s.score).toString());
	  }
	  
	  /** ��ʾ���пͻ���� allCustPan */
	  public void refreshAllCustPan(Set custs){
	    showCard("allstudents");
	    String newData[][];
	    newData=new String[custs.size()][4];
	    Iterator it=custs.iterator();
	    int i=0; 
	    while(it.hasNext()){
	      Student s=(Student)it.next();
	      newData[i][0]=new Long(s.id).toString();
	      newData[i][1]=s.name;
	      newData[i][2]=new Float(s.score).toString();
	      newData[i][3]=new Integer(s.age).toString();
	      i++; 
	    }
	    tableModel.setDataVector(newData,tableHeaders);
	  }
	  
	  /** ����־���logPan�������־��Ϣ */
	  public void updateLog(String msg){
	    logTa.append(msg+"\n");
	  }
	  /** ��ÿͻ����custPan���û������ID */
	  public long getCustIdOnCustPan(){
	     try{
	       return Long.parseLong(idTf.getText().trim());
	     }catch(Exception e){
	       updateLog(e.getMessage());
	       return -1;
	     }
	  }
	  
	  /** ��õ����ͻ����custPan���û�����Ŀͻ���Ϣ */
	  public Student getCustomerOnCustPan(){
	    try{
	    	Student s = new Student();
	    	s.id = Long.parseLong(idTf.getText().trim());
	    	s.name = nameTf.getText().trim();
	    	s.age = Integer.parseInt(ageTf.getText().trim());
	    	s.score = Float.parseFloat(scoreTf.getText().trim());
	    	return s;
	    }catch(Exception e){
	      updateLog(e.getMessage());
	      return null; 
	    }
	  }
	  
	  /** ��ʾ�����ͻ����custPan�������пͻ����allCustPan */
	  private void showCard(String cardStr){
	    card.show(cardPan,cardStr);
	  }
	  
	  /** ���췽�� */
	  public Gui(){
	    buildDisplay();
	  }
	  
	  /** ����ͼ�ν��� */
	  private void buildDisplay(){
	   frame=new JFrame("��Ϣ����ϵͳ");
	   buildSelectionPanel();
	   buildCustPanel();
	   buildAllCustPanel();
	   buildLogPanel();
	   
	   /** carPan����CardLayout���ֹ�����������custPan��allCustPan���ſ�Ƭ */
	   cardPan.setLayout(card);
	   cardPan.add(custPan,"student");
	   cardPan.add(allCustPan,"allstudents");
	   //���������м���������
	   contentPane=frame.getContentPane();
	   contentPane.setLayout(new BorderLayout());
	   contentPane.add(cardPan,BorderLayout.CENTER);
	   contentPane.add(selPan,BorderLayout.NORTH);
	   contentPane.add(logPan,BorderLayout.SOUTH);
	   frame.pack();
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setVisible(true);
	  }
	 
	  /** ����ѡ�����selPan */ 
	  private void buildSelectionPanel(){
		  selPan.setLayout(new BorderLayout());
		  selPan.add(custBt,BorderLayout.WEST);
		  selPan.add(allCustBt,BorderLayout.EAST);
	  }
	  /** Ϊѡ�����selPan�е�������ťע������� */
	  public void addSelectionPanelListeners(ActionListener a[]){
	   int len=a.length;
	   if(len!=2){ return;}
	   custBt.addActionListener(a[0]);
	   allCustBt.addActionListener(a[1]);
	 }
	  
	  /**�����������ͻ�custPan��� */
	  private void buildCustPanel(){
		  custPan.setLayout(new GridLayout(6,2));
		  custPan.add(idLb);
		  custPan.add(idTf);
		  custPan.add(nameLb);
		  custPan.add(nameTf);
		  custPan.add(ageLb);
		  custPan.add(ageTf);
		  custPan.add(scoreLb);
		  custPan.add(scoreTf);
		  custPan.add(getBt);
		  custPan.add(updBt);
		  custPan.add(addBt);
		  custPan.add(delBt);
	  }
	  
	  /** Ϊ�����ͻ����custPan�е�4����ťע������� */
	  public void addCustPanelListeners(ActionListener a[]){
	    int len=a.length;
	    if(len!=4){ return;}
	   getBt.addActionListener(a[0]);
	   addBt.addActionListener(a[1]);
	   delBt.addActionListener(a[2]);
	   updBt.addActionListener(a[3]);
	  }
	  
	  /** �������пͻ�allCustPan��� */
	  private void buildAllCustPanel(){
	    allCustPan.setLayout(new BorderLayout());
	    allCustPan.add(allCustLb,BorderLayout.NORTH);
	    allCustTa.setText("all customer display");
	    tableModel=new DefaultTableModel(tableHeaders,10);
	    table=new JTable(tableModel);
	    tablePane=new JScrollPane(table);
	    allCustPan.add(tablePane,BorderLayout.CENTER);
	    Dimension dim=new Dimension(500,150);
	    table.setPreferredScrollableViewportSize(dim);
	  }
	  
	  /** ������־���*/
	  private void buildLogPanel(){
		  logPan.setLayout(new BorderLayout());
		  logPan.add(logLb);
		  logPan.add(logSp);
	  }
}
