	package InfoSys;

	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import javax.sql.DataSource;
	import java.sql.*;

	public class A {
		public static void main(String[] args) throws Exception{
			//������ʾ
			//�����ࡰcom.mysql.jdbc.Driver�����������á��µ������������ǡ�com.mysq .cj.jdbc. driver����
			//����������ͨ��SPI�Զ�ע��ģ��ֶ���������������ͨ���ǲ���Ҫ�� 
			System.out.println(1);
			try {
				System.out.println(1);
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
				System.out.println("���ӳɹ�");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from student");
			}
			catch(Exception e) {
				System.out.println("���Ӳ�ѯʧ��");
			}
		}
	}
