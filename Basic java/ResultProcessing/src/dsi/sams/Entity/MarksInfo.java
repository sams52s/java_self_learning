package dsi.sams.Entity;

public class MarksInfo {
    private int mark;
    private boolean isPass;

    public MarksInfo() {
        mark = 0;
        isPass = true;
    }

    public void updateMark(int mark){
        this.mark += mark;
    }

    public void setIsPass(boolean isPass){
        this.isPass = isPass;
    }

}
