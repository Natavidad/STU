package InfoSys;

import java.sql.DriverManager;
import java.sql.*;
import com.sun.corba.se.pept.transport.Connection;

public class JDBC {
	public static void main(String args[]) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		//������ʾ
		//�����ࡰcom.mysql.jdbc.Driver�����������á��µ������������ǡ�com.mysq .cj.jdbc. driver����
		//����������ͨ��SPI�Զ�ע��ģ��ֶ���������������ͨ���ǲ���Ҫ�� 
		try {
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
			System.out.println("���ӳɹ�");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");}
		catch(Exception e) {
			System.out.println("���Ӳ�ѯʧ��");
		}
	}
}
