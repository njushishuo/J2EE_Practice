package model;

import lombok.Data;

import java.io.Serializable;


/**
 * Created by ss14 on 2016/12/18.
 */

public class Grade implements Serializable {

    private Exam exam;
    private int score;

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
