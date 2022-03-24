package dsi.sams.Handler;

import dsi.sams.Entity.PaperInfo;
import dsi.sams.Entity.StudentInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StudentHandler {
    public static Map<Integer, StudentInfo> studentDetails = new HashMap<>();

    public static void loadStudentInfoDetails(String studentsInfoFile, String marksFile){
        // parse
        String line="";
        try {
            BufferedReader bufferedReader =new BufferedReader(new FileReader(studentsInfoFile));
            while ((line=bufferedReader.readLine())!=null){
                String[] value=line.split(":");
                int roolNo = Integer.parseInt(value[0]);
                String name = value[1];
                studentDetails.put(roolNo, new StudentInfo(roolNo, name));
            }
            loadStudentMarkDetails(marksFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadStudentMarkDetails(String filePath){
        // parse
        String line="";
        try {
            BufferedReader bufferedReader =new BufferedReader(new FileReader(filePath));
            while ((line=bufferedReader.readLine())!=null){
                String[] value=line.split(":");

                int roolNo = Integer.parseInt(value[0]);
                StudentInfo studentInfo = studentDetails.get(roolNo);

                int paperCode = Integer.parseInt(value[1]);
                int theoryMark = Integer.parseInt(value[4]);
                int paperMark = Integer.parseInt(value[5]);

                updateStudentMark(studentInfo, paperCode, theoryMark, paperMark);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateStudentMark(StudentInfo studentInfo, int paperCode, int theoryMark, int practicalMark){
        PaperInfo paperInfo = PaperHandler.paperDetails.get(paperCode);
        boolean isPass = true;
        if (theoryMark< paperInfo.getTheoryMark()/2 || practicalMark < paperInfo.getPracticalMark()/2){
            isPass = false;
        }

        studentInfo.addOrUpdateMarks(paperInfo.getSubjectCode(), theoryMark+practicalMark, isPass);
    }

    static void clear(){
        studentDetails.clear();
    }
}
