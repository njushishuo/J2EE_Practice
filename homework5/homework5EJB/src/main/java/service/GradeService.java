package service;

import model.Exam;
import model.Grade;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by ss14 on 2016/12/31.
 */
@Remote
public interface GradeService {

    List<Exam> getUnAttendedExamIds(int stdId);

    List<Grade> getAllGrades(int stdId);
}
