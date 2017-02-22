package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by ss14 on 2017/2/21.
 */
@Entity
public class Exam {
    private int id;
    private String courseName;
    private Timestamp startAt;
    private Timestamp endAt;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "course_name")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "start_at")
    public Timestamp getStartAt() {
        return startAt;
    }

    public void setStartAt(Timestamp startAt) {
        this.startAt = startAt;
    }

    @Basic
    @Column(name = "end_at")
    public Timestamp getEndAt() {
        return endAt;
    }

    public void setEndAt(Timestamp endAt) {
        this.endAt = endAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exam exam = (Exam) o;

        if (id != exam.id) return false;
        if (courseName != null ? !courseName.equals(exam.courseName) : exam.courseName != null) return false;
        if (startAt != null ? !startAt.equals(exam.startAt) : exam.startAt != null) return false;
        if (endAt != null ? !endAt.equals(exam.endAt) : exam.endAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (startAt != null ? startAt.hashCode() : 0);
        result = 31 * result + (endAt != null ? endAt.hashCode() : 0);
        return result;
    }
}
