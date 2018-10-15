/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;
import java.sql. *;
/**
 *
 * @author Win10
 */
public class MyConnection {
    private final String className = "com.mysql.cj.jdbc.Driver";//dung cho Class.forName, khong can thiet neu jdk > 6 
    private final String url = "jdbc:mysql://localhost:3306/first_table";//url cu, dung van duoc nhung se khong an toan
    private final String newUrl = "jdbc:mysql://localhost:3306/first_table?verifyServerCertificate=false&useSSL=true";
    //cau truc url jdbc:mysql://localhost:3306/ten_database
    private String user = "root";//ten tai khoan mysql
    private String pass = "cyberenddragon99";//mat khau
    private String table = "dictionary";
    private Connection con;
    public void Connect() {
        try{
            con = DriverManager.getConnection(newUrl, user, pass);//tao ra 1 ket noi vao database voi cac tham so url , tk, mk
            System.out.println("Get connection successfull !!");
        
        }catch(SQLException e){
            System.out.println("Error connection!!!");
            System.out.println(e.getMessage());
        }
    }
    public void printInfo(ResultSet rs){
        //ham in ban ghi cua bang trong database ra console
        try{
            while(rs.next()){
               String temp = rs.getString(2);
               System.out.println(temp);
            }
        }catch(SQLException e){
            System.out.println("An error has occured");
            System.out.println(e.getMessage());
        }
    }
    public void insertFromDatabase(Dictionary d, ResultSet rs){
        
    }
    private ResultSet getData(){
        //ham tra ve ResultSet la ban ghi thong tin co trong bang
        ResultSet rs = null;
        String command = "SELECT * FROM " + table;
        Statement st;
        try{
            st = con.createStatement();//tao ra 1 statement(trang thai) tu connection
            rs = st.executeQuery(command);//thuc thu cau lenh cua command
        }catch(SQLException e){
            System.out.println("An error has occured");
            System.out.println(e.getMessage());
        }
        return rs;
    }
}
