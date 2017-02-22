package dao;

import model.Exam;
import model.Grade;

import java.util.List;

/**
 * Created by ss14 on 2016/12/31.
 */
public interface GradeDao {

    List<Exam> getUnAttendedExams(int stdId);

    List<Grade> getAllGrades(int stdId);
}
