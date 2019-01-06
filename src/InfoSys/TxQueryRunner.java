package InfoSys;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class TxQueryRunner extends QueryRunner {


    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        /*
         * 1.得到连接
         * 2.执行父类方法
         * 3.释放链接
         */
        Connection connection = JDBCUtils.getConnection();

        int[] result =  super.batch(connection,sql, params);

        JDBCUtils.releaseConnection(connection);

        return result;
    }

    @Override
    public int execute(String sql, Object... params) throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        int result =  super.execute(connection,sql, params);
        JDBCUtils.releaseConnection(connection);
        return result;
    }

    @Override
    public <T> List<T> execute(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        List<T> result =  super.execute(sql, rsh, params);
        JDBCUtils.releaseConnection(connection);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        T result =  super.query(connection,sql, rsh, params);

        JDBCUtils.releaseConnection(connection);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        T result =  super.query(connection,sql, rsh);

        JDBCUtils.releaseConnection(connection);
        return result;
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        int result =  super.update(connection,sql, params);

        JDBCUtils.releaseConnection(connection);
        return result;
    }

    @Override
    public int update(String sql, Object param) throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        int result =  super.update(connection,sql, param);

        JDBCUtils.releaseConnection(connection);
        return result;
    }

    @Override
    public int update(String sql) throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        int result =  super.update(connection,sql);

        JDBCUtils.releaseConnection(connection);
        return result;
    }

}