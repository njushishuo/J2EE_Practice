package dao;

import model.Exam;
import model.Grade;
import tools.DBUtil;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss14 on 2016/12/18.
 */
@Stateless
public class GradeDaoBean implements GradeDao {

    private static DBUtil dbUtil =DBUtil.getDBUtilInstance();

    /**
     * 返回未参加的测验
     * 如果参加过全部测验，返回的list.size==0
     * @param stdId
     * @return
     */
    public List<Exam> getUnAttendedExamIds(int stdId){

        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        ArrayList arrayList = null;
        connection = dbUtil.getConnection();
        try {
            stmt = connection.prepareStatement("select exam.* from grade, exam  where  student_id=? and score is NULL and exam.id = grade.exam_id");
            stmt.setInt(1, stdId);
            result = stmt.executeQuery();
            arrayList = new ArrayList();

            while(result.next()){
                Exam exam = new Exam();
                exam.setId(result.getInt("id"));
                exam.setCourseName(result.getString("course_name"));
                exam.setStart_at(result.getTimestamp("start_at"));
                exam.setEnd_at(result.getTimestamp("end_at"));
                arrayList.add(exam);
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        dbUtil.closeAll(result,stmt,connection);
        return arrayList;
    }


    public List<Grade> getAllGrades(int stdId){
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        ArrayList arrayList = null;
        connection = dbUtil.getConnection();

        try {
            stmt = connection.prepareStatement("select * from grade,exam  where  student_id=? and grade.exam_id = exam.id");
            stmt.setInt(1, stdId);
            result = stmt.executeQuery();
            arrayList = new ArrayList();
            while(result.next()){
                Grade grade = new Grade();
                Exam exam = new Exam();
                exam.setId(result.getInt("id"));
                exam.setCourseName(result.getString("course_name"));
                exam.setStart_at(result.getTimestamp("start_at"));
                exam.setEnd_at(result.getTimestamp("end_at"));
                grade.setExam(exam);
                grade.setScore(result.getInt("score"));
                arrayList.add(grade);

            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        dbUtil.closeAll(result,stmt,connection);
        return arrayList;
    }
}
