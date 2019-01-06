package InfoSys;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
    //ʹ�������ļ���Ĭ������
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    //����ר������
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();


    /*
     * ���Connection����
     */
    public static Connection getConnection() throws SQLException {
        //��connection������null˵���Ѿ����ù�beginTransaction()
        Connection connection = threadLocal.get();
        if(connection != null) {
            return connection;
        } else {
            return dataSource.getConnection();
        }
    }

    /*
     * �ͷ���Դ
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
     * ��������
     * 1.��ȡConnection����
     * 2.����setAutoCommit(false)
     * ��Ҫ��֤��DAO��ʹ�õ���ͬһ��Connection����
     */
    public static void beginTransaction() throws SQLException {
        /*
         * 1.��connection��ֵ
         * 2.����setAutoCommit(false)
         */

        Connection connection = threadLocal.get();

        if (connection != null) {
            throw new SQLException("�Ѿ���������!");
        }

        connection = getConnection();

        connection.setAutoCommit(false);
        threadLocal.set(connection);
    }

    /*
     * �ύ����
     * 1.��ȡbeginTransaction�ṩ��Connection����
     * 2.����Connection#commit
     */
    public static void commitTransaction() throws SQLException {

        Connection connection = threadLocal.get();		//��ȡ��ǰ�̵߳�ר������

        if (connection == null) {
            throw new SQLException("��û�п�������,�޷��ύ��");
        }

        connection.commit();
        connection.close();
        threadLocal.remove();
    }

    public static void rollbackTransaction() throws SQLException {
        Connection connection = threadLocal.get();
        if (connection == null) {
            throw new SQLException("��û�п�������,�޷��ع���");
        }

        connection.rollback();
        connection.close();
        threadLocal.remove();
    }

    public static void releaseConnection(Connection connection) throws SQLException {
        /*
         * ���������zhuanyongConnection�Ͳ��ر�
         * �����������ר��,��ô��Ҫ�ر�
         */

        Connection con = threadLocal.get();

        if(con == null) {	//˵��û�п�������
            connection.close();
        }
        if(connection != con) {	//������,����Ҫ�жϲ��������Ƿ���this.connection���
            connection.close();
        }

    }

}
 