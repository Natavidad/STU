package InfoSys;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import java.sql.*;

public class JDBC {
	public static void main(String args[]) throws Exception{
		//程序提示
		//加载类“com.mysql.jdbc.Driver”。这是弃用。新的驱动程序类是“com.mysq .cj.jdbc. driver”。
		//驱动程序是通过SPI自动注册的，手动加载驱动程序类通常是不必要的 
		try {
			System.out.println(1);
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
			System.out.println("连接成功");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
		}
		catch(Exception e) {
			System.out.println("连接查询失败");
		}
	}
}
