/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;
import java.io. *;
import java.util. *;
/**
 *
 * @author Win10
 */
public class Dictionary {
    private Set<Word> list ;
    
    public Dictionary(){
        list = new TreeSet<>(new WordComparator());
       
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
            if(w.getTarget().equals(word)){
                list.remove(w);
                
            }
        }
    }
    public void editMeaning(String word){
        //sua nghia cua tu
       Iterator it = list.iterator();
        while(it.hasNext()){
            Word w = (Word) it.next();
            if(w.getTarget().equalsIgnoreCase(word)){
                //duyet den phan tu can duoc sua
                  System.out.println("Enter the new meaning: ");
                  Scanner sc = new Scanner(System.in);
                  String s= sc.nextLine();
                  w.setExpalin(s);
            }
        }
    }
   
    public String showWord(String word){
        //ham tra ve string
        Iterator it = list.iterator();//dung iterator de duyet
        String re = null;
        int i = 0;
        while(it.hasNext()){
            Word w = (Word) it.next();
            if(w.getTarget().equalsIgnoreCase(word)){
                //duyet den phan tu can viet ra
                re = w.getExplain();
                i =1;
            }
        }
        if(i == 0) re = "Tu da nhap khong co trong tu dien. Moi nhap lai !!!";
        return re;
    }
    public void expertSearch(String word){
        //ham search nang cao
        Iterator it = list.iterator();
        Set<Word> sub = new TreeSet<>(new WordComparator());
        int j = 0;
        while(it.hasNext()){
            if(j < 10){
                Word w = (Word) it.next();
                if(w.getTarget().startsWith(word)){
                    sub.add(new Word(w.getTarget(),w.getExplain()));
                    ++j;
                }
            }else break;
        }
        //set sub chi chua toi da 10 phan tu
        
        if(sub.size() == 0) System.out.println("No word avaiable in dictionary. Please enter again!!!");
        else{
            Iterator itt = sub.iterator();
            System.out.println("List of avaiable word.");
            while(itt.hasNext()){
                Word x = (Word) itt.next();
                System.out.println(x.getTarget());
            }
            System.out.println("Choose word want to translate: ");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            System.out.println(showWord(s));
        }
        
    }
    public void showAll(){
        //in ra toan bo tu co trong tu dien
        Iterator it = list.iterator();//su dung iterator de duyet set
        int i=0;
        while(it.hasNext()){
            ++i;
            Word w = (Word) it.next();
            System.out.println(i + ": "  + w.getTarget());
            //chen code do hoa vao day w.getTarget tra ve tu do
        }
    }
    public void export(String s) throws IOException {
        Writer w = new FileWriter(s);
        BufferedWriter bw = new BufferedWriter(w);
        bw.write("                      List of word in dictionary");
        bw.newLine();bw.newLine();
        bw.write("WordTarget     WordExplain ");bw.newLine();
        Iterator it = list.iterator();//su dung iterator de duyet set
        while(it.hasNext()){
            Word w1 = (Word) it.next();
           
            bw.write(w1.getExplain());bw.newLine();
        }
    }
}
