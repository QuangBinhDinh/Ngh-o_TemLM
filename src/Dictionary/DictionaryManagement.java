/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;
import java.io. *;
import java.util. *;
import java.sql. *;
public class DictionaryManagement  {
    private String localhost;//thay doi localhost bang dia chi ipv4 mang LAN de co the connect duoc
    private final String className = "com.mysql.cj.jdbc.Driver";//dung cho Class.forName, khong can thiet neu jdk > 6 
    private String url;
    private String newUrl ;
    //cau truc url jdbc:mysql://localhost:3306/ten_database
    private String user = "quangbinh99";//ten tai khoan mysql
    private String pass = "quangbinh99";//mat khau
    private String table = "tbl_edict";
    private Connection con;
    private Scanner sc ;
    private String target,explain;
    public DictionaryManagement(){
        
        localhost = "localhost";//co the thay doi bang dia chi IPv4 mang LAN dang dung
        url = "jdbc:mysql://" + localhost + ":3306/first_table";//url cu, dung van duoc nhung se khong an toan
        newUrl = "jdbc:mysql://" + localhost +":3306/first_table?verifyServerCertificate=false&useSSL=true";
       
    }           
    public void insertFromFile(Dictionary d) throws IOException{
        //ham insert du lieu tu file
        String s,x;
        System.out.println("Enter the file path want to insert");
        x = sc.nextLine();
        System.out.println("Adding word to dictionary...");
        InputStream in = new FileInputStream(x);
        Reader rd = new InputStreamReader(in,"UTF-8");//doc file theo dinh dang UTF-8 (co dau)
        BufferedReader br = new BufferedReader(rd);
        while((s = br.readLine()) != null){
            //lenh readLine doc tung doc mot
            int i = s.indexOf("<C>");
            target = s.substring(0, i - 1).trim();
            explain = s.substring(i).trim();
            if(explain.startsWith("<C>")||explain.endsWith("<C>")){
                    //cat bot ky tu thua trong String
                    StringBuilder ss = new StringBuilder(explain);
                    ss = ss.delete(0, 16).reverse().delete(0, 20).reverse();
                    i = ss.indexOf("<br");
                    while(i >= 0){
                        ss = ss.delete(i, i + 7);
                        ss = ss.insert(i, "\n");
                        i = ss.indexOf("<br");
                    }
                    i = ss.indexOf("+");
                    while(i >= 0){
                        ss = ss.replace(i, i + 1, "=");
                        i = ss.indexOf("+");
                    }
                    
                    explain = ss.toString();
            }
            d.addWord(target, explain);
        }
        System.out.println("Add word completed !!!");
    }
    public void insertFromCommand(Dictionary d){
        //insert du lieu tu command
        String word,mean;
        System.out.println("Enter word:");
        word = sc.next();
        System.out.println("Enter meaning:");
        mean = sc.next();
        d.addWord(word, mean);
        System.out.println("Add word successful !!!");
    }
    public void editWord(Dictionary d){
        //chinh nghia cua tu
        String word;
        System.out.println("Choose word want to edit meaning: ");
        word = sc.next();
        d.editMeaning(word);
        System.out.println("Edit meaning successful !!!");
    }
    public void removeWord(Dictionary d){
        //xoa tu ra khoi tu dien
        String word;
        System.out.println("Choose word want to remove:");
        word = sc.next();
        d.remove(word);
        System.out.println("Word removed successful !!!");
    }
    
    
    public void Connect() {
         //ham connect toi 1 database
        System.out.println("Connecting to database. Please wait....");
        try{
            con = DriverManager.getConnection(newUrl, user, pass);//tao ra 1 ket noi vao database voi cac tham so url , tk, mk
            System.out.println("Get connection successfull !!");
        
        }catch(SQLException e){
            System.out.println("Error connection!!!");
            System.out.println(e.getMessage());
        }
    }
    public void printDatabase(ResultSet rs){
        //ham in ban ghi cua bang trong database ra console
        try{
            while(rs.next()){
                System.out.printf("%-3d%-15s%-20s", rs.getInt(1),rs.getString(2),rs.getString(3));
                //in du lieu tu column 1,2 ,3 cua ban ghi
                System.out.println();
            }
        }catch(SQLException e){
            System.out.println("An error has occured");
            System.out.println(e.getMessage());
        }
    }
    public void insertFromDatabase(Dictionary d, ResultSet rs){
        //ham insert du lieu tu database
        System.out.println("Adding word to dictionary...");
        int i = 0;
        try{
            while(rs.next()){
                target = rs.getString(2);
                explain = rs.getString(3);
                if(explain.startsWith("<C>")||explain.endsWith("<C>")){
                    StringBuilder ss = new StringBuilder(explain);
                    ss = ss.delete(0, 16).reverse().delete(0, 20).reverse();
                    i = ss.indexOf("<br");
                    while(i >= 0){
                        ss = ss.delete(i, i + 7);
                        ss = ss.insert(i, "\n");
                        i = ss.indexOf("<br");
                    }
                    i = ss.indexOf("+");
                    while(i >= 0){
                        ss = ss.replace(i, i + 1, "=");
                        i = ss.indexOf("+");
                    }
                    
                    explain = ss.toString();
                }
                d.addWord(target, explain);
                //lay du lieu tu column 2 va 3 cua ban ghi
            }
            System.out.println("Adding word complete!!");
        }catch(SQLException e){
            System.out.println("An error has occured");
            System.out.println(e.getMessage()); 
            System.out.println("Add word failed!!");
        }
        
    }
    public ResultSet getData(){
        //ham tra ve ResultSet la ban ghi thong tin co trong bang
        //1 moi gia tri ResultSet la 1 dong trong ban ghi
        ResultSet rs = null;
        String command = "SELECT * FROM " + table;
        //cau lenh trong SQL
        Statement st;
        try{
            st = con.createStatement();//tao ra 1 statement(trang thai) tu connection
            rs = st.executeQuery(command);//thuc thu cau lenh cua command
        }catch(SQLException | NullPointerException e){
            System.out.println("An error has occured");
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
}
