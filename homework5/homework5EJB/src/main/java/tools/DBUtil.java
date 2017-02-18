package tools;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

public class DBUtil {

    private static DBUtil dbUtil ;

    private InitialContext jndiContext = null;
    private Connection connection = null;
    private DataSource datasource = null;


    private DBUtil()
    {

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
            final Hashtable properties = new Hashtable();
            properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

            try {
                jndiContext = new InitialContext(properties);
                datasource = (DataSource) jndiContext.lookup("java:/MySqlDS");
                if (datasource==null)
                    System.out.println("datasource null");
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("got context");
            System.out.println("About to get ds---DaoHelper");
            connection = datasource.getConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }


        return connection;

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