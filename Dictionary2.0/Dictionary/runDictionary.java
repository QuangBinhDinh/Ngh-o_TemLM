package Dictionary;
import java.io.*;
/**
 *
 * @author Win10
 */
public class runDictionary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        DictionaryManagement dm = new DictionaryManagement();
        Dictionary dict = new Dictionary();
        dm.Connect();
        dm.insertFromDatabase(dict, dm.getData());
        dm.showAllWords(dict);
    }
}