package dsi.sams.Handler;

public class SubjectHandler {
    private int subjectCode;
    private int paperCode;
    private int theoryMark;
    private int practicalMark;
    private String hasTheory;
    private String hasPractical;
    private int theoryPassMark;
    private int practicalPassMark;

    public SubjectHandler(int subjectCode, int paperCode, int theoryMark, int practicalMark, String hasTheory, String hasPractical, int theoryPassMark, int practicalPassMark) {
        this.subjectCode = subjectCode;
        this.paperCode = paperCode;
        this.theoryMark = theoryMark;
        this.practicalMark = practicalMark;
        this.hasTheory = hasTheory;
        this.hasPractical = hasPractical;
        this.theoryPassMark = theoryPassMark;
        this.practicalPassMark = practicalPassMark;
    }

    @Override
    public String toString() {
        return "\n SubjectHandler{" +
                "subjectCode=" + subjectCode +
                ", paperCode=" + paperCode +
                ", theoryMark=" + theoryMark +
                ", practicalMark=" + practicalMark +
                ", hasTheory='" + hasTheory + '\'' +
                ", hasPractical='" + hasPractical + '\'' +
                ", theoryPassMark=" + theoryPassMark +
                ", practicalPassMark=" + practicalPassMark +
                '}';
    }
}

