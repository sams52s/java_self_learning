package dsi.sams.Handler;

import dsi.sams.Entity.StudentInfo;

import java.io.*;
import java.util.*;


public class FileHandler {
    public static void Read(){
        String rootPath = "/home/dsi/work/Learning Java/Basic java/ResultProcessing/src/dsi/sams/util/providedFiles/";
        String marksFile = rootPath + "marks.csv";
        String paperInfoFile = rootPath + "paper_info.csv";
        String studentInfoFile = rootPath + "student_info.csv";
        String subjectPaperFile = rootPath + "subject_paper.csv";
        PaperHandler.loadSubjectDetails(subjectPaperFile, paperInfoFile);
        StudentHandler.loadStudentInfoDetails(studentInfoFile, marksFile);
        show();
        clear();

    }
    public static void clear(){
        PaperHandler.paperDetails.clear();
        StudentHandler.studentDetails.clear();
    }
    public static final String writerPath ="/home/dsi/work/Learning Java/Basic java/ResultProcessing/src/dsi/sams/util/outPutFiles/result.csv";
    public static void show(){
        try (PrintWriter pw = new PrintWriter(writerPath)) {
            StudentHandler.studentDetails.keySet().stream().map((rollNo -> StudentHandler.studentDetails.get(rollNo))).forEach(pw::println);
        }
        catch (IOException e){
            System.out.println(e );
        }
    }


}

