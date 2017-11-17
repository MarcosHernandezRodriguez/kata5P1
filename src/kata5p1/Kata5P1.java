/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcos
 */
public class Kata5P1 {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        // TODO code application logic here
        
        Class.forName("org.sqlite.JDBC");	
        Connection con = DriverManager.getConnection("jdbc:sqlite:C:/Users/Marcos/PEOPLE.db");
                
        Statement st = con.createStatement();
        
        String query = "SELECT * FROM PEOPLE";
        ResultSet rs = st.executeQuery(query);
        
        String query2 = "CREATE TABLE IF NOT EXISTS MAIL('Id' INTEGER PRIMARY KEY AUTOINCREMENT , 'Mail' TEXT NOT NULL);";      
        st.execute(query2);
        
        
        
        String filename = "C:/Marcos/Universidad/Tercer Año/IS2/emails.txt";    
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            String mail;
            
            while((mail = reader.readLine()) != null){
                if(!mail.contains("@")){
                    continue;
                }
                query ="INSERT INTO MAIL (mail) VALUES ('" + mail + "')";
                st.executeUpdate(query);
                
            }
        } catch(FileNotFoundException ex){}
        
        
        
        
        String mail = "";
        String query3 = "insert into mail (Mail) VALUES ('" + mail + "');";      
        st.execute(query3);
        
        String query4 = "SELECT COUNT (*) FROM MAIL";      
        ResultSet rs4 = st.executeQuery(query4);
        
        
        while(rs.next()){
            System.out.println(rs.getInt(1));
        }
        
        
        
    }
    
}
