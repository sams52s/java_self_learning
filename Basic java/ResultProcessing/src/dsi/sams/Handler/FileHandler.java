package dsi.sams.Handler;


import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class FileHandler {

    /**
     * This method will read my all file.
     * @param fileName the file path I want read.
     * It will return all values as list
     * @return
     */

    public HashMap<Integer,String[]> fileReader(String fileName){
        String filePath = "/home/dsi/work/Learning Java/Basic java/ResultProcessing/src/dsi/sams/util/providedFiles/" + fileName;
        HashMap<Integer,String[]> fileContainer=new HashMap<>();
        String line="";
        try {
            BufferedReader bufferedReader =new BufferedReader(new FileReader(filePath));
            int i=1;
            while ((line=bufferedReader.readLine())!=null){
                String[] value=line.split(":");
                fileContainer.put(i,value);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContainer;
    }


    /**
     * This method writes two csv file markSheet and result file.
     * @param fileName is for naming that csv file
     * This method will take a listed parameter and use those to write it.
     */
    public void fileWriter(String fileName /*Listed parameter */){
        //..
    }

}
