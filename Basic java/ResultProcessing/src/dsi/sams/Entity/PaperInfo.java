package dsi.sams.Entity;

import java.util.HashMap;
import java.util.Map;

public class PaperInfo {
    private int roll;
    private int subjectCode;
    private int paperCode;
    private int theoryMark;
    private int practicalMark;
    private int totalMarkInASubject;
    private boolean isPass;
    private String pass;


    public PaperInfo(int paperCode, int subjectCode) {
        this.subjectCode = subjectCode;
        this.paperCode = paperCode;
        this.theoryMark=0;
        this.isPass=true;
    }
    //This method is for crating Mark_sheet.csv file.
    public void addOrUpdateMarkSheet(int roll,int subjectCode, int mark, boolean isPass){
        this.roll=roll;
        this.subjectCode=subjectCode;
        this.totalMarkInASubject=mark;
        this.isPass = this.isPass && isPass;
        //isPass is a boolean value. It will give True and false value that won't look nice. So I convert that in a symbolic version.
        if(this.isPass){
            this.pass="T";
        }
        else {
            this.pass="F";
        }

    }

    /**
     * @return this will return all values I need to write Mark_Sheet.csv.
     */
    @Override
    public String toString() {
        return "" +roll+
                ":" + subjectCode +
                ":" +totalMarkInASubject+
                ":" + pass
                ;
    }

    public int getSubjectCode() {
        return subjectCode;
    }
    public int getTheoryMark() {
        return theoryMark;
    }

    public void setTheoryMark(int theoryMark) {
        this.theoryMark = theoryMark;
    }

    public int getPracticalMark() {
        return practicalMark;
    }

    public void setPracticalMark(int practicalMark) {
        this.practicalMark = practicalMark;
    }
}

