package model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by ss14 on 2016/12/18.
 */
@Data
public class Exam {

    private int id;
    private String courseName;
    private Timestamp start_at;
    private Timestamp end_at;
}
