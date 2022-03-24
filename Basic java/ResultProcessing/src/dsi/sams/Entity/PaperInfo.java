package dsi.sams.Entity;

public class PaperInfo {
    private int subjectCode;
    private int paperCode;
    private int theoryMark;
    private int practicalMark;

    public PaperInfo(int paperCode, int subjectCode) {
        this.subjectCode = subjectCode;
        this.paperCode = paperCode;
    }

    public PaperInfo(int subjectCode, int paperCode, int theoryMark, int practicalMark) {
        this.subjectCode = subjectCode;
        this.paperCode = paperCode;
        this.theoryMark = theoryMark;
        this.practicalMark = practicalMark;
    }

    @Override
    public String toString() {
        return "PaperInfo{" +
                "subjectCode=" + subjectCode +
                ", paperCode=" + paperCode +
                ", theoryMark=" + theoryMark +
                ", practicalMark=" + practicalMark +
                '}';
    }

    public int getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(int subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getPaperCode() {
        return paperCode;
    }

    public void setPaperCode(int paperCode) {
        this.paperCode = paperCode;
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

