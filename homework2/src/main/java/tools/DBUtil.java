package tools;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

public class DBUtil {

    private static DataSource datasource;

    public static Connection getConnection() {

//        Connection con = null;
//        try {
//            Context ic = new InitialContext();
//            DataSource source = (DataSource) ic.lookup("java:comp/env/homework2Query");
//            con = source.getConnection();
//        } catch (NamingException e) {
//            System.out.println("数据源没找到！");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.out.println("获取数连接对象失败！");
//            e.printStackTrace();
//        }
//        return con;


        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/homework2";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static boolean closeAll(ResultSet rst, Statement stmt , Connection conn) {
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