package dsi.sams.Handler;

import dsi.sams.Entity.PaperInfo;
import dsi.sams.Entity.StudentInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StudentHandler {
    public static Map<Integer, StudentInfo> studentDetails = new HashMap<>(); //HasMap to store Student Info in a hasMap
    public static Map<Integer, PaperInfo> paperDetails = new HashMap<>();

    public static void loadStudentInfoDetails(String studentsInfoFile, String marksFile){
        // parse
        String line="";
        try {
            BufferedReader bufferedReader =new BufferedReader(new FileReader(studentsInfoFile));
            while ((line=bufferedReader.readLine())!=null){
                String[] value=line.split(":");
                int rollNo = Integer.parseInt(value[0]);
                String name = value[1];
                studentDetails.put(rollNo, new StudentInfo(rollNo, name));
            }
            loadStudentMarkDetails(marksFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method read marks.csv file and give all necessary information
     * @param marksFile file path of marks.csv
     */
    private static void loadStudentMarkDetails(String marksFile){
        // parse
        String line="";
        try {
            BufferedReader bufferedReader =new BufferedReader(new FileReader(marksFile));
            while ((line=bufferedReader.readLine())!=null){
                String[] value=line.split(":");
                int rollNo = Integer.parseInt(value[0]);//First column which is the roll Number of students.
                StudentInfo studentInfo = studentDetails.get(rollNo);//getting all value for rollNo which is keySet of this HasMap.
                int paperCode = Integer.parseInt(value[1]);//paper codes. Column number 2
                int theoryMark = Integer.parseInt(value[4]); //Theory mark of each paper
                int paperMark = Integer.parseInt(value[5]);//Practical mark of each paper
                updateStudentMark(studentInfo, paperCode, theoryMark, paperMark); //Sending all info to the update Student Mark function.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *this method is for result.csv
     * this method will give info to StudentInfo.
     */
    private static void updateStudentMark(StudentInfo studentInfo, int paperCode, int theoryMark, int practicalMark){
        PaperInfo paperInfo = PaperHandler.paperDetails.get(paperCode);
        boolean isPass = true;
        if (theoryMark< paperInfo.getTheoryMark()/2 || practicalMark < paperInfo.getPracticalMark()/2){
            isPass = false;
        }

        paperInfo.addOrUpdateMarkSheet(studentInfo.getRoll(), paperInfo.getSubjectCode(), theoryMark+practicalMark, isPass);
        studentInfo.addOrUpdateMarks(paperInfo.getSubjectCode(), theoryMark+practicalMark, isPass);

    }

    static void clear(){
        studentDetails.clear();
    }
}
