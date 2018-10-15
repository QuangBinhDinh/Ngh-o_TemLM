
package Dictionary;
import java.io.*;
import java.util.Scanner;

public class runDictionary {
    
    public void deleteConsole(){
        for(int i=0 ;i < 30; i++){
            System.out.println();
        }
    }
    public void waitPress(){
        Scanner cs = new Scanner(System.in);
        System.out.println("Press enter to continue...");
        String h = cs.nextLine();
    }
    public static void main(String[] args) throws IOException{
        runDictionary run = new runDictionary();
        Scanner sc = new Scanner(System.in);
        String pass = "88888888";
        boolean b = true, c = true;
        System.out.println("\t" + "\t" + " \t" + "\t" + "TU DIEN ANH - VIET");
        System.out.println();
        System.out.println();
        Dictionary dict = new Dictionary();
        DictionaryManagement dm = new DictionaryManagement();
        DictionaryCommand dc = new DictionaryCommand();
        System.out.println("Please select the following option...");
        System.out.println(" 1: Insert dictionary by connecting to database");
        System.out.println(" 2: Insert dictionary by file.");
        int k = Integer.parseInt(sc.nextLine());
        switch(k){
            case 1:
                dm.Connect();
                dm.insertFromDatabase(dict, dm.getData());

                break;
            case 2:
                dm.insertFromFile(dict);
                break;
        }
        while(b){
            System.out.println(" 1: Look up words");
            System.out.println(" 2: Import all word to command line");
            System.out.println(" 3: Translate paragraph (online)");
            System.out.println(" 4: Dictionary settings");
            System.out.println(" 5: Import all word to file");
            System.out.println(" 6: Word pronouncing (online)");
            System.out.println(" 7: Quit program");
            System.out.println("\t" + "\t" + "Please enter selection (1-7):");
            int i = Integer.parseInt(sc.nextLine());
            switch(i){
                case 1:
                    dc.dictionaryLookUp(dict);
                    run.waitPress();
                    run.deleteConsole();
                    break;
                case 2:
                    dc.showAllWords(dict);
                    run.waitPress();
                    run.deleteConsole();
                    break;
                case 3:
                    dc.googleTrans();
                    run.waitPress();
                    run.deleteConsole();
                    break;
                case 4:
                    System.out.println("Please enter the password");
                    String s = sc.nextLine();
                    while(!s.equals(pass)){
                        System.out.println("Wrong password. Please try again !!!");
                        s = sc.nextLine();
                    }
                    run.deleteConsole();
                    while(c){
                        System.out.println(" 1: Add word to dictionary by command line ");
                        System.out.println(" 2: Add word to dictionary by text file");
                        System.out.println(" 3: Edit word ");
                        System.out.println(" 4: Delete word");
                        System.out.println(" 5: Back to main menu");
                        System.out.println("\t" + "\t" + "Please enter the selection (1-5):");
                        int j = Integer.parseInt(sc.nextLine());
                        switch(j){
                            case 1:
                                dm.insertFromCommand(dict);
                                run.waitPress();
                                run.deleteConsole();
                                break;
                            case 2:
                                dm.insertFromFile(dict);
                                run.waitPress();
                                run.deleteConsole();
                                break;
                            case 3:
                                dm.editWord(dict);
                                run.waitPress();
                                run.deleteConsole();
                                break;
                            case 4:
                                dm.removeWord(dict);
                                run.waitPress();
                                run.deleteConsole();
                                break;
                            case 5:
                                c = false;//nhay khoi vong lap while(c) -> quay tro ve menu chinh
                                run.deleteConsole();
                                break;
                            default:
                                System.out.println("Wrong selection. Please select again !!!");
                                System.out.println();
                                break;
                        }
                    }
                    break;
                case 5:
                    dc.exportToFile(dict);
                    run.waitPress();
                    run.deleteConsole();
                    break;
                
                case 6:
                    dc.voice();
                    run.waitPress();
                    run.deleteConsole();
                    break;
                case 7:
                    b = false;
                    break;
                default:
                    System.out.println("Wrong selection. Please select again !!!");
                    System.out.println();
                    break;
            }
        } 
    }
}
