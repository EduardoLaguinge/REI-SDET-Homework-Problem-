package Tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class DataBaseReader {

    /**
     * This method helps me to get my vocabylary/dictionary mock.
     * First, this method reads a txt and then returns a collection's words without
     * duplicate Strings/Words
     * @return --> wordsMock
     */
    public static Set<String> getMyMock(){
        Set<String> wordsMock = new TreeSet<>();
        BufferedReader myReader = null;
        try {
            myReader = new BufferedReader(new FileReader(DataBaseReader.class.getClassLoader().getResource(GlobalConfig.DATA_BASE_TXT).getFile()));
            String line = null;
            /**
             *  The first word that I can read on my .TXT could be different from null,
             * I will add it on my collection called wordsMock. Otherwise I don't add
             * anything and then close my execution.
             */
            while ((line = myReader.readLine()) != null){
                wordsMock.add(Util.capitalize(line));
            }
            myReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return wordsMock;
    }
}