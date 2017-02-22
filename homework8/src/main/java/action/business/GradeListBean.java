package action.business;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ss14 on 2017/1/4.
 */
public class GradeListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List gradeList;

    public List getGradeList(){
        return  this.gradeList;
    }

    public void setGradeList(List gradeList){
        this.gradeList = gradeList;
    }
}
