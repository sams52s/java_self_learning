package dsi.sams.Entity;

import java.util.HashMap;
import java.util.Map;

public class StudentInfo {
    private int roll;
    private String name;
    private int totalMark;
    private boolean isPass;
    private String pass;
    private Map<Integer, MarksInfo> marks;


    public StudentInfo(int roll, String name) {
        this.roll = roll;
        this.name = name;
        this.totalMark = 0;
        this.isPass = true;
        marks = new HashMap<>();
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, MarksInfo> getMarks() {
        return marks;
    }

    public void setMarks(Map<Integer, MarksInfo> marks) {
        this.marks = marks;
    }

    public int getTotalMark(){
        return totalMark;
    }
    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public void addOrUpdateMarks(int subjectCode, int mark, boolean isPass){
        marks.putIfAbsent(subjectCode, new MarksInfo());
        MarksInfo markInfo = marks.get(subjectCode);
        markInfo.updateMark(mark);
        markInfo.setIsPass(isPass);
        totalMark += mark;
        this.isPass = this.isPass && isPass;
        if(this.isPass){
            this.pass="T";
        }
        else {
            this.pass="F";
        }

    }

    @Override
    public String toString() {
        return "" +
                "" + roll +
                ":" + name  +
                ":" + totalMark +
                ":"+pass
                ;
    }
}
