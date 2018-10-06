
package Dictionary;
import java.util. *;
/**
 *
 * @author Win10
 */
public class Dictionary {
    private Set<Word> list ;
   
    public Dictionary(){
        list =  new TreeSet<>(new WordComparator());
        //khoi tao 1 set voi Comparator( bo so sanh)
        //xem WordCompartor,java de biet them chi tiet
    }
    public void addWord(String target, String explain){
        list.add(new Word(target,explain));//ham them tu vao set
    }
    public void remove(String word){
       Iterator it = list.iterator();//dung iterator de duyet 
        while(it.hasNext()){
            //duyet den phan tu can duoc xoa
            Word w = (Word) it.next();
            if(w.getTarget() == word){
                list.remove(w);
                
            }
        }
    }
    public void editMeaning(String word){
       Iterator it = list.iterator();
        while(it.hasNext()){
            Word w = (Word) it.next();
            if(w.getTarget() == word){
                //duyet den phan tu can duoc sua
                  System.out.println("Enter the new meaning: ");
                  Scanner sc = new Scanner(System.in);
                  String s= sc.nextLine();
                  w.setExpalin(s);
            }
        }
    }
    public void showWord(String word){
        Iterator it = list.iterator();//dung iterator de duyet
        while(it.hasNext()){
            Word w = (Word) it.next();
            if(w.getTarget() == word){
                //duyet den phan tu can viet ra
                System.out.println("Word meaning: " + w.getExplain());
            }
        }
        if(!it.hasNext()){
            System.out.println("The word you have entered is not in the dictionary!!!");
            System.out.println("Please enter again!!");
        }
    }
    public void showAll(){
        //in ra toan bo tu co trong tu dien
       Iterator it = list.iterator();//su dung iterator de duyet set
        while(it.hasNext()){
            Word w = (Word) it.next();
            System.out.println("Word target: " + w.getTarget());
            System.out.println("Meaning: " + w.getExplain());
        }
    }
}
