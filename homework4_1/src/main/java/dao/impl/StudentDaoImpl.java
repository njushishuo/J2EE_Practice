package dao.impl;

import dao.StudentDao;
import model.Student;
import tools.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ss14 on 2016/12/18.
 */
public class StudentDaoImpl implements StudentDao {

    private static StudentDaoImpl studentDaoImpl;
    private static DBUtil dbUtil;

    private StudentDaoImpl(){
        dbUtil = DBUtil.getDBUtilInstance();
    }

    public static StudentDaoImpl getStudentDaoImpl(){
        if(studentDaoImpl==null){
            studentDaoImpl = new StudentDaoImpl();
        }
        return studentDaoImpl;
    }

    public boolean exists(String username ){

        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        connection = dbUtil.getConnection();

        try {
            stmt = connection.prepareStatement("select * from student where username=?");
            stmt.setString(1, username);
            result = stmt.executeQuery();
            if(!result.next()){

                dbUtil.closeAll(result,stmt,connection);
                return false;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        dbUtil.closeAll(result,stmt,connection);
        return true;
    }

    public Student getStudentByUsername(String username){

        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        connection = dbUtil.getConnection();

        try {
            stmt = connection.prepareStatement("select * from student where username=?");
            stmt.setString(1, username);
            result = stmt.executeQuery();


            if(result.next()){
                Student student = new Student();
                student.setId(result.getInt("id"));
                student.setName(result.getString("name"));
                student.setUsername(result.getString("username"));
                student.setPassword(result.getString("password"));

                dbUtil.closeAll(result,stmt,connection);
                return  student;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        dbUtil.closeAll(result,stmt,connection);
        return null;
    }


}
