package dsi.sams.Handler;

import java.util.List;

public class ResultHandler {
    FileHandler fileHandler =new FileHandler();

    /**
     * this method will read all those files
     * then store all file information in a list and break it down in its necessary part
     * after that It will create a list for output
     * then it sends that list to file Writer to write my desire file.
     */
    public void resultGenerator(){
       List<String> markers= fileHandler.fileReader("marks.csv");
       List<String> paperInfo= fileHandler.fileReader("paper_info.csv");
       List<String> studentInfo= fileHandler.fileReader("student_info.csv");
       List<String> subjectInfo= fileHandler.fileReader("subject_name.csv");
       List<String> subjectPaper= fileHandler.fileReader("subject_paper.csv");

       markers.forEach(System.out::println);


















        fileHandler.fileWriter("");
    }
}
