package dsi.sams.Handler;

import dsi.sams.Entity.PaperInfo;
import dsi.sams.Entity.StudentInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PaperHandler {
    public static Map<Integer, PaperInfo> paperDetails = new HashMap<>();//For storing mark_sheet.csv value.

    public static void loadSubjectDetails(String subjectPaperFile, String paperInfoFile){
        loadSubjectCode(subjectPaperFile);
        loadPaperDetails(paperInfoFile);
    }

    /**
     * @param filePath SubjectPaper.csv will read here.
     */
    private static void loadSubjectCode(String filePath){
        String line="";
        try {
            BufferedReader bufferedReader =new BufferedReader(new FileReader(filePath));
            while ((line=bufferedReader.readLine())!=null){
                String[] value=line.split(":");
                int subjectCode = Integer.parseInt(value[0]);
                int paperCode = Integer.parseInt(value[1]);
                paperDetails.put(paperCode, new PaperInfo(paperCode, subjectCode));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param filePath this method read PaperInfo.csv file
     */
    private static void loadPaperDetails(String filePath){
        String line="";
        try {
            BufferedReader bufferedReader =new BufferedReader(new FileReader(filePath));
            while ((line=bufferedReader.readLine())!=null){
                String[] value=line.split(":");
                int paperCode = Integer.parseInt(value[0]);
                int theoryMark = Integer.parseInt(value[5]);
                int practicalMark = Integer.parseInt(value[6]);
                PaperInfo paperInfo = paperDetails.get(paperCode);
               paperInfo.setTheoryMark(theoryMark);
                paperInfo.setPracticalMark(practicalMark);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void clear(){
        paperDetails.clear();
    }

}
