package tools;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    private static DBUtil dbUtil ;

    private InitialContext jndiContext = null;
    private Connection connection = null;
    private DataSource datasource = null;


    private DBUtil()
    {
        try {
            jndiContext = new InitialContext();
            datasource = (DataSource) jndiContext.lookup("java:comp/env/jdbc/j2eehw");
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("got context");
    }

    public static DBUtil getDBUtilInstance()
    {
        if(dbUtil==null){
            dbUtil = new DBUtil();
        }
        return dbUtil;
    }

    public  Connection getConnection() {


        try {
            connection = datasource.getConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }


        return connection;

//        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/homework2";
//        String username = "root";
//        String password = "root";
//        Connection conn = null;
//        try {
//            Class.forName(driver); //classLoader,加载对应驱动
//            conn = (Connection) DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;

    }

    public  boolean closeAll(ResultSet rst, Statement stmt , Connection conn) {
        // TODO 关闭所有连接
        boolean flag = false;
        try {
            if(rst!=null){
                rst.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            if(conn!=null&&!conn.isClosed()){
                conn.close();
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}