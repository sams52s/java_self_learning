package dsi.sams.Handler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class fileHandler {

    /**
     * This method will read my all file.
     * @param fileName the file path I want read.
     * It will return all values as list
     * @return
     */
    public List<String> FileReader(String fileName){
        String filePath="/home/dsi/work/Learning Java/Basic java/ResultProcessing/src/dsi/sams/util/providedFiles/"+fileName;
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {

            list = stream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * This method writes two csv file markSheet and result file.
     * @param fileName is for naming that csv file
     * This method will take a listed parameter and use those to write it.
     */
    public void FileWriter(String fileName/* Listed parameter */){
        //..
    }

}
