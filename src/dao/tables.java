/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class tables {
    public static void main(String[] args) {
        try{
            String userTable = "create table user(id int AUTO_INCREMENT primary key, name varchar(45), email varchar(45), mobileNumber varchar(45), address varchar(45), password varchar(45), securityQuestion varchar(100), answer varchar(45), status varchar(20), UNIQUE (email)";
            String adminDetails = "insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('admin','admin@gmail.com','01727132025','Dhaka','789','What is your favourite food?','cake','true')";
            String categoryTable = "create table category(id int AUTO_INCREMENT primary key, name varchar(45))";
            String productTable = "create table product(id int AUTO_INCREMENT primary key, name varchar(45), category varchar(45, price varchar(45)))";
            String billTable = "create table bill(id int AUTO_INCREMENT primary key, name varchar(45), mobileNumber varchar(45), email varchar(45), date varchar(45),total varchar(45),createdBy varchar(45))";
            
            DbOperations.setDataorDelete(userTable, "user table created successfully");
            DbOperations.setDataorDelete(categoryTable, "category table created successfully");
            DbOperations.setDataorDelete(productTable, "product table created successfully");
            DbOperations.setDataorDelete(adminDetails, "Admin details added successfully");
            DbOperations.setDataorDelete(billTable, "Bill table created successfully");
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
 
    
}
