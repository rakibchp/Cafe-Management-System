/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static com.sun.glass.ui.Cursor.setVisible;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Category;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Asus
 */
public class CategoryDao {
    
    public static void save(Category category){
        String query ="INSERT INTO category (name) values('"+category.getName()+"')";
        DbOperations.setDataorDelete(query, "Category added successfully");
    }
    
    public CategoryDao(){
//        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLocationRelativeTo(null); // Centers the window
//        setTitle("Categoroy");
    }
    
    public static ArrayList<Category> getAllRecords(){
        ArrayList<Category> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from category");
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                arrayList.add(category);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
            
      
    }
    
    public static void delete(String id){
        String query = "delete from category where id ='"+id+"'";
        DbOperations.setDataorDelete(query, "Category deleted successfully");
    }
}
