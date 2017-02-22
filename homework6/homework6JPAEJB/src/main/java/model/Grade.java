package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ss14 on 2017/2/22.
 */
@Entity
public class Grade  implements Serializable {
    private int studentId;
    private Integer score;
    private Exam exam;

    @Id
    @Column(name = "student_id")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "score")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grade grade = (Grade) o;

        if (studentId != grade.studentId) return false;
        if (score != null ? !score.equals(grade.score) : grade.score != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "id", nullable = false)
    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
