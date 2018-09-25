package Dictionary;
import java.util. *;
/**
 *
 * @author Win10
 */
public class Dictionary {
    private ArrayList<Word> list ;
    public Dictionary(){
        list =  new ArrayList<>();
        ListIterator it = list.listIterator();
    }
    public void addWord(String target, String explain){
        list.add(new Word(target,explain));
    }
}