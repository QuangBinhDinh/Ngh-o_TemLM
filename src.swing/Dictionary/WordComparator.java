/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;
import java.util.Comparator;
/**
 *
 * @author Win10
 */
public class WordComparator implements Comparator<Word> {
    //bo so sanh dung de cai dat trong Set<Word>
    @Override
    public int compare(Word w1, Word w2){
        //override phuong thuc compare cua abstract class Comparator
        return w1.getTarget().compareTo(w2.getTarget());
        //sap xep theo bang chu cai
    }
}
