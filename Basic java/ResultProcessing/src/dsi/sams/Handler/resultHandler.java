package dsi.sams.Handler;

import java.util.ArrayList;
import java.util.List;

public class resultHandler {
    fileHandler fileUHandler=new fileHandler();

    /**
     * this method will read all those files
     * then store all file information in a list and break it down in its necessary part
     * after that It will create a list for output
     * then it sends that list to file Writer to write my desire file.
     */
    public void resultGenerator(){
       List list=new ArrayList();
       list= fileUHandler.FileReader("marks.csv");
        list.forEach(System.out::println);
        fileUHandler.FileWriter("");
    }
}
