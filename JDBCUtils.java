package pub.liyf.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
    //使用配置文件的默认配置
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    //事务专用连接
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();


    /*
     * 获得Connection对象
     */
    public static Connection getConnection() throws SQLException {
        //当connection不等于null说明已经调用过beginTransaction()
        Connection connection = threadLocal.get();
        if(connection != null) {
            return connection;
        } else {
            return dataSource.getConnection();
        }
    }

    /*
     * 释放资源
     */
    public static void close(Connection connection,Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection,Statement statement,ResultSet resultSet) {
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    /*
     * 开启事务
     * 1.获取Connection对象
     * 2.设置setAutoCommit(false)
     * 需要保证与DAO中使用的是同一个Connection对象
     */
    public static void beginTransaction() throws SQLException {
        /*
         * 1.给connection赋值
         * 2.设置setAutoCommit(false)
         */

        Connection connection = threadLocal.get();

        if (connection != null) {
            throw new SQLException("已经开启事务!");
        }

        connection = getConnection();

        connection.setAutoCommit(false);
        threadLocal.set(connection);
    }

    /*
     * 提交事务
     * 1.获取beginTransaction提供的Connection对象
     * 2.调用Connection#commit
     */
    public static void commitTransaction() throws SQLException {

        Connection connection = threadLocal.get();		//获取当前线程的专用连接

        if (connection == null) {
            throw new SQLException("还没有开启事务,无法提交！");
        }

        connection.commit();
        connection.close();
        threadLocal.remove();
    }

    public static void rollbackTransaction() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection == null) {
            throw new SQLException("还没有开启事务,无法回滚！");
        }

        connection.rollback();
        connection.close();
        threadLocal.remove();
    }

    public static void releaseConnection(Connection connection) throws SQLException {
        /*
         * 如果是事务zhuanyongConnection就不关闭
         * 如果不是事务专用,那么就要关闭
         */

        Connection con = threadLocal.get();

        if(con == null) {	//说明没有开启事务
            connection.close();
        }
        if(connection != con) {	//有事务,但需要判断参数连接是否与this.connection相等
            connection.close();
        }

    }

}
