package model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by ss14 on 2016/12/18.
 */

public class Exam implements Serializable {

    private int id;
    private String courseName;
    private Timestamp start_at;
    private Timestamp end_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Timestamp getStart_at() {
        return start_at;
    }

    public void setStart_at(Timestamp start_at) {
        this.start_at = start_at;
    }

    public Timestamp getEnd_at() {
        return end_at;
    }

    public void setEnd_at(Timestamp end_at) {
        this.end_at = end_at;
    }
}
