/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;
import java.io. *;
import java.util.Scanner;
import java.io.IOException;

import com.darkprograms.speech.translator.GoogleTranslate;

/**
 *
 * @author Win10
 */
public class DictionaryCommand {
    private Scanner sc = new Scanner(System.in);
    public  void dictionaryLookUp(Dictionary d){
        //ham tim kiem tu
        //chen code graphic vao day
        String word;
        System.out.println("Enter word you want to look up:");
        word = sc.nextLine();
        d.expertSearch(word);
    }
    public void exportToFile(Dictionary d) throws IOException{
        //ham export du lieu tu dien ra 1 file
        System.out.println("Choose file path you want to export");
        String s = sc.nextLine();
        System.out.println("Writting to .txt file");
        d.export(s);
        System.out.println("Export to file completed !!!"); 
    }
    public void showAllWords(Dictionary d){
        //show toan bo tu trong tu dien
        System.out.println("List of all words in dictionary");
        d.showAll();
        System.out.println();
    }
    public void googleTrans(){
        System.out.println("Enter word want to translate");
        String s = sc.nextLine();
        try {
            System.out.println(GoogleTranslate.translate("vi", s));	
	} catch (IOException e) {
            e.getMessage();
	} 
    }
    
    public void voice(){
        //chen code do hoa vao day
        System.out.println("Enter the word want to pronounced");
        String s = sc.nextLine();
        VoiceSpeak voice = new VoiceSpeak(s);
    }
}
