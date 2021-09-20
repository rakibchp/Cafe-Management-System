/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Product;
/**
 *
 * @author Asus
 */
public class ProductDao {
    
    public static void save(Product product){
        String query = "INSERT INTO product(name,category,price) values('"+product.getName()+"','"+product.getCategory()+"','"+product.getPrice()+"') ";
        DbOperations.setDataorDelete(query, "Product added successfully");
    }
    
    public static ArrayList<Product> getAllRecords(){
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from product");
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));
                arrayList.add(product);
                
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void update(Product product){
        String query = "update product set name='"+product.getName()+"', category='"+product.getCategory()+"', price='"+product.getPrice()+"' where id='"+product.getId()+"' ";
        DbOperations.setDataorDelete(query,"Product updated successfully");
        
    }
    public static void delete(String id){
        String query = "select * from product whete id='"+id+"'";
        DbOperations.setDataorDelete(query,"Product Deleted successfully");
    }
    
    public static ArrayList<Product> getAllRecordsByCategory(String category){
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from product where category='"+category+"'");
            while(rs.next()){
                Product product = new Product();
                product.setName(rs.getString("name"));
                arrayList.add(product);
  
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static ArrayList<Product> filterProductByName(String name, String category){
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from product where name like '%"+name+"%' and category='"+category+"'");
            while(rs.next()){
                Product product = new Product();
                product.setName(rs.getString("name"));
                arrayList.add(product);
  
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    
     public static Product getProductByName(String name){
        Product product = new Product();
       
        try{
            ResultSet rs = DbOperations.getData("select * from product where name='"+name+"'");
            while(rs.next()){
                 
                product.setName(rs.getString(2));
                product.setCategory(rs.getString(3));
                product.setPrice(rs.getString(4));
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return product;
    }
}
