package dsi.sams.Handler;

import java.util.HashMap;

public class ResultHandler {
    FileHandler fileHandler =new FileHandler();
    /**
     * this method will read all those files
     * then store all file information in a list and break it down in its necessary part
     * after that It will create a list for output
     * then it sends that list to file Writer to write my desire file.
     */
    public void resultGenerator(){
        //I have read all files here
        HashMap<Integer,String[]> markers= fileHandler.fileReader("marks.csv");
        HashMap<Integer,String[]> studentInfo= fileHandler.fileReader("student_info.csv");
         HashMap<Integer,String[]> paperInfo= fileHandler.fileReader("paper_info.csv");
         HashMap<Integer,String[]> subjectInfo= fileHandler.fileReader("subject_name.csv");
         HashMap<Integer,String[]> subjectPaper= fileHandler.fileReader("subject_paper.csv");


         HashMap<Integer, SubjectHandler> subjectDetails= new HashMap<>();
         //subjectDetails.put(subjectPaper.get(2))
        /**
         * Taking all subject values and storing it in a HashMap.
         * reading all paper value and calling SubjectHandler class contracture .
         */
        for(int i=1;i<subjectPaper.size()+1;i++){
            SubjectHandler SubjectHandler= new SubjectHandler(
                    Integer.parseInt(subjectPaper.get(i)[1]),
                    Integer.parseInt(subjectPaper.get(i)[0]),
                    Integer.parseInt(paperInfo.get(i)[5]),
                    Integer.parseInt(paperInfo.get(i)[6]),
                    paperInfo.get(i)[3],
                    paperInfo.get(i)[4],
                    Integer.parseInt(paperInfo.get(i)[5])/2,
                    Integer.parseInt(paperInfo.get(i)[6])/2
                    );
            subjectDetails.put(Integer.parseInt(subjectPaper.get(i)[1]),SubjectHandler);
        }
        System.out.println( subjectDetails.values());


        fileHandler.fileWriter("");
    }
}
