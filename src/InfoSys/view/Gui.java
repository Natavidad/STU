package InfoSys.view;
import java.awt.*;
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
	  //包含各种按钮的选择面板上的组件
	  protected JPanel selPan=new JPanel();
	  protected JButton custBt=new JButton("学生详细信息");
	  protected JButton allCustBt=new JButton("所有学生清单");
	  //显示单个客户的面板上的组件
	  protected JPanel custPan=new JPanel();
	  protected JLabel nameLb=new JLabel("学生姓名");
	  protected JLabel idLb=new JLabel("ID");
	  protected JLabel scoreLb=new JLabel("成绩");
	  protected JLabel ageLb=new JLabel("年龄");
	  protected JTextField nameTf=new JTextField(25);
	  protected JTextField idTf=new JTextField(25);
	  protected JTextField scoreTf=new JTextField(25);
	  protected JTextField ageTf=new JTextField(25);
	  protected JButton getBt=new JButton("查询学生");
	  protected JButton updBt=new JButton("更新学生");
	  protected JButton addBt=new JButton("添加学生");
	  protected JButton delBt=new JButton("删除学生");
	  //列举所有客户的面板上的组件
	  protected JPanel allCustPan=new JPanel();
	  protected JLabel allCustLb=new JLabel("所有学生清单",SwingConstants.CENTER);
	  protected JTextArea allCustTa=new JTextArea();
	  protected JScrollPane allCustSp=new JScrollPane(allCustTa);
	  String[] tableHeaders={"ID","姓名","年龄","成绩"};
	  JTable table;
	  JScrollPane tablePane;
	  DefaultTableModel tableModel;
	  //日志面板上的组件
	  protected JPanel logPan=new JPanel();
	  protected JLabel logLb=new JLabel("操作日志",SwingConstants.CENTER);
	  protected JTextArea logTa=new JTextArea(9,50);
	  protected JScrollPane logSp=new JScrollPane(logTa);
	  
	  /** 显示单个客户面板 custPan */
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
	  
	  /** 显示所有客户面板 allCustPan */
	  public void refreshAllCustPan(Set custs){
	    showCard("allstudents");
	    String newData[][];
	    newData=new String[custs.size()][4];
	    Iterator it=custs.iterator();
	    int i=0; 
	    while(it.hasNext()){
	      Student s=(Student) it.next();
	      newData[i][0]=new Long(cust.getId()).toString();
	      newData[i][1]=cust.getName();
	      newData[i][2]=cust.getAddr();
	      newData[i][3]=new Integer(cust.getAge()).toString();
	      i++; 
	    }
	    tableModel.setDataVector(newData,tableHeaders);
	  }
	  
	  /** 在日志面板logPan中添加日志信息 */
	  public void updateLog(String msg){
	    logTa.append(msg+"\n");
	  }
	  /** 获得客户面板custPan上用户输入的ID */
	  public long getCustIdOnCustPan(){
	     try{
	       return Long.parseLong(idTf.getText().trim());
	     }catch(Exception e){
	       updateLog(e.getMessage());
	       return -1;
	     }
	  }
	  
	  /** 获得单个客户面板custPan上用户输入的客户信息 */
	  public Customer getCustomerOnCustPan(){
	    try{
	      return new Customer(Long.parseLong(idTf.getText().trim()),
	        nameTf.getText().trim(),addrTf.getText().trim(),
	        Integer.parseInt(ageTf.getText().trim()));
	    }catch(Exception e){
	      updateLog(e.getMessage());
	      return null; 
	    }
	  }
	  
	  /** 显示单个客户面板custPan或者所有客户面板allCustPan */
	  private void showCard(String cardStr){
	    card.show(cardPan,cardStr);
	  }
	  
	  /** 构造方法 */
	  public StoreGui(){
	    buildDisplay();
	  }
	  
	  /** 创建图形界面 */
	  private void buildDisplay(){
	   frame=new JFrame("商店的客户管理系统");
	   buildSelectionPanel();
	   buildCustPanel();
	   buildAllCustPanel();
	   buildLogPanel();
	   
	   /** carPan采用CardLayout布局管理器，包括custPan和allCustPan两张卡片 */
	   cardPan.setLayout(card);
	   cardPan.add(custPan,"customer");
	   cardPan.add(allCustPan,"allcustomers");
	   //向主窗体中加入各种面板
	   contentPane=frame.getContentPane();
	   contentPane.setLayout(new BorderLayout());
	   contentPane.add(cardPan,BorderLayout.CENTER);
	   contentPane.add(selPan,BorderLayout.NORTH);
	   contentPane.add(logPan,BorderLayout.SOUTH);
	   frame.pack();
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setVisible(true);
	  }
	 
	  /** 创建选择面板selPan */ 
	  private void buildSelectionPanel(){…}
	  /** 为选择面板selPan中的两个按钮注册监听器 */
	  public void addSelectionPanelListeners(ActionListener a[]){
	   int len=a.length;
	   if(len!=2){ return;}
	   custBt.addActionListener(a[0]);
	   allCustBt.addActionListener(a[1]);
	 }
	  
	  /**　创建单个客户custPan面板 */
	  private void buildCustPanel(){…}
	  
	  /** 为单个客户面板custPan中的4个按钮注册监听器 */
	  public void addCustPanelListeners(ActionListener a[]){
	    int len=a.length;
	    if(len!=4){ return;}
	   getBt.addActionListener(a[0]);
	   addBt.addActionListener(a[1]);
	   delBt.addActionListener(a[2]);
	   updBt.addActionListener(a[3]);
	  }
	  
	  /** 创建所有客户allCustPan面板 */
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
	  
	  /** 创建日志面板*/
	  private void buildLogPanel(){…}
	}
}
