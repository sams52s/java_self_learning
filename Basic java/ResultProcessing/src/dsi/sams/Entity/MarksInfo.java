package dsi.sams.Entity;

public class MarksInfo {
    private int mark;
    private boolean isPass;

    /**
     * For checking is pass and storing marks.
     */
    public MarksInfo() {
        mark = 0;
        isPass = true;
    }

    public void updateMark(int mark){
        this.mark += mark;
    }//here storing sum of all mark input
    public void setIsPass(boolean isPass){
        this.isPass = isPass;
    }
}
