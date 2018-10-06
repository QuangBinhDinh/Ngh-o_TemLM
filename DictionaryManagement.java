
package Dictionary;
import java.io. *;
import java.util. *;
import java.sql. *;
public class DictionaryManagement  {
    private final String className = "com.mysql.cj.jdbc.Driver";//dung cho Class.forName, khong can thiet neu jdk > 6 
    private final String url = "jdbc:mysql://localhost:3306/first_table";//url cu, dung van duoc nhung se khong an toan
    private final String newUrl = "jdbc:mysql://localhost:3306/first_table?verifyServerCertificate=false&useSSL=true";
    //cau truc url jdbc:mysql://localhost:3306/ten_database
    private String user = "root";//ten tai khoan mysql
    private String pass = "cyberenddragon99";//mat khau
    private String table = "dictionary";
    private Connection con;
    private Scanner sc = new Scanner(System.in);
    public void insertFromFile(Dictionary d) throws IOException{
        //ham insert du lieu tu file
        String s,word,mean;
        InputStream in = new FileInputStream("Dict.txt");
        Reader rd = new InputStreamReader(in,"UTF-8");//doc file theo dinh dang UTF-8 (co dau)
        BufferedReader br = new BufferedReader(rd);
        while((s = br.readLine()) != null){
            //lenh readLine doc tung doc mot
            word = s.substring(0, 17).trim();
            mean = s.substring(17).trim();
            d.addWord(word, mean); 
        }
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
    public  void dictionaryLookUp(Dictionary d){
        String word;
        System.out.println("Choose word want to look up:");
        word = sc.next();
        d.showWord(word);
    }
    public void showAllWords(Dictionary d){
        //show toan bo tu trong tu dien
        d.showAll();
        System.out.println();
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
        try{
            while(rs.next()){
                d.addWord(rs.getString(2), rs.getString(3));
                //lay du lieu tu column 2 va 3 cua ban ghi
            }
        }catch(SQLException e){
            System.out.println("An error has occured");
            System.out.println(e.getMessage());
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
