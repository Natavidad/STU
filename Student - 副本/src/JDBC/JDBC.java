package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import java.sql.*;

public class JDBC {
	public static void main(String args[]) throws Exception{
		//������ʾ
		//�����ࡰcom.mysql.jdbc.Driver�����������á��µ������������ǡ�com.mysql.cj.jdbc.driver����
		//����������ͨ��SPI�Զ�ע��ģ��ֶ���������������ͨ���ǲ���Ҫ�� 
			System.out.println(1);
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useSSL=true","root","root");
			System.out.println("���ӳɹ�");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			System.out.println(rs.getString(1));
	}
}