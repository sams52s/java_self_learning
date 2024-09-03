package dsi.sams.Handler;


import java.io.IOException;
import java.io.PrintWriter;

public class FileHandler {
    /**
     * this function could be written in main class but for avoiding writing code in main I create this method.
     * Here I create all file path.
     * Main two readFile Method is here and file path is given as a parameter.
     * Write/create methods are also called here
     * Finally I call the clear function to clear details.
     * So this is the main function here all procedure starts and also ends here step by step.
     */
    public static void main(){
        String rootPath = "/home/dsi/work/Learning Java/Basic java/ResultProcessing/src/dsi/sams/util/providedFiles/";
        String marksFile = rootPath + "marks.csv";
        String paperInfoFile = rootPath + "paper_info.csv";
        String studentInfoFile = rootPath + "student_info.csv";
        String subjectPaperFile = rootPath + "subject_paper.csv";
        PaperHandler.loadSubjectDetails(subjectPaperFile, paperInfoFile);
        StudentHandler.loadStudentInfoDetails(studentInfoFile, marksFile);
        createResultFile();
        createMarkSheetFile();
        clear();

    }

    /**
     * this function will clear Details values.
     * So that I can prevent sort wastage's.
     */
    public static void clear(){
        PaperHandler.paperDetails.clear();
        StudentHandler.studentDetails.clear();
    }
    public static void createResultFile(){
        String writerPath ="/home/dsi/work/Learning Java/Basic java/ResultProcessing/src/dsi/sams/util/outPutFiles/result.csv"; //this is the path where I store result file
        try (PrintWriter pw = new PrintWriter(writerPath)) {
            /**
             *stream the Details and mapped by rollNo cause rollNo is the key value here.
             * After Mapping creating csv file according to toString() method of StudentInfo.
             */
            StudentHandler.studentDetails.keySet().stream().map((rollNo -> StudentHandler.studentDetails.get(rollNo))).forEach(pw::println);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    //Same system like createResultFile..
    public static void createMarkSheetFile(){
        String writerPath ="/home/dsi/work/Learning Java/Basic java/ResultProcessing/src/dsi/sams/util/outPutFiles/mark_sheet.csv"; //this is the path where I store Marks sheet file
        try (PrintWriter pw = new PrintWriter(writerPath)) {
            PaperHandler.paperDetails.keySet().stream().map((rollNo -> PaperHandler.paperDetails.get(rollNo))).forEach(pw::println);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}

