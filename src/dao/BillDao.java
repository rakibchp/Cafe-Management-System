/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Bill;

/**
 *
 * @author Asus
 */
public class BillDao {
    
    public static String getId(){
        int id = 1;
        try{
            ResultSet rs = DbOperations.getData("select max(id) from bill");
            if(rs.next()){
                id = rs.getInt(1);
                id = id +1;
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }
    
    public static void save(Bill bill){
        String query = "insert into bill values('"+bill.getId()+"','"+bill.getName()+"','"+bill.getMobileNumber()+"','"+bill.getEmail()+"','"+bill.getDate()+"','"+bill.getTotal()+"','"+bill.getCreatedBy()+"')";
        DbOperations.setDataorDelete(null, "Bill details added successfully");
    }
    
    public static ArrayList<Bill> getAllRecordsByInc(String date){
        ArrayList<Bill> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from bill where date like '%"+date+"%'");
            while(rs.next()){
            Bill bill = new Bill();
            bill.setId(rs.getInt("id"));
            bill.setName(rs.getString("Name"));
            bill.setMobileNumber(rs.getString("MobileNumber"));
            bill.setEmail(rs.getString("Email"));
            bill.setDate(rs.getString("Date"));
            bill.setCreatedBy(rs.getString("CreatedBy"));
            arrayList.add(bill);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static ArrayList<Bill> getAllRecordsByDesc(String date){
        ArrayList<Bill> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from bill where date like '%"+date+"%' order By id DESC");
            while(rs.next()){
            Bill bill = new Bill();
            bill.setId(rs.getInt("id"));
            bill.setName(rs.getString("Name"));
            bill.setMobileNumber(rs.getString("MobileNumber"));
            bill.setEmail(rs.getString("Email"));
            bill.setDate(rs.getString("Date"));
            bill.setCreatedBy(rs.getString("CreatedBy"));
            arrayList.add(bill);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
}
